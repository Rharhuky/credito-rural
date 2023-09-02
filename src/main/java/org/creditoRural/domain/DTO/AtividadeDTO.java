package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Atividade;
import org.creditoRural.domain.enums.TipoAtividade;

public class AtividadeDTO implements DTO<Atividade>{

    private TipoAtividade tipoAtividade;

    private String objetivo;

    private AtividadeDTO(Builder builder) {

        this.tipoAtividade = builder.tipoAtividade;
        this.objetivo = builder.objetivo;
    }


    public static class Builder {

        private TipoAtividade tipoAtividade;
        private String objetivo;

        public Builder setTipoAtividade(TipoAtividade tipoAtividade) {
            this.tipoAtividade = tipoAtividade;
            return this;
        }

        public Builder setObjetivo(String objetivo) {
            this.objetivo = objetivo;
            return this;
        }

        public AtividadeDTO build(){
            return new AtividadeDTO(this);
        }
    }

    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public String getObjetivo() {
        return objetivo;
    }

}
