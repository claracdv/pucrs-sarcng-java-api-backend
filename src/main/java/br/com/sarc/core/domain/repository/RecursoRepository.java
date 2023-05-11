package br.com.sarc.core.domain.repository;

import br.com.sarc.core.domain.entity.Recurso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long>, JpaSpecificationExecutor<Recurso> {

    Optional<Recurso> findByNome(@Param("nome") String nome);

    Optional<Recurso> findById(@Param("id") Long id);
}
