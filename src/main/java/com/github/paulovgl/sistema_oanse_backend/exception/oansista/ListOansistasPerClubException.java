package com.github.paulovgl.sistema_oanse_backend.exception.oansista;

public class ListOansistasPerClubException extends RuntimeException {

    public ListOansistasPerClubException() {
        super("Erro ao listar os Oansistas por clube ou não existem Oansistas cadastrados nesse clube");
    }
}
