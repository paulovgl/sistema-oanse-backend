package com.github.paulovgl.sistema_oanse_backend.exception;

public class PositiveOrZeroException extends RuntimeException {

    public PositiveOrZeroException() {
        super("O número precisa ser maior ou igual a zero");
    }
}
