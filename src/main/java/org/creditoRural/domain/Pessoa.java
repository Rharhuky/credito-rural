package org.creditoRural.domain;

import jakarta.persistence.*;
import org.creditoRural.exceptions.EntidadeNaoExisteException;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pessoas")
public class Pessoa extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nome_conjugue", nullable = false)
    private String nomeConjugue;

    @Column(nullable = false)
    private String profissao;

    @Column(nullable = false, unique = true)
//    @CPF
    private String cpf;

    @Column
    private String celular;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Propriedade> propriedades = new ArrayList<>();


    public Pessoa(String nome, LocalDate dataNascimento, String nomeConjugue, String profissao, String cpf, String celular) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nomeConjugue = nomeConjugue;
        this.profissao = profissao;
        this.cpf = cpf;
        this.celular = celular;
    }

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(argIsNull(nome))
            return;
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(argIsNull(dataNascimento))
            return;
        this.dataNascimento = dataNascimento;
    }

    public String getNomeConjugue() {
        return nomeConjugue;
    }

    public void setNomeConjugue(String nomeConjugue) {
        if(argIsNull(nomeConjugue))
            return;

        this.nomeConjugue = nomeConjugue;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        if(argIsNull(profissao))
            return;

        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(argIsNull(cpf))
            return;

        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if(argIsNull(celular))
            return;
        this.celular = celular;
    }

    public void adicionarPropriedade(Propriedade propriedade){

        if(this.getPropriedades().contains(propriedade))
            throw new EntidadeNaoExisteException();

        this.getPropriedades().add(propriedade);
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedade(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nomeConjugue='" + nomeConjugue + '\'' +
                ", profissao='" + profissao + '\'' +
                ", cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
