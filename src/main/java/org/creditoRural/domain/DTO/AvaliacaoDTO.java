package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Avaliacao;

public class AvaliacaoDTO implements DTO<Avaliacao> {

    private Boolean deferido;
    private Double valor;

    public AvaliacaoDTO(Builder builder) {
        this.deferido = builder.deferido;
        this.valor = builder.valor;
    }

    public static class Builder {

        private Boolean deferido;
        private Double valor;


        public Builder setDeferido(Boolean deferido) {
            this.deferido = deferido;
            return this;
        }

        public Builder setValor(Double valor) {
            this.valor = valor;
            return this;
        }

        public AvaliacaoDTO build(){
            return new AvaliacaoDTO(this);
        }
    }

    public Boolean getDeferido() {
        return deferido;
    }

    public Double getValor() {
        return valor;
    }
}
