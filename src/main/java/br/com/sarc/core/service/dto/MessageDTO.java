package br.com.sarc.core.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Mensagem v1")
public class MessageDTO {

    @ApiModelProperty(required = true, example = "Não encontrado")
    private String mensagem;

    public MessageDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public MessageDTO(){}

    public String getMensagem() {
        return mensagem;
    }
}
