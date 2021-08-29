package com.example.simulacaoprovabd.services;

import com.example.simulacaoprovabd.entities.*;
import com.example.simulacaoprovabd.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MyService implements AbstractSimuladoService {
    @Autowired
    private CantorRepository cantorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FoneRepository foneRepository;

    @Autowired
    private GravadoraRepository gravadoraRepository;

    @Autowired
    private GravacaoRepository gravacaoRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    @Transactional
    public Cantor salvar(Cantor cantor) {
        return cantorRepository.save(cantor);
   }

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Fone salvar(Fone fone) {
        return null;
    }

    @Override
    public Gravacao salvar(Gravacao gravacao) {
        return null;
    }

    @Override
    public Gravadora salvar(Gravadora gravadora) {
        return gravadoraRepository.save(gravadora);
    }

    @Override
    public Musica salvar(Musica musica) {
        return null;
    }

    @Override
    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        pessoa.getFones().forEach(f -> foneRepository.save(f));
        return pessoa;
    }

    @Override
    @Transactional
    public void excluirCantor(Integer id) {
        cantorRepository.deleteById(id);
    }

    @Override
    public void excluirCategoria(Integer id) {

    }

    @Override
    public void excluirFone(Integer id) {

    }

    @Override
    public void excluirGravacao(Integer id) {

    }

    @Override
    public void excluirGravadora(Integer id) {

    }

    @Override
    public void excluirMusica(Integer id) {

    }

    @Override
    public void excluirPessoa(Integer id) {

    }
}
