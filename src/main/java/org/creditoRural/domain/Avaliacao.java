package org.creditoRural.domain;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao extends Entidade {

    @EmbeddedId
    private AvaliacaoId id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @MapsId("agenteId")
    private Agente agente;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE} )
    @MapsId("projetoId")
    private Projeto projeto;

    private Double valor;

    @BooleanFlag
    private Boolean deferido;


    public Avaliacao(Agente agente, Projeto projeto, Double valor, boolean deferido) {
        this.agente = agente;
        this.projeto = projeto;
        this.valor = valor;
        this.deferido = deferido;
    }

    public Avaliacao() {
        setDeferido(false);
    }

    public AvaliacaoId getId() {
        return id;
    }

    public void setId(AvaliacaoId id) {
        this.id = id;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        if(argIsNull(valor))
            return;
        this.valor = valor;
    }

    public boolean isDeferido() {
        return deferido;
    }

    public void setDeferido(boolean deferido) {
        if(argIsNull(deferido))
            return;
        this.deferido = deferido;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "agente=" + agente +
                ", projeto=" + projeto +
                ", valor=" + valor +
                ", deferido=" + deferido +
                '}';
    }
}