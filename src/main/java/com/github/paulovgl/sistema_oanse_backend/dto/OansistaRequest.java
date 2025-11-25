package com.github.paulovgl.sistema_oanse_backend.dto;

import java.time.LocalDate;

public record OansistaRequest(
        String name,
        String responsavel,
        LocalDate dataNasc,
        String contato,
        String observacao,
        Long clubeId
        ) {

}
