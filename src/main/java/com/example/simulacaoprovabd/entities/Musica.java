package com.example.simulacaoprovabd.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Table(name = "musica")
@Entity
@NoArgsConstructor
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
    @OneToMany(mappedBy = "musica")
    private Set<Gravacao> gravacoes;

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }
}
