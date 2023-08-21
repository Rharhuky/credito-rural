package org.creditoRural.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "bens")
public class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String tipo;

    @Column
    private Double preco;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;


}
