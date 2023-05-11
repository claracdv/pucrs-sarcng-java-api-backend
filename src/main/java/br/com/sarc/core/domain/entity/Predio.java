package br.com.sarc.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Predio {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String descricao;

    private String local;

    public Predio() {}

    public Predio(String nome, String descricao, String local) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
    }

    public String getNome() { return nome; }

    public String getDescricao() {
        return descricao;
    }
    public String getLocal() { return local; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setLocal(String local) {
        this.local = local;
    }
}