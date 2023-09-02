package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Projeto;

public class ProjetoDTO implements DTO<Projeto> {

    private  Long atividadeId;
    private  Long propriedadeId;
    private ProjetoDTO(Builder builder) {

        this.atividadeId = builder.atividadeId;
        this.propriedadeId = builder.propriedadeId;

    }

    public static class Builder {

        private Long atividadeId;
        private Long propriedadeId;

        public Builder setAtividadeId(Long atividadeId){
            this.atividadeId = atividadeId;
            return this;

        }

        public Builder setPropriedadeId(Long propriedadeId){
            this.propriedadeId = propriedadeId;
            return this;
        }
        public ProjetoDTO build(){
            return new ProjetoDTO(this);
        }
    }

    public Long getAtividadeId() {
        return atividadeId;
    }

    public Long getPropriedadeId() {
        return propriedadeId;
    }



}
