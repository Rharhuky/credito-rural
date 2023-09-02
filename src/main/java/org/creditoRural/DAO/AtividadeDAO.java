package org.creditoRural.DAO;

import org.creditoRural.domain.Atividade;
import org.creditoRural.domain.DTO.AtividadeDTO;
import org.creditoRural.domain.DTO.DTO;

public class AtividadeDAO extends DAO<Atividade>{

    public AtividadeDAO(){
        super(Atividade.class);
    }

    @Override
    public DAO<Atividade> updateById(Long id, DTO<Atividade> anotherEntity) {

        Atividade atv = super.findById(id);
        super.detach(atv);
        this.map(atv, anotherEntity);
        super.update(atv);
        return this;

    }

    @Override
    protected Atividade map(Atividade entityToMap, DTO entityDTO) {

        AtividadeDTO dto = (AtividadeDTO) entityDTO;
        entityToMap.setObjetivo(dto.getObjetivo());
        entityToMap.setTipoAtividade(dto.getTipoAtividade());
        return entityToMap;

    }

}
