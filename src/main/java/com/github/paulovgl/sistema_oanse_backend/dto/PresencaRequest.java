package com.github.paulovgl.sistema_oanse_backend.dto;

import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

public record PresencaRequest(
        Long designacaoId,
        PresencaStatusType status,
        String observacao
        ) {

}
