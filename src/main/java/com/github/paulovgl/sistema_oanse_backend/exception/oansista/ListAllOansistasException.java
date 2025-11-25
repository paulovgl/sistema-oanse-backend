package com.github.paulovgl.sistema_oanse_backend.exception.oansista;

public class ListAllOansistasException extends RuntimeException {

    public ListAllOansistasException() {
        super("Erro ao listar os Oansistas ou não existem Oansistas cadastrados");
    }
}
