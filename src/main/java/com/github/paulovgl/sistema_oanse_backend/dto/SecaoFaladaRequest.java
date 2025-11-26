package com.github.paulovgl.sistema_oanse_backend.dto;

public record SecaoFaladaRequest(
        Long designacaoId,
        Long secaoId,
        String observacao
        ) {

}
