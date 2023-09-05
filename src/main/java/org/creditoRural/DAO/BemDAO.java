package org.creditoRural.DAO;

import org.creditoRural.domain.Bem;
import org.creditoRural.domain.DTO.BemDTO;
import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.Propriedade;

import java.util.List;
import java.util.Set;

/**
 * DAO para classe Bem.
 */
public class BemDAO extends DAO<Bem> {

    private PropriedadeDAO propriedadeDAO;

    public BemDAO() {

        super(Bem.class);

    }

    @Override
    public DAO<Bem> updateById(Long id, DTO<Bem> anotherEntity) {
        openTransaction();
        Bem bem = super.findById(id);
        super.detach(bem);
        Bem bemAtualizado = map(bem, anotherEntity);

        super   .update(bem);


        return this;

    }

    @Override
    protected Bem map(Bem entityToMap, DTO entityDTO) {

        BemDTO dto = (BemDTO) entityDTO;
        entityToMap.setTipo(dto.getTipo());
        entityToMap.setPreco(dto.getPreco());

        if(dto.getPropriedadeId() != null){

            this.propriedadeDAO = new PropriedadeDAO();
            Propriedade novaPropriedade = propriedadeDAO.findById(dto.getPropriedadeId());
            entityToMap.setPropriedade(novaPropriedade);

        }

        return entityToMap;
    }

    /**
     * Método ideal para persistir uma entidade Bem relaciona a uma entidade Propriedade já existente.
     * @param bem
     * @param propriedadeId
     * @return DAO
     */
    public DAO<Bem> persistir(Bem bem, Long propriedadeId) {

        this.propriedadeDAO = new PropriedadeDAO();

            Propriedade propriedade = propriedadeDAO.findById(propriedadeId);
            propriedade.adicionarBem(bem);
            bem.setPropriedade(propriedade);

            super.persist(bem)
                    .closeConnexion();

        return this;

    }

    public List<Bem> findByPropriedadeId(Long id){

        return super.query("findBensByPropriedadeId", "id", id);

    }


}
