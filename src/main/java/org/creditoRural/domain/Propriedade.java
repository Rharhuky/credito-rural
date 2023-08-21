package org.creditoRural.domain;

import jakarta.persistence.*;
import org.creditoRural.domain.customConstraint.Cep;

@Entity
@Table(name = "propriedades")
public class Propriedade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id" )
    private Pessoa pessoa;

    //TODO criar anotacao customizada de cep válido - Feito
    @Column(nullable = false)
    @Cep
    private String cep;

    public Propriedade() {}

    public Propriedade(String regiao, String nome, Pessoa pessoa, String cep) {
        this.regiao = regiao;
        this.nome = nome;
        this.pessoa = pessoa;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Propriedade{" +
                "id=" + id +
                ", regiao='" + regiao + '\'' +
                ", nome='" + nome + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
