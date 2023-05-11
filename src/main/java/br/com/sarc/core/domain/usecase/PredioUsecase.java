package br.com.sarc.core.domain.usecase;

import br.com.sarc.core.domain.entity.Predio;

import java.util.Optional;

public interface PredioUsecase {

    Predio save(Predio predio);

    Optional<Predio> findByNome(String nome);
    Optional<Predio> findByDescricao(String descricao);
    Optional<Predio> findByLocal(String local);

}
