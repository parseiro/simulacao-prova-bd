package com.example.simulacaoprovabd.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Table(name = "pessoa")
@Entity
@NoArgsConstructor
@NamedEntityGraph(
        name = "Pessoa.fones",
        attributeNodes = @NamedAttributeNode("fones")
)
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

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
    @Getter
    List<Fone> fones = new ArrayList<>();

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fones=" + fones +
                '}';
    }
}
