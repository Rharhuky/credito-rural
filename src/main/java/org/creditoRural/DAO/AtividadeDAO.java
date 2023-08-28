package org.creditoRural.DAO;

import org.creditoRural.domain.Atividade;
import org.creditoRural.domain.DTO.DTO;

public class AtividadeDAO extends DAO<Atividade>{

    public AtividadeDAO(){
        super(Atividade.class);
    }

    @Override
    public DAO<Atividade> updateById(Long id, DTO<Atividade> anotherEntity) {
        return null;
    }

    @Override
    protected Atividade map(Atividade entityToMap, DTO entityDTO) {
        return null;
    }


}
