package com.example.simulacaoprovabd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "fone")
@Entity
@NoArgsConstructor
public class Fone {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fone", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @NotBlank
    @Column(nullable = false, length = 80)
    private String numero;

    @Setter
    @Getter
    @NotBlank
    @Column(nullable = false, length = 1)
    private String tipo;

    @JsonIgnore
    @Setter
    @Getter
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "cod_pessoa", nullable = false)
    private Pessoa pessoa;
}
