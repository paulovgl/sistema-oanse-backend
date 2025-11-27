package com.github.paulovgl.sistema_oanse_backend.dto;

import java.time.LocalDate;
import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.entity.Oansista;

public record OansistaResponse(
        Long id,
        String name,
        String responsavel,
        LocalDate dataNasc,
        String contato,
        String observacao,
        Long clubeId,
        String clubeNome
        ) {

    public static OansistaResponse fromEntity(Oansista o) {
        return new OansistaResponse(
                o.id,
                o.name,
                o.responsavel,
                o.dataNasc,
                o.contato,
                o.observacao,
                o.clube != null ? o.clube.id : null,
                o.clube != null ? o.clube.name.name() : null
        );
    }

    public static List<OansistaResponse> mapAll(List<Oansista> list) {
        return list.stream()
                .map(OansistaResponse::fromEntity)
                .toList();
    }
}
