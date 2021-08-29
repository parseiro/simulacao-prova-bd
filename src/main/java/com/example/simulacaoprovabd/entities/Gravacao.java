package com.example.simulacaoprovabd.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "gravacao")
@Entity
@NoArgsConstructor
public class Gravacao {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_gravacao", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "cod_gravadora", nullable = false)
    private Gravadora gravadora;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_cantor", nullable = false)
    private Cantor cantor;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "musica_cod_musica", nullable = false)
    private Musica musica;
}
