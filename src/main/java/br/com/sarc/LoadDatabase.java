package br.com.sarc;

import br.com.sarc.core.domain.entity.Predio;
import br.com.sarc.core.domain.entity.Recurso;
import br.com.sarc.core.domain.entity.Status;
import br.com.sarc.core.domain.repository.PredioRepository;
import br.com.sarc.core.domain.repository.RecursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabasePredio(PredioRepository predioRepository) {
        return args -> {
            predioRepository.save(new Predio("Predio 15","15", "Centro da PUCRS"));
            predioRepository.save(new Predio("Predio 32","32", "Perto do Maza"));
            predioRepository.save(new Predio("Predio 40","40", "Floresta"));
        };
    }

    @Bean
    CommandLineRunner initDatabaseRecurso(RecursoRepository recursoRepository) {
        return  args -> {
            recursoRepository.save(new Recurso("Laptop", Status.DISPONIVEL));
            recursoRepository.save(new Recurso("Lapis", Status.DISPONIVEL));
            recursoRepository.save(new Recurso("Quadro", Status.MANUTENCAO));
        };
    }
}