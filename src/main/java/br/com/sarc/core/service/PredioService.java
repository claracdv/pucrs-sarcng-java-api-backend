package br.com.sarc.core.service;

import br.com.sarc.core.domain.entity.Predio;
import br.com.sarc.core.domain.repository.PredioRepository;
import br.com.sarc.core.domain.usecase.PredioUsecase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("predioService")
public class PredioService implements PredioUsecase {

    private final PredioRepository repository;

    public PredioService(PredioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Predio save(Predio predio) {
        return null;
    }

    public Optional<Predio> findByNome(String nome) {
        return repository.findByNome(nome);
    }
    public Optional<Predio> findByDescricao(String descricao) {
        return repository.findByDescricao(descricao);
    }
    public Optional<Predio> findByLocal(String local) {
        return repository.findByLocal(local);
    }
}
