package org.creditoRural.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.creditoRural.domain.enums.TipoAtividade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    @Column
    private TipoAtividade tipoAtividade;

    @Column(nullable = false)
    @NotEmpty
    private String objetivo;

    @OneToMany(mappedBy = "atividade")
    private List<Projeto> projetosAssociados = new ArrayList<>();



    public Atividade() {}

    public Atividade(TipoAtividade tipoAtividade, String objetivo) {
        this.tipoAtividade = tipoAtividade;
        this.objetivo = objetivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "id=" + id +
                ", tipoAtividade=" + tipoAtividade +
                ", objetivo='" + objetivo + '\'' +
                '}';
    }
}
