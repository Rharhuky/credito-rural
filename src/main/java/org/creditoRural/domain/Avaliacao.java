package org.creditoRural.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoId id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @MapsId("agenteId")
    private Agente agente;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE} )
    @MapsId("projetoId")
    private Projeto projeto;

    private Double valor;

    public Avaliacao(Agente agente, Projeto projeto) {
        this.agente = agente;
        this.projeto = projeto;
    }

    public Avaliacao() {
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
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", agente=" + agente +
                ", projeto=" + projeto +
                ", valor=" + valor +
                '}';
    }
}