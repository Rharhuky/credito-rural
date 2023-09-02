package org.creditoRural.DAO;

import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.DTO.PropriedadeDTO;
import org.creditoRural.domain.Pessoa;
import org.creditoRural.domain.Propriedade;

import java.util.Objects;

public class PropriedadeDAO extends DAO<Propriedade>{

    private PessoaDAO pessoaDAO;

    public PropriedadeDAO() {
        super(Propriedade.class);
    }

    @Override
    public DAO<Propriedade> updateById(Long id, DTO<Propriedade> anotherEntity) {

        Propriedade propriedade = super.findById(id);
        detach(propriedade);
        Propriedade propriedadeUpdated = this.map(propriedade, anotherEntity);
        update(propriedadeUpdated);
        return this;

    }


    @Override
    protected Propriedade map(Propriedade entityToMap, DTO entityDTO) {

        PropriedadeDTO dto =  (PropriedadeDTO) entityDTO;
        entityToMap.setCep(dto.getCep());
        entityToMap.setRegiao(dto.getRegiao());
        entityToMap.setNome(dto.getNome());

//        if( ! Objects.isNull(dto.getPessoaId()) ){
//
//            Long entityId = entityToMap.getId();
//            Long pessoaDtoId = dto.getPessoaId();
//
//            if( entityId != null) {
//
//                if(entityId .equals( pessoaDtoId) ){
//
//                    entityToMap.get
//
//                }
//
//            }
//        }

        if(dto.getPessoaId() != null) {
            this.pessoaDAO = new PessoaDAO();
            Pessoa p = pessoaDAO.findById(dto.getPessoaId());
            entityToMap.setPessoa(p);

        }
        return entityToMap;

    }

    /**
     * Persistir para uma pessoa já existente.
     * @param propriedade
     * @param idPessoa
     * @return
     */
    public DAO<Propriedade> persist(Propriedade propriedade, Long idPessoa){

        this.pessoaDAO = new PessoaDAO();
        Pessoa pessoa = pessoaDAO.findById(idPessoa);

        if(Objects.isNull(pessoa))
            throw new RuntimeException("CARAMBOLAS");

        pessoa.adicionarPropriedade(propriedade);
        propriedade.setPessoa(pessoa);

        super.persist(propriedade);
        return this;

    }

}
