package org.creditoRural.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "projetos")
public class Projeto extends Entidade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private LocalDateTime localDateTime;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;

    @OneToOne(mappedBy = "projeto", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Avaliacao avaliacao;


    public Projeto() {
        setLocalDateTime();
    }

    public Projeto(Atividade atividade, Propriedade propriedade) {
        this.atividade = atividade;
        this.propriedade = propriedade;
    }

    private void setLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        if(argIsNull(atividade))
            return;
        this.atividade = atividade;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        if(argIsNull(propriedade))
            return;
        this.propriedade = propriedade;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", atividade=" + atividade +
                ", propriedade=" + propriedade +
                '}';
    }
}
