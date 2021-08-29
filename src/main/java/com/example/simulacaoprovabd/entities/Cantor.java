package com.example.simulacaoprovabd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cantor {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cantor", nullable = false)
    private Integer id;

    @Setter
    @Getter
    @NotBlank
    @Column(name = "nome_cantor", nullable = false, length = 50)
    private String nome;

    @Setter
    @Getter
    @NotBlank
    @Column(name = "pais", nullable = false, length = 30)
    private String pais;

    @Getter
    @OneToMany(mappedBy = "cantor")
    private Set<Gravacao> gravacoes;

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cantor cantor = (Cantor) o;
        return Objects.equals(id, cantor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
