package com.github.paulovgl.sistema_oanse_backend.exception.oansista;

public class NotDeletedOansistaException extends RuntimeException {

    public NotDeletedOansistaException() {
        super("Não foi possível deletar o Oansista");
    }
}
