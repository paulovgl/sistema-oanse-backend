package com.github.paulovgl.sistema_oanse_backend.exception;

import java.util.Objects;

import com.github.paulovgl.sistema_oanse_backend.dto.ErrorResponse;
import com.github.paulovgl.sistema_oanse_backend.exception.oansista.*;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        // Oansistas Exceptions
        if (exception instanceof ListAllOansistasException) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(new ErrorResponse(exception.getMessage()))
                    .build();
        }
        if (exception instanceof ListOansistasPerClubException) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(new ErrorResponse(exception.getMessage()))
                    .build();
        }
        if (exception instanceof NotDeletedOansistaException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(exception.getMessage()))
                    .build();
        }

        // Número negativo Exception
        if (exception instanceof PositiveOrZeroException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse(exception.getMessage()))
                    .build();
        }

        // Erro genérico
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("Erro interno do servidor: " + Objects.requireNonNullElse(exception != null ? exception.getMessage() : null, "Erro desconhecido")))
                .build();
    }

}
