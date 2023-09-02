package org.creditoRural.domain.DTO;

import org.creditoRural.domain.Pessoa;

import java.time.LocalDate;

public class PessoaDTO implements DTO<Pessoa>{

    private String nome;
    private LocalDate dataNascimento;
    private String nomeConjugue;
    private String profissao;
    private String cpf;
    private String celular;

    private PessoaDTO(Builder pessoaDTOBuilder) {

        this.dataNascimento = pessoaDTOBuilder.dataNascimento;
        this.nomeConjugue = pessoaDTOBuilder.nomeConjugue;
        this.profissao = pessoaDTOBuilder.profissao;
        this.celular = pessoaDTOBuilder.celular;
        this.nome = pessoaDTOBuilder.nome;
        this.cpf = pessoaDTOBuilder.cpf;

    }

    public static Builder getBuilder(){
        return new Builder();
    }


    public static class Builder{

        private String nome;
        private LocalDate dataNascimento;
        private String nomeConjugue;
        private String profissao;
        private String cpf;
        private String celular;

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder setNomeConjugue(String nomeConjugue) {
            this.nomeConjugue = nomeConjugue;
            return this;
        }

        public Builder setProfissao(String profissao) {
            this.profissao = profissao;
            return this;
        }

        public Builder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder setCelular(String celular) {
            this.celular = celular;
            return this;
        }

        public PessoaDTO build(){
            return new PessoaDTO(this);
        }

    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNomeConjugue() {
        return nomeConjugue;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCelular() {
        return celular;
    }
}
