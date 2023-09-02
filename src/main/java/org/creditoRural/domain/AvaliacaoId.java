package org.creditoRural.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class AvaliacaoId {

    private Long agenteId;
    private Long projetoId;

    public AvaliacaoId(Long agenteId, Long projetoId) {
        this.agenteId = agenteId;
        this.projetoId = projetoId;
    }

    public AvaliacaoId() {
    }

    public Long getAgenteId() {
        return agenteId;
    }

    public void setAgenteId(Long agenteId) {
        if(agenteId == null)
            return;
        this.agenteId = agenteId;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        if(projetoId == null)
            return;
        this.projetoId = projetoId;
    }

    @Override
    public String toString() {
        return "AvaliacaoId{" +
                "agenteId=" + agenteId +
                ", projetoId=" + projetoId +
                '}';
    }
}
