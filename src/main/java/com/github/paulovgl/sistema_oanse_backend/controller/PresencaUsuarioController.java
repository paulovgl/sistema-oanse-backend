package com.github.paulovgl.sistema_oanse_backend.controller;

import com.github.paulovgl.sistema_oanse_backend.dto.PresencaUsuarioRequest;
import com.github.paulovgl.sistema_oanse_backend.service.PresencaUsuarioService;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/presencas/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresencaUsuarioController {

    private final PresencaUsuarioService presencaUsuarioService;

    public PresencaUsuarioController(PresencaUsuarioService presencaUsuarioService) {
        this.presencaUsuarioService = presencaUsuarioService;
    }

    @POST
    public Response registrar(@Valid PresencaUsuarioRequest dto) {
        return Response
                .status(Response.Status.CREATED)
                .entity(presencaUsuarioService.registrar(dto))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid PresencaUsuarioRequest dto) {
        return Response.ok(presencaUsuarioService.atualizar(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        presencaUsuarioService.deletar(id);
        return Response.noContent().build();
    }
}
