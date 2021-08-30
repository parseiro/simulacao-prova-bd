package com.example.simulacaoprovabd.services;

import com.example.simulacaoprovabd.entities.*;

public interface AbstractSimuladoService {
    Cantor salvar(Cantor cantor);
    Categoria salvar(Categoria categoria);
    Fone salvar(Fone fone);
    Gravacao salvar(Gravacao gravacao);
    Gravadora salvar(Gravadora gravadora);
    Musica salvar(Musica musica);
    Pessoa salvar(Pessoa pessoa);

    void excluirCantorById(Integer id);
    void excluirCategoriaById(Integer id);
    void excluirFoneById(Integer id);
    void excluirGravacaoById(Integer id);
    void excluirGravadoraById(Integer id);
    void excluirMusicaById(Integer id);
    void excluirPessoaById(Integer id);
    void excluirPessoaById(Integer... ids);

}
