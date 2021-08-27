package com.example.simulacaoprovabd.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Table(name = "musica")
@Entity
public class Musica {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_musica", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private Integer duracao;

    @Setter
    @Getter
    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @Setter
    @Getter
    @ManyToOne
    @Nullable
    @JoinColumn(name = "cod_categoria")
    private Categoria categoria;

    @Setter
    @Getter
    @ManyToOne
    private Set<Gravacao> gravacoes;
}
