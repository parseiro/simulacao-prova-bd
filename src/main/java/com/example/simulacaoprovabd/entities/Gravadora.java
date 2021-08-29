package com.example.simulacaoprovabd.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
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

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gravadora gravadora = (Gravadora) o;
        return Objects.equals(id, gravadora.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
