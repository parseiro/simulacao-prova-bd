package com.example.simulacaoprovabd.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Gravadora {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_gravadora", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @NotBlank
    @Column(length = 50, nullable = false)
    private String nome_gravadora;

    @Getter
    @Setter
    @NotBlank
    @Column(length = 50, nullable = false)
    private String pais;

    @Setter
    @Getter
    @OneToMany(mappedBy = "gravadora")
    private Set<Gravacao> gravacoes;

}
