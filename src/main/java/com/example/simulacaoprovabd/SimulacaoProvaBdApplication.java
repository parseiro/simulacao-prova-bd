package com.example.simulacaoprovabd;

import com.example.simulacaoprovabd.entities.Fone;
import com.example.simulacaoprovabd.entities.Pessoa;
import com.example.simulacaoprovabd.services.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class SimulacaoProvaBdApplication {
    @Autowired
    MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(SimulacaoProvaBdApplication.class, args);
    }

    @Bean
    public CommandLineRunner testPessoaComContatos() {
        return args -> {
            {
                var pessoa = new Pessoa();
                pessoa.setNome("Devilson Coroados");

                {
                    var telefone1 = new Fone();
                    telefone1.setTipo("F");
                    telefone1.setNumero("123456");
                    telefone1.setPessoa(pessoa);
                    pessoa.getFones().add(telefone1);
                }

                {
                    var telefone2 = new Fone();
                    telefone2.setTipo("M");
                    telefone2.setNumero("9876543");
                    telefone2.setPessoa(pessoa);
                    pessoa.getFones().add(telefone2);
                }

                myService.salvar(pessoa);
                log.info("Salvei a pessoa {}", pessoa);
            }

            {
                List<Pessoa> pessoaList = myService.consultaPessoaPorNome("vilson");
                log.info("Puxei do banco de dados a pessoaList: {}", pessoaList);
/*                pessoaList.forEach(x -> {
                    Integer id = x.getId();
                    myService.excluirPessoaById(id);
                    log.info("Exclui pessoa com id {}", id);
                });*/
                log.info("Vou excluir todos os itens encontrados");
                var ids = pessoaList.parallelStream()
                        .map(Pessoa::getId)
                        .toArray(Integer[]::new);
                myService.excluirPessoaById(ids);
                log.info("Acabei de excluir todos os itens encontrados");
            }
        };
    }


}
