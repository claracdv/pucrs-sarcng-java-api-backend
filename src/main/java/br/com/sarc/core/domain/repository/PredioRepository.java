package br.com.sarc.core.domain.repository;

import br.com.sarc.core.domain.entity.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PredioRepository extends JpaRepository<Predio, Long>, JpaSpecificationExecutor<Predio> {

    Optional<Predio> findByNome(@Param("nome") String nome);
    Optional<Predio> findByDescricao(@Param("descricao") String descricao);
    Optional<Predio> findByLocal(@Param("local") String local);

    Optional<Predio> findById(@Param("id") Long id);
}
