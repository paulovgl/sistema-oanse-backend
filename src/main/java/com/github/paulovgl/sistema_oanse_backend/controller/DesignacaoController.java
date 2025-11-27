// package com.github.paulovgl.sistema_oanse_backend.controller;

// import java.time.LocalDate;

// import com.github.paulovgl.sistema_oanse_backend.service.DesignacaoService;

// import jakarta.transaction.Transactional;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.DELETE;
// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.PathParam;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.QueryParam;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;

// @Path("/designacoes")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class DesignacaoController {

//     private final DesignacaoService designacaoService;

//     public DesignacaoController(DesignacaoService designacaoService) {
//         this.designacaoService = designacaoService;
//     }

//     // Diretor faz a designação
//     @POST
//     public Response designar(
//             @QueryParam("sabadoId") Long sabadoId,
//             @QueryParam("liderId") Long liderId,
//             @QueryParam("oansistaId") Long oansistaId
//     ) {
//         return Response
//                 .status(Response.Status.CREATED)
//                 .entity(designacaoService.designar(sabadoId, liderId, oansistaId))
//                 .build();
//     }

//     // Listar todos do sábado
//     @GET
//     @Path("/sabado/{id}")
//     public Response listarPorSabado(@PathParam("id") Long sabadoId) {
//         return Response.ok(designacaoService.listarPorSabado(sabadoId)).build();
//     }

//     // Listar os do líder naquele sábado
//     @GET
//     @Path("/lider/{liderId}/data/{data}")
//     public Response listarPorLiderData(
//             @PathParam("liderId") Long liderId,
//             @PathParam("data") String data
//     ) {
//         LocalDate sabado = LocalDate.parse(data);
//         return Response.ok(designacaoService.listarPorLiderESabado(liderId, sabado)).build();
//     }

//     @DELETE
//     @Path("/{id}")
//     @Transactional
//     public Response remover(@PathParam("id") Long id) {
//         designacaoService.remover(id);
//         return Response.noContent().build();
//     }
// }
