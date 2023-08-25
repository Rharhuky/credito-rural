package org.creditoRural.domain;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {

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
    private List<Propriedade> propriedade;


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
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeConjugue() {
        return nomeConjugue;
    }

    public void setNomeConjugue(String nomeConjugue) {
        this.nomeConjugue = nomeConjugue;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
