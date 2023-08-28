package org.creditoRural.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private LocalDateTime localDateTime;

    @OneToOne(mappedBy = "projeto")
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;


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
        this.atividade = atividade;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", atividade=" + atividade +
                '}';
    }
}
