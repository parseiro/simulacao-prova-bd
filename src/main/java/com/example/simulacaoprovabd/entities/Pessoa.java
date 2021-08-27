package com.example.simulacaoprovabd.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "pessoa")
@Entity
public class Pessoa {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pessoa", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @NotBlank
    @Column(name = "nome_pessoa", nullable = false, length = 50)
    private String nome;
}
