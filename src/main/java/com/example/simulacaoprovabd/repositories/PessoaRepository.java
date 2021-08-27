package com.example.simulacaoprovabd.repositories;

import com.example.simulacaoprovabd.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
