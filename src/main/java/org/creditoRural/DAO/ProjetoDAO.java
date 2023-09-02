package org.creditoRural.DAO;

import org.creditoRural.domain.Atividade;
import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.DTO.ProjetoDTO;
import org.creditoRural.domain.Projeto;
import org.creditoRural.domain.Propriedade;
import org.creditoRural.exceptions.EntidadeNaoExisteException;

import java.util.Objects;

public class ProjetoDAO extends DAO<Projeto> {

    private AtividadeDAO atividadeDAO;
    private PropriedadeDAO propriedadeDAO;

    public ProjetoDAO(){
        super(Projeto.class);
    }

    @Override
    public DAO<Projeto> updateById(Long id, DTO<Projeto> anotherEntity) {

        Projeto projeto = super.findById(id);
        detach(projeto);
        Projeto projetoAtualizado = this.map(projeto, anotherEntity);
        update(projetoAtualizado);
        return this;
    }

    @Override
    protected Projeto map(Projeto entityToMap, DTO entityDTO) {

        ProjetoDTO dto = (ProjetoDTO) entityDTO;

        if(! Objects.isNull(dto.getAtividadeId())) {

            this.atividadeDAO = new AtividadeDAO();
            Atividade atv = atividadeDAO.findById(dto.getAtividadeId());
            entityToMap.setAtividade(atv);
            atv.setProjeto(entityToMap);

        }
        if(! Objects.isNull(dto.getPropriedadeId())) {

            this.propriedadeDAO = new PropriedadeDAO();
            Propriedade propriedade = propriedadeDAO.findById(dto.getPropriedadeId());
            entityToMap.setPropriedade(propriedade);
            propriedade.adicionarProjeto(entityToMap);


        }


        return entityToMap;
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
            throw new EntidadeNaoExisteException(Propriedade.class.getName(), propriedadeId);

        propriedade.adicionarProjeto(projeto);
        projeto.setPropriedade(propriedade);

        super.persist(projeto)
                .commitTransaction();

        return this;

    }


}
