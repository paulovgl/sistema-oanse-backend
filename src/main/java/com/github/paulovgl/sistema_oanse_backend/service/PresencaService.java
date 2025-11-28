package com.github.paulovgl.sistema_oanse_backend.service;

import java.time.DayOfWeek;

import com.github.paulovgl.sistema_oanse_backend.dto.PresencaRequest;
import com.github.paulovgl.sistema_oanse_backend.dto.PresencaResponse;
import com.github.paulovgl.sistema_oanse_backend.entity.Oansista;
import com.github.paulovgl.sistema_oanse_backend.entity.OansistaAno;
import com.github.paulovgl.sistema_oanse_backend.entity.Presenca;
import com.github.paulovgl.sistema_oanse_backend.entity.SabadoReuniao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PresencaService {

    @Transactional
    public PresencaResponse registrar(PresencaRequest dto) {

        // Verifica se a data é um sábado
        if (dto.data().getDayOfWeek() != DayOfWeek.SATURDAY) {
            throw new BadRequestException("A data informada não é um sábado");
        }

        // Verifica se é um sábado válido
        SabadoReuniao sabado = SabadoReuniao.find(
                "data = ?1 AND letivo = true",
                dto.data()
        ).firstResult();
        if (sabado == null) {
            throw new BadRequestException("Este sábado não é letivo");
        }

        // Verifica se o Oansista existe
        Oansista oansista = Oansista.findById(dto.oansistaId());
        if (oansista == null) {
            throw new NotFoundException("Oansista não encontrado");
        }

        // Verifica se a presença já existe
        boolean jaExiste = Presenca.count(
                "oansista.id = ?1 AND data = ?2",
                dto.oansistaId(), dto.data()
        ) > 0;
        if (jaExiste) {
            throw new BadRequestException("Presença já registrada para esse oansista neste sábado");
        }

        int anoAtual = dto.data().getYear();

        // Verifica se o existe dados do ano do Oansista
        OansistaAno oansistaAno = OansistaAno.find(
                "oansista.id = ?1 AND ano = ?2",
                oansista.id, anoAtual
        ).firstResult();

        if (oansistaAno == null) {
            oansistaAno = new OansistaAno();
            oansistaAno.ano = anoAtual;
            oansistaAno.oansista = oansista;
            oansistaAno.clube = oansista.clube;
            oansistaAno.talentos = 0.0;
            oansistaAno.persist();
        }

        Presenca presenca = new Presenca();
        presenca.oansista = oansista;
        presenca.oansistaAno = oansistaAno;
        presenca.status = dto.status();
        presenca.observacao = dto.observacao();
        presenca.data = dto.data();

        presenca.persist();

        return PresencaResponse.fromEntity(presenca);
    }

    @Transactional
    public PresencaResponse atualizar(Long id, PresencaRequest dto) {

        Presenca presenca = Presenca.findById(id);

        if (presenca == null) {
            throw new NotFoundException("Presença não encontrada");
        }

        presenca.status = dto.status();
        presenca.observacao = dto.observacao();

        return PresencaResponse.fromEntity(presenca);
    }

    @Transactional
    public void deletar(Long id) {
        if (!Presenca.deleteById(id)) {
            throw new NotFoundException("Presença não encontrada");
        }
    }
}
