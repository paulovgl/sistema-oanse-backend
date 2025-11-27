package com.github.paulovgl.sistema_oanse_backend.dto;

import com.github.paulovgl.sistema_oanse_backend.entity.Presenca;
import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

public record PresencaResponse(
        Long id,
        Long oansistaId,
        String oansistaName,
        PresencaStatusType status
        ) {

    public static PresencaResponse fromEntity(Presenca p) {
        return new PresencaResponse(
                p.id,
                p.oansista.id,
                p.oansista.name,
                p.status
        );
    }

}
