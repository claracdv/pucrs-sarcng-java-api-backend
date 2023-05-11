package br.com.sarc.core.service.dto;

import br.com.sarc.core.domain.entity.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Recurso v1")
public class RecursoDTO {

    @ApiModelProperty(required = true, example = "computador")
    private String nome;
    @ApiModelProperty(required = true, example = "DISPONIVEL", allowableValues = "DISPONIVEL, MANUTENCAO")
    private Status status;

    public String getNome() {
        return nome;
    }
    public Status getStatus() { return status; }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setStatus(Status status) { this.status = status; }
}
