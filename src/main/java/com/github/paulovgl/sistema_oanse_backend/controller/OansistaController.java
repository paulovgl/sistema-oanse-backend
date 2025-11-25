package com.github.paulovgl.sistema_oanse_backend.controller;

import com.github.paulovgl.sistema_oanse_backend.dto.OansistaRequest;
import com.github.paulovgl.sistema_oanse_backend.service.OansistaService;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/oansistas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OansistaController {

    private final OansistaService oansistaService;

    public OansistaController(OansistaService oansistaService) {
        this.oansistaService = oansistaService;
    }

    // LISTAR TODOS
    @GET
    public Response listar(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        return Response.ok(oansistaService.listar(page, pageSize)).build();
    }

    // BUSCAR POR ID
    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(oansistaService.buscarPorId(id)).build();
    }

    // BUSCAR POR CLUBE
    @GET
    @Path("/clube/{id}")
    public Response buscarPorClube(@PathParam("id") Long clubeId) {
        return Response.ok(oansistaService.buscarPorClube(clubeId)).build();
    }

    // BUSCAR POR NOME
    @GET
    @Path("/buscar")
    public Response buscarPorNome(@QueryParam("nome") String nome) {
        return Response.ok(oansistaService.buscarPorNome(nome)).build();
    }

    // Criar a entidade
    @POST
    public Response criar(OansistaRequest dto) {
        return Response.status(Response.Status.CREATED.getStatusCode(), "Oansista criado com sucesso")
                .entity(oansistaService.criar(dto))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, OansistaRequest dto) {
        return Response.ok(oansistaService.atualizar(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        oansistaService.deletar(id);
        return Response.noContent().build();
    }
}
