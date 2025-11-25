package com.github.paulovgl.sistema_oanse_backend.service;

import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.dto.PresencaRequest;
import com.github.paulovgl.sistema_oanse_backend.entity.Designacao;
import com.github.paulovgl.sistema_oanse_backend.entity.Presenca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PresencaService {

    @Transactional
    public Presenca registrar(PresencaRequest dto) {

        Designacao designacao = Designacao.findById(dto.designacaoId());

        if (designacao == null) {
            throw new NotFoundException("Designação não encontrada");
        }

        boolean jaExiste = Presenca.count(
                "designacao.id", dto.designacaoId()
        ) > 0;

        if (jaExiste) {
            throw new BadRequestException("Presença já registrada para esta designação");
        }

        Presenca presenca = new Presenca();
        presenca.designacao = designacao;
        presenca.status = dto.status();
        presenca.observacao = dto.observacao();

        presenca.persist();

        return presenca;
    }

    public List<Presenca> listarPorSabado(Long sabadoId) {
        return Presenca.list("designacao.sabado.id", sabadoId);
    }

    public List<Presenca> listarPorLider(Long liderId) {
        return Presenca.list("designacao.lider.id", liderId);
    }

    @Transactional
    public Presenca atualizar(Long id, PresencaRequest dto) {

        Presenca presenca = Presenca.findById(id);

        if (presenca == null) {
            throw new NotFoundException("Presença não encontrada");
        }

        presenca.status = dto.status();
        presenca.observacao = dto.observacao();

        return presenca;
    }

    @Transactional
    public void deletar(Long id) {
        if (!Presenca.deleteById(id)) {
            throw new NotFoundException("Presença não encontrada");
        }
    }
}
