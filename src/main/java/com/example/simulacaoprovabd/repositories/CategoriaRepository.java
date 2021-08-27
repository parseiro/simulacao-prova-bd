package com.example.simulacaoprovabd.repositories;

import com.example.simulacaoprovabd.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
