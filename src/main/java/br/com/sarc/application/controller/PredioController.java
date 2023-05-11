package br.com.sarc.application.controller;

import br.com.sarc.core.common.exception.CustomException;
import br.com.sarc.core.domain.entity.Predio;
import br.com.sarc.core.domain.repository.PredioRepository;
import br.com.sarc.core.service.dto.MessageDTO;
import br.com.sarc.core.service.dto.PredioDTO;
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
@Api(value = "/predios", tags = "Predios")
public class PredioController {

    private final PredioRepository repository;

    public PredioController(PredioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/v1/predios")
    @ApiOperation(value = "Retorna todos os predios existentes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Predios encontrados", response = PredioDTO.class, responseContainer = "List")
    })
    List<Predio> getAllPredios() {
        return repository.findAll();
    }

    @GetMapping("/api/v1/predios/{nome}")
    @ApiOperation(value = "Retorna um predio através do nome")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Predio encontrado", response = PredioDTO.class),
            @ApiResponse(code = 404, message = "Predio não encontrado", response = MessageDTO.class)
    })
    ResponseEntity<PredioDTO> one(@PathVariable String nome) {
        return repository.findByNome(nome)
                .map(predio -> ResponseEntity.ok().body(new ModelMapper().map(predio, PredioDTO.class)))
                .orElseThrow(() -> new CustomException(MessageFormat.format("Nome {0} não encontrado", nome)));
    }

    @PostMapping("/api/v1/predios")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um novo predio", code = 201)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Predio criado com sucesso", response = PredioDTO.class),
            @ApiResponse(code = 409, message = "Predio já existente")
    })
    Predio novoPredio(@Valid @RequestBody PredioDTO predio) {
        return repository.save(new ModelMapper().map(predio, Predio.class));
    }

    @PutMapping("/api/v1/predios/{nome}")
    @ApiOperation(value = "Atualiza um predio existente atraves do nome")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Predio alterado com sucesso", response = PredioDTO.class),
            @ApiResponse(code = 404, message = "Predio não encontrado", response = MessageDTO.class),
    })
    Predio atualizaPredio(@RequestBody PredioDTO predio, @PathVariable String nome) {

        return update(new ModelMapper().map(predio, Predio.class), nome)
                .orElseThrow(() -> new CustomException(MessageFormat.format("Nome {0} não encontrado", nome)));
    }

    @DeleteMapping("/api/v1/predios/{id}")
    @ApiOperation(value = "Remove um predio existente através do ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Predio removido com sucesso"),
            @ApiResponse(code = 404, message = "Predio não encontrado", response = MessageDTO.class)
    })
    ResponseEntity<String> delete(@PathVariable Long id) {
        if (repository.findById(id).isPresent())
            repository.deleteById(id);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    private Optional<Predio> update(Predio novoPredio, String descricao) {
        return repository.findByDescricao(descricao).map(predio -> {
            setIfNotNull(predio::setDescricao, novoPredio.getDescricao());
            setIfNotNull(predio::setLocal, novoPredio.getLocal());

            return repository.save(predio);
        });
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }

}
