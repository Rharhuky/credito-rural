package org.creditoRural.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "agentes")
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    //TODO ? AREA DE ATUACAO DE UM AGENTE :MANY TO MANY

    public Agente() {}

    public Agente(String nome) {
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return "Agente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
