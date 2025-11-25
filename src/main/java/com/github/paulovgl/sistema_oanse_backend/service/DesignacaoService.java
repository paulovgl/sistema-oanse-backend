package com.github.paulovgl.sistema_oanse_backend.service;

import java.time.LocalDate;
import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.entity.Designacao;
import com.github.paulovgl.sistema_oanse_backend.entity.Lider;
import com.github.paulovgl.sistema_oanse_backend.entity.Oansista;
import com.github.paulovgl.sistema_oanse_backend.entity.SabadoReuniao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class DesignacaoService {

    @Transactional
    public Designacao designar(Long sabadoId, Long liderId, Long oansistaId) {

        SabadoReuniao sabado = SabadoReuniao.findById(sabadoId);
        if (sabado == null) {
            throw new NotFoundException("Sábado não encontrado");
        }

        Lider lider = Lider.findById(liderId);
        if (lider == null) {
            throw new NotFoundException("Líder não encontrado");
        }

        Oansista oansista = Oansista.findById(oansistaId);
        if (oansista == null) {
            throw new NotFoundException("Oansista não encontrado");
        }

        // Verifica se o líder é do mesmo clube
        if (!lider.clube.id.equals(sabado.clube.id)) {
            throw new BadRequestException("Líder não pertence ao clube deste sábado");
        }

        // Verifica duplicidade
        boolean jaExiste = Designacao.count(
                "sabado.id = ?1 AND oansista.id = ?2",
                sabadoId, oansistaId
        ) > 0;

        if (jaExiste) {
            throw new BadRequestException("Esse oansista já foi designado para esse sábado");
        }

        Designacao designacao = new Designacao();
        designacao.sabado = sabado;
        designacao.lider = lider;
        designacao.oansista = oansista;

        designacao.persist();

        return designacao;
    }

    public List<Designacao> listarPorSabado(Long sabadoId) {
        return Designacao.list("sabado.id", sabadoId);
    }

    public List<Designacao> listarPorLiderESabado(Long liderId, LocalDate data) {
        return Designacao.find(
                "lider.id = ?1 AND sabado.data = ?2",
                liderId, data
        ).list();
    }

    @Transactional
    public void remover(Long id) {
        if (!Designacao.deleteById(id)) {
            throw new NotFoundException("Designação não encontrada");
        }
    }
}
