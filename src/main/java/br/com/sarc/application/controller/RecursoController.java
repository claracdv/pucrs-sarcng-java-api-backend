package br.com.sarc.application.controller;

import br.com.sarc.core.common.exception.CustomException;
import br.com.sarc.core.domain.entity.Recurso;
import br.com.sarc.core.domain.repository.RecursoRepository;
import br.com.sarc.core.service.dto.MessageDTO;
import br.com.sarc.core.service.dto.RecursoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RestController
@Api(value = "/recursos", tags = "Recursos")
public class RecursoController {

    private final RecursoRepository repository;

    public RecursoController(RecursoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/v1/recursos")
    @ApiOperation(value = "Retorna todos os recursos existentes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Recursos encontrados", response = RecursoDTO.class, responseContainer = "List")
    })
    List<Recurso> getAllRecursos() {
        return repository.findAll();
    }

    @GetMapping("/api/v1/recursos/{nome}")
    @ApiOperation(value = "Retorna um recurso através do nome")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Recurso encontrado", response = RecursoDTO.class),
            @ApiResponse(code = 404, message = "Recurso não encontrado", response = MessageDTO.class)
    })
    ResponseEntity<RecursoDTO> one(@PathVariable String nome) {
        return repository.findByNome(nome)
                .map(recurso -> ResponseEntity.ok().body(new ModelMapper().map(recurso, RecursoDTO.class)))
                .orElseThrow(() -> new CustomException(MessageFormat.format("Nome {0} não encontrado", nome)));
    }

    @PostMapping("/api/v1/recursos")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um novo recurso", code = 201)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Recurso criado com sucesso", response = RecursoDTO.class),
            @ApiResponse(code = 409, message = "Recurso já existente")
    })
    Recurso novoRecurso(@Valid @RequestBody RecursoDTO recurso) {
        return repository.save(new ModelMapper().map(recurso, Recurso.class));
    }

    @PutMapping("/api/v1/recursos/{nome}")
    @ApiOperation(value = "Atualiza um recurso existente atraves do nome")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Recurso alterado com sucesso", response = RecursoDTO.class),
            @ApiResponse(code = 404, message = "Recurso não encontrado", response = MessageDTO.class)
    })
    Recurso atualizaRecurso(@RequestBody RecursoDTO recurso, @PathVariable String nome) {

        return update(new ModelMapper().map(recurso, Recurso.class), nome)
                .orElseThrow(() -> new CustomException(MessageFormat.format("Nome {0} não encontrado", nome)));
    }

    @DeleteMapping("/api/v1/recursos/{id}")
    @ApiOperation(value = "Remove um recurso existente através do ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Recurso removido com sucesso")
    })
    ResponseEntity<String> delete(@PathVariable Long id) {
        if (repository.findById(id).isPresent())
            repository.deleteById(id);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    private Optional<Recurso> update(Recurso novoRecurso, String nome) {
        return repository.findByNome(nome).map(predio -> {
            setIfNotNull(predio::setNome, novoRecurso.getNome());

            return repository.save(predio);
        });
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }

}
