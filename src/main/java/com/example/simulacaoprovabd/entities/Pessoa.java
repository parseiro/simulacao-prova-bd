package com.example.simulacaoprovabd.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Table(name = "pessoa")
@Entity
@NoArgsConstructor
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

    @OneToMany(mappedBy = "pessoa")
    @Getter
    Set<Fone> fones = new HashSet<>();

}
