package br.com.sarc.core.common.exception;

public class CustomException extends RuntimeException {

    private final String mensagem;

    public CustomException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return mensagem;
    }
}
