package org.creditoRural.DAO;

import org.creditoRural.domain.Atividade;
import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.Projeto;
import org.creditoRural.domain.Propriedade;
import org.creditoRural.exceptions.EntidadeNaoExisteException;

import java.util.Objects;

public class ProjetoDAO extends DAO<Projeto> {

    public ProjetoDAO(){
        super(Projeto.class);
    }

    @Override
    public DAO<Projeto> updateById(Long id, DTO<Projeto> anotherEntity) {
        return null;
    }

    @Override
    protected Projeto map(Projeto entityToMap, DTO entityDTO) {
        return null;
    }

    //TODO add project to existent Propriedade - DONE


    /**
     * Adicionar um projeto para uma propriedade existente
     * @param projeto instancia de Projeto que será persistida
     * @param propriedadeId id da propriedade existente
     * @return
     */
    public DAO<Projeto> persistToExistentPropriedade(Projeto projeto, Long propriedadeId){

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();

        Propriedade propriedade = propriedadeDAO.findById(propriedadeId);

        if(Objects.isNull(propriedade))
            throw new EntidadeNaoExisteException();

        propriedade.adicionarProjeto(projeto);
        projeto.setPropriedade(propriedade);

        return this;

    }





}
