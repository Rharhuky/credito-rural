package org.creditoRural.domain;

import jakarta.persistence.*;
import org.creditoRural.domain.enums.TipoAtividade;

@Entity
@Table(name = "atividades")
public class Atividade extends Entidade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoAtividade tipoAtividade;

    @Column(nullable = false)
    private String objetivo;

    @OneToOne(mappedBy = "atividade", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Projeto projeto;



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
        if(argIsNull(tipoAtividade))
            return;
        this.tipoAtividade = tipoAtividade;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        if(argIsNull(objetivo))
            return ;
        this.objetivo = objetivo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
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
