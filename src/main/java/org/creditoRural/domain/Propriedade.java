package org.creditoRural.domain;

import jakarta.persistence.*;
import org.creditoRural.customConstraint.Cep;
import org.creditoRural.exceptions.BemException;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propriedades")
public class Propriedade extends Entidade {

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

    @OneToMany(mappedBy = "propriedade", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Bem> bens = new ArrayList<>();

    @OneToMany(mappedBy = "propriedade", cascade = CascadeType.ALL)
    private List<Projeto> projetos = new ArrayList<>();


    @Column(nullable = false)
    @Cep
    private String cep;

    public Propriedade() {}

    public Propriedade(String regiao, String nome, Pessoa pessoa, List<Bem> bens, List<Projeto> projetos, String cep) {
        this.regiao = regiao;
        this.nome = nome;
        this.pessoa = pessoa;
        this.bens = bens;
        this.projetos = projetos;
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
        if(argIsNull(regiao))
            return;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(argIsNull(nome))
            return;
        this.nome = nome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if(argIsNull(pessoa))
            return;
        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if(argIsNull(cep))
            return;
        this.cep = cep;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void adicionarBem(Bem bem){

        if(bem == null || this.bens.contains(bem)){
            throw new BemException();
        }

        this.getBens().add(bem);

    }

    public void adicionarProjeto(Projeto projeto){
        if(projeto == null || this.getProjetos().contains(projeto))
            throw new RuntimeException("Muita treta");

        this.getProjetos().add(projeto);

    }

    public List<Bem> getBens() {
        return bens;
    }

    public void setBens(List<Bem> bens) {
        this.bens = bens;
    }

    @Override
    public String toString() {
        return "Propriedade{" +
                "id=" + id +
                ", regiao='" + regiao + '\'' +
                ", nome='" + nome + '\'' +
                ", pessoa=" + pessoa +
                ", bens=" + bens +
                ", cep='" + cep + '\'' +
                '}';
    }
}
