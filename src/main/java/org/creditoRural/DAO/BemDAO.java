package org.creditoRural.DAO;

import jakarta.persistence.TypedQuery;
import org.creditoRural.domain.Bem;
import org.creditoRural.domain.Propriedade;
import org.creditoRural.domain.enums.TipoBem;

import java.util.List;

/**
 * DAO para classe Bem.
 */
public class BemDAO extends DAO<Bem> {

    private PropriedadeDAO propriedadeDAO;

    public BemDAO() {

        super(Bem.class);

    }

    /**
     * Método ideal para persistir uma entidade Bem que tem relação com uma entidade Propriedade já existente.
     * @param bem
     * @param propriedadeId
     * @return DAO
     */
    public DAO<Bem> persistir(Bem bem, Long propriedadeId) {

        this.propriedadeDAO = new PropriedadeDAO();

//        entityManager.getTransaction().begin();
//
//        Propriedade propriedade = entityManager.find(Propriedade.class, propriedadeId);
//        System.out.println(propriedade);
//        bem.setPropriedade(propriedade);
//        propriedade.adicionarBem(bem);
//
//        entityManager.persist(bem);
//        entityManager.getTransaction().commit();

            openConnexion();

            Propriedade propriedade = propriedadeDAO.findById(propriedadeId);

            openTransaction();

            propriedade.adicionarBem(bem);
            bem.setPropriedade(propriedade);

            persist(bem)
                    .commitTransaction()
                    .closeConnexion();


        return this;

    }

}
