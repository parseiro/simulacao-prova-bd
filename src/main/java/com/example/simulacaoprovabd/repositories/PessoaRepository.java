package com.example.simulacaoprovabd.repositories;

import com.example.simulacaoprovabd.entities.Pessoa;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @EntityGraph(
            value = "Pessoa.fones",
            type = EntityGraph.EntityGraphType.LOAD
    )
    List<Pessoa> findPessoasByNomeContainingOrderByNome(String nome);
}
