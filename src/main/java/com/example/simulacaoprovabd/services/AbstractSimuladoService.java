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

    void excluirCantor(Integer id);
    void excluirCategoria(Integer id);
    void excluirFone(Integer id);
    void excluirGravacao(Integer id);
    void excluirGravadora(Integer id);
    void excluirMusica(Integer id);
    void excluirPessoa(Integer id);

}
