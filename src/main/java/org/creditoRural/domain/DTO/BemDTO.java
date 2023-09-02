package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Bem;
import org.creditoRural.domain.enums.TipoBem;

public class BemDTO implements DTO<Bem> {

    private TipoBem tipo;
    private Double preco;
    private Long propriedadeId;

    private BemDTO(Builder builder){
        this.tipo = builder.tipo;
        this.preco = builder.preco;
        this.propriedadeId = builder.propriedadeId;
    }


    public static class Builder{

        private TipoBem tipo;
        private Double preco;
        private Long propriedadeId;

        public Builder setTipo(TipoBem tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder setPreco(Double preco) {
            this.preco = preco;
            return this;
        }

        public Builder setPropriedadeId(Long propriedadeId) {
            this.propriedadeId = propriedadeId;
            return this;
        }

        public BemDTO build(){
            return new BemDTO(this);
        }

    }

    public TipoBem getTipo() {
        return tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public Long getPropriedadeId() {
        return propriedadeId;
    }
}
