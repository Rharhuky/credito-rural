package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Avaliacao;

public class AvaliacaoDTO implements DTO<Avaliacao> {

    private Long agenteId;
    private Long projetoId;

    public AvaliacaoDTO(Builder builder){
        this.agenteId = builder.agenteId;
        this.projetoId = builder.projetoId;
    }


    public static class Builder {

        private Long agenteId;
        private Long projetoId;

        public Builder setAgenteId(Long agenteId) {
            this.agenteId = agenteId;
            return this;
        }

        public Builder setProjetoId(Long projetoId) {
            this.projetoId = projetoId;
            return this;
        }

        public AvaliacaoDTO build(){
            return new AvaliacaoDTO(this);
        }
    }

    public Long getAgenteId() {
        return agenteId;
    }

    public Long getProjetoId() {
        return projetoId;
    }
}
