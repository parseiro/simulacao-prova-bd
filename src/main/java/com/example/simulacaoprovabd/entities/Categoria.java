package com.example.simulacaoprovabd.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Categoria {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @Column(nullable = false, length = 50)
    @NotBlank
    private String desc_categoria;

    @Setter
    @Getter
    @OneToMany(mappedBy = "categoria")
    private Set<Musica> musicas;
}
