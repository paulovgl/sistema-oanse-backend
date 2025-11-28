package com.github.paulovgl.sistema_oanse_backend.dto;

import com.github.paulovgl.sistema_oanse_backend.entity.PresencaUsuario;
import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

public record PresencaUsuarioResponse(
        Long id,
        Long usuarioId,
        String usuarioName,
        PresencaStatusType status
        ) {

    public static PresencaUsuarioResponse fromEntity(PresencaUsuario p) {
        return new PresencaUsuarioResponse(
                p.id,
                p.usuario.id,
                p.usuario.name,
                p.status
        );
    }

}
