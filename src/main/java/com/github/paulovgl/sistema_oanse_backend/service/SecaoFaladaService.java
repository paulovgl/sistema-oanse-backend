// package com.github.paulovgl.sistema_oanse_backend.service;

// import java.util.List;

// import com.github.paulovgl.sistema_oanse_backend.dto.SecaoFaladaRequest;
// import com.github.paulovgl.sistema_oanse_backend.entity.Designacao;
// import com.github.paulovgl.sistema_oanse_backend.entity.OansistaAno;
// import com.github.paulovgl.sistema_oanse_backend.entity.Secao;
// import com.github.paulovgl.sistema_oanse_backend.entity.SecaoFalada;

// import jakarta.enterprise.context.ApplicationScoped;
// import jakarta.transaction.Transactional;
// import jakarta.ws.rs.BadRequestException;
// import jakarta.ws.rs.NotFoundException;

// @ApplicationScoped
// public class SecaoFaladaService {

//     @Transactional
//     public SecaoFalada registrar(SecaoFaladaRequest dto) {

//         Designacao designacao = Designacao.findById(dto.designacaoId());

//         if (designacao == null) {
//             throw new NotFoundException("Designação não encontrada");
//         }

//         Secao secao = Secao.findById(dto.secaoId());

//         if (secao == null) {
//             throw new NotFoundException("Seção não encontrada");
//         }

//         OansistaAno oansistaAno = OansistaAno.find(
//                 "oansista = ?1 and year = ?2",
//                 designacao.oansista,
//                 designacao.sabado.data.getYear()
//         ).firstResult();

//         if (oansistaAno == null) {
//             throw new NotFoundException("Registro anual do oansista não encontrado");
//         }

//         // Verifica se a seção pertence ao mesmo clube
//         if (!secao.manual.clube.id.equals(oansistaAno.clube.id)) {
//             throw new BadRequestException("Seção não pertence ao clube do oansista");
//         }

//         // Evita duplicidade no ano
//         boolean jaExiste = SecaoFalada.count(
//                 "oansistaAno = ?1 AND secao = ?2",
//                 oansistaAno,
//                 secao
//         ) > 0;

//         if (jaExiste) {
//             throw new BadRequestException("Essa seção já foi registrada para este oansista no ano");
//         }

//         SecaoFalada falada = new SecaoFalada();
//         falada.oansistaAno = oansistaAno;
//         falada.secao = secao;
//         falada.lider = designacao.lider;
//         falada.data = designacao.sabado.data;
//         falada.talentosRecebidos = secao.talentos;
//         falada.observacao = dto.observacao();

//         falada.persist();

//         // Soma os talentos
//         oansistaAno.talentos += secao.talentos;

//         return falada;
//     }

//     public List<SecaoFalada> listarPorOansistaAno(Long id) {
//         return SecaoFalada.list("oansistaAno.id", id);
//     }
// }
