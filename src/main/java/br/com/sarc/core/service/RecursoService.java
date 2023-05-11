package br.com.sarc.core.service;

import br.com.sarc.core.domain.entity.Recurso;
import br.com.sarc.core.domain.repository.RecursoRepository;
import br.com.sarc.core.domain.usecase.RecursoUsecase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("recursoService")
public class RecursoService implements RecursoUsecase {

    private final RecursoRepository repository;

    public RecursoService(RecursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recurso save(Recurso recurso) {
        return null;
    }

    public Optional<Recurso> findByNome(String nome) {
        return repository.findByNome(nome);
    }
}
