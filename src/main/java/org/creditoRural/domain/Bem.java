package org.creditoRural.domain;

import jakarta.persistence.*;
import org.creditoRural.domain.enums.TipoBem;

@Entity
@Table(name = "bens")
public class Bem extends Entidade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_bem", nullable = false)
    private TipoBem tipo;

    @Column
    private Double preco;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;

    @Transient
    private Boolean actived;

    public Bem(TipoBem tipo, Double preco, Propriedade propriedade) {
        this.tipo = tipo;
        this.preco = preco;
        this.propriedade = propriedade;
        this.actived = true;
    }

    public Bem() {
        setActived(true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoBem getTipo() {
        return tipo;
    }

    public void setTipo(TipoBem tipo) {
        if(argIsNull(tipo))
            return;
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        if(argIsNull(preco))
            return;
        this.preco = preco;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        if(argIsNull(propriedade))
            if(actived)
                return;
            else
                this.propriedade = propriedade; // = null
        this.propriedade = propriedade;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        if(argIsNull(actived))
            return;
        this.actived = actived;
    }

    @Override
    public String toString() {
        return "Bem{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
