package com.github.paulovgl.sistema_oanse_backend.controller;

import com.github.paulovgl.sistema_oanse_backend.service.ClubeService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clube")
@Produces(MediaType.APPLICATION_JSON)
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @GET
    public Response listar() {
        return Response.ok(clubeService.listar()).build();
    }
}
