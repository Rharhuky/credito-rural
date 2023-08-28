package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Propriedade;

public class PropriedadeDTO implements DTO<Propriedade> {

    private String regiao;

    private String nome;

    private Long pessoaId;

    private String cep;

    private PropriedadeDTO(Builder builder){
        this.regiao = builder.regiao;
        this.nome = builder.nome;
        this.pessoaId = builder.pessoaId;
        this.cep = builder.cep;
    }

    public static Builder getBuilder(){

        return new Builder();

    }

    public static class Builder{

        String regiao;
        String nome;
        Long pessoaId;
        String cep;

        public Builder setRegiao(String regiao){
            this.regiao = regiao;
            return this;
        }

        public Builder setNome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder setPessoaId(Long pessoaId){
            this.pessoaId = pessoaId;
            return this;
        }

        public Builder setCep(String cep){
            this.cep = cep;
            return this;
        }

        public PropriedadeDTO build(){
            return new PropriedadeDTO(this);
        }

    }

    public String getRegiao() {
        return regiao;
    }

    public String getNome() {
        return nome;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public String getCep() {
        return cep;
    }
}
