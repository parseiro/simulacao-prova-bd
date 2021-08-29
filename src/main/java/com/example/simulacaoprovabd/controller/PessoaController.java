package com.example.simulacaoprovabd.controller;

import com.example.simulacaoprovabd.entities.Pessoa;
import com.example.simulacaoprovabd.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/todos")
    public Collection<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }
}
