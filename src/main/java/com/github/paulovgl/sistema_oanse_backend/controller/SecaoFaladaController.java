// package com.github.paulovgl.sistema_oanse_backend.controller;

// import com.github.paulovgl.sistema_oanse_backend.dto.SecaoFaladaRequest;
// import com.github.paulovgl.sistema_oanse_backend.service.SecaoFaladaService;

// import jakarta.validation.Valid;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.PathParam;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;

// @Path("/secoes-faladas")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class SecaoFaladaController {

//     private final SecaoFaladaService secaoFaladaService;

//     public SecaoFaladaController(SecaoFaladaService secaoFaladaService) {
//         this.secaoFaladaService = secaoFaladaService;
//     }

//     @POST
//     public Response registrar(@Valid SecaoFaladaRequest dto) {
//         return Response.status(Response.Status.CREATED)
//                 .entity(secaoFaladaService.registrar(dto))
//                 .build();
//     }

//     @GET
//     @Path("/oansista-ano/{id}")
//     public Response listar(@PathParam("id") Long id) {
//         return Response.ok(secaoFaladaService.listarPorOansistaAno(id)).build();
//     }
// }
