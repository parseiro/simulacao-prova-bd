package com.example.simulacaoprovabd.services;

import com.example.simulacaoprovabd.entities.*;
import com.example.simulacaoprovabd.repositories.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class MyService implements AbstractSimuladoService {
    // Pessoa - adiciona, deleta, consulta
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        pessoa.getFones().forEach(f -> foneRepository.save(f));
        return pessoa;
    }

    @Override
    public void excluirPessoaById(Integer id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void excluirPessoaById(Integer... ids) {
        Stream.of(ids).parallel()
                .forEach(pessoaRepository::deleteById);
    }

    @Autowired
    EntityManager entityManager;

    public List<Pessoa> consultaPessoaPorNome(@NonNull String nome) {
        return pessoaRepository.findPessoasByNomeContainingOrderByNome(nome);
//        return pessoaRepository.findDistinctPessoasByNomeContainingAllIgnoreCaseOrderByNome(nome);
/*        var tuples = entityManager.createQuery(
                "SELECT p "
                        + "FROM Pessoa p "
                        + "LEFT JOIN FETCH p.fones f"
                        + "WHERE p.nome LIKE :searchedName "
                , Pessoa.class)
                .setParameter("searchedName", "%" + nome + "%")
                .getResultList();*/

/*        var query = entityManager.createQuery(
                "SELECT f FROM Fone f JOIN FETCH f.pessoa p"
                , Tuple.class);
        var tuples = (List<Tuple>) query.getResultList();
        for (Pessoa pessoa : tuples) {
            log.info("Puxei tupla: {}", pessoa);
        }

        return tuples;*/
    }

/*    public List<Pessoa> consultaPessoaPorRegex(@NonNull String pattern) {
        return pessoaRepository.findDistinctPessoasByNomeMatchesRegexAllIgnoreCaseOrderByNome(pattern);
    }*/

    // Fone - adiciona, deleta, consulta
    @Autowired
    private FoneRepository foneRepository;

    @Override
    @Transactional
    public Fone salvar(Fone fone) {
        return foneRepository.save(fone);
    }

    @Override
    public void excluirFoneById(Integer id) {
        foneRepository.deleteById(id);
    }

    // Cantor

    @Autowired
    private CantorRepository cantorRepository;

    @Override
    @Transactional
    public Cantor salvar(Cantor cantor) {
        return cantorRepository.save(cantor);
    }

    @Override
    @Transactional
    public void excluirCantorById(Integer id) {
        cantorRepository.deleteById(id);
    }

    // Categoria

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void excluirCategoriaById(Integer id) {
        categoriaRepository.deleteById(id);
    }

    // Gravadora

    @Autowired
    private GravadoraRepository gravadoraRepository;

    @Override
    @Transactional
    public Gravadora salvar(Gravadora gravadora) {
        return gravadoraRepository.save(gravadora);
    }

    @Override
    public void excluirGravadoraById(Integer id) {
        gravadoraRepository.deleteById(id);
    }

    // Gravação

    @Autowired
    private GravacaoRepository gravacaoRepository;

    @Override
    @Transactional
    public Gravacao salvar(Gravacao gravacao) {
        var cantor = gravacao.getCantor();
        var musica = gravacao.getMusica();
        var gravadora = gravacao.getGravadora();

        if (cantor != null && cantor.isNew()) {
            cantorRepository.save(cantor);
        }
        if (musica != null && musica.isNew()) {
            musicaRepository.save(musica);
        }
        if (gravadora != null && gravadora.isNew()) {
            gravadoraRepository.save(gravadora);
        }

        return gravacaoRepository.save(gravacao);
    }

    @Override
    public void excluirGravacaoById(Integer id) {
        gravacaoRepository.deleteById(id);
    }

    // Musica

    @Autowired
    private MusicaRepository musicaRepository;

    @Override
    @Transactional
    public Musica salvar(Musica musica) {
        var categoria = musica.getCategoria();

        if (categoria != null && categoria.isNew()) {
            categoriaRepository.save(categoria);
        }

        return musicaRepository.save(musica);
    }

    @Override
    public void excluirMusicaById(Integer id) {
        musicaRepository.deleteById(id);
    }
}
