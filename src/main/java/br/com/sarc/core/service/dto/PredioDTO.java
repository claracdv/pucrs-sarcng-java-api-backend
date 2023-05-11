package br.com.sarc.core.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Predio v1")
public class PredioDTO {

    @ApiModelProperty(required = true, example = "predio 32")
    private String nome;
    @ApiModelProperty(required = true, example = "perto do RU")
    private String descricao;

    @ApiModelProperty(required = true, example = "BLOCO 32")
    private String local;

    public String getNome() { return nome; }

    public String getDescricao() {
        return descricao;
    }
    public String getLocal() {
        return local;
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setLocal(String local) { this.local = local; }
}
