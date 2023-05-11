package br.com.sarc.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recurso {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Status status;

    public Recurso() {}

    public Recurso(String nome, Status status) {

        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public Status getStatus() { return status; }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void SetStatus(Status status) { this.status = status; }
}
