package com.example.simulacaoprovabd.entities;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "fone")
@Entity
public class Fone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fone")
    private Integer id;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String numero;

    @NotBlank
    @Column(nullable = false, length = 1)
    private String tipo;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "cod_pessoa", nullable = false)
    private Pessoa pessoa;
}
