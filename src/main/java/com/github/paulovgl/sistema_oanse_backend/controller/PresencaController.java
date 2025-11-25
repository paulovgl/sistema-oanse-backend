package com.github.paulovgl.sistema_oanse_backend.controller;

import com.github.paulovgl.sistema_oanse_backend.dto.PresencaRequest;
import com.github.paulovgl.sistema_oanse_backend.service.PresencaService;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/presencas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresencaController {

    private final PresencaService presencaService;

    public PresencaController(PresencaService presencaService) {
        this.presencaService = presencaService;
    }

    @POST
    public Response registrar(@Valid PresencaRequest dto) {
        return Response
                .status(Response.Status.CREATED)
                .entity(presencaService.registrar(dto))
                .build();
    }

    @GET
    @Path("/sabado/{sabadoId}")
    public Response listarPorSabado(@PathParam("sabadoId") Long sabadoId) {
        return Response.ok(presencaService.listarPorSabado(sabadoId)).build();
    }

    @GET
    @Path("/lider/{liderId}")
    public Response listarPorLider(@PathParam("liderId") Long liderId) {
        return Response.ok(presencaService.listarPorLider(liderId)).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid PresencaRequest dto) {
        return Response.ok(presencaService.atualizar(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        presencaService.deletar(id);
        return Response.noContent().build();
    }
}
