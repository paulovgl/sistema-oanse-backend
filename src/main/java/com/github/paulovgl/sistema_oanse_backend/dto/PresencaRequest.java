package com.github.paulovgl.sistema_oanse_backend.dto;

import java.time.LocalDate;

import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

public record PresencaRequest(
        Long oansistaId,
        LocalDate data,
        PresencaStatusType status,
        String observacao
        ) {

}
