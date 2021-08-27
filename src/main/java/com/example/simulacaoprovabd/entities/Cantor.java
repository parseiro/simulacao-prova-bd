package com.example.simulacaoprovabd.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
public class Cantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cantor")
    private Integer id;

    @NotBlank
    @Column(name = "nome_cantor", nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Column(name = "pais", nullable = false, length = 30)
    private String pais;

    @OneToMany(mappedBy = "cantor")
    private Set<Gravacao> gravacoes;
}
