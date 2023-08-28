package org.creditoRural.DAO;

import org.creditoRural.domain.Agente;
import org.creditoRural.domain.DTO.DTO;

public class AgenteDAO extends DAO<Agente>{

    public AgenteDAO(){
        super(Agente.class);
    }

    @Override
    public DAO<Agente> updateById(Long id, DTO<Agente> anotherEntity) {
        return null;
    }

    @Override
    protected Agente map(Agente entityToMap, DTO entityDTO) {
        return null;
    }

}
