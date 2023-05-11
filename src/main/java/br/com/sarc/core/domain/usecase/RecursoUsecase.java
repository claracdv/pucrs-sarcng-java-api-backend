package br.com.sarc.core.domain.usecase;

import br.com.sarc.core.domain.entity.Recurso;

import java.util.Optional;

public interface RecursoUsecase {

    Recurso save(Recurso recurso);
    Optional<Recurso> findByNome(String nome);

}
