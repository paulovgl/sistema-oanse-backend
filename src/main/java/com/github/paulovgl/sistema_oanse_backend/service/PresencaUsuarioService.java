package com.github.paulovgl.sistema_oanse_backend.service;

import java.time.DayOfWeek;

import com.github.paulovgl.sistema_oanse_backend.dto.PresencaUsuarioRequest;
import com.github.paulovgl.sistema_oanse_backend.dto.PresencaUsuarioResponse;
import com.github.paulovgl.sistema_oanse_backend.entity.PresencaUsuario;
import com.github.paulovgl.sistema_oanse_backend.entity.SabadoReuniao;
import com.github.paulovgl.sistema_oanse_backend.entity.Usuario;
import com.github.paulovgl.sistema_oanse_backend.entity.UsuarioAno;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PresencaUsuarioService {

    @Transactional
    public PresencaUsuarioResponse registrar(PresencaUsuarioRequest dto) {

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

        // Verifica se o usuário existe
        Usuario usuario = Usuario.findById(dto.usuarioId());
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        // Verifica se a presença já existe
        boolean jaExiste = PresencaUsuario.count(
                "usuario.id = ?1 AND data = ?2",
                dto.usuarioId(), dto.data()
        ) > 0;
        if (jaExiste) {
            throw new BadRequestException("Presença já registrada para esse usuário neste sábado");
        }

        int anoAtual = dto.data().getYear();

        // Verifica se o existe dados do ano do usuário
        UsuarioAno usuarioAno = UsuarioAno.find(
                "usuario.id = ?1 AND ano = ?2",
                usuario.id, anoAtual
        ).firstResult();

        if (usuarioAno == null) {
            usuarioAno = new UsuarioAno();
            usuarioAno.ano = anoAtual;
            usuarioAno.usuario = usuario;
            usuarioAno.clube = usuario.clube;
            usuarioAno.talentos = 0.0;
            usuarioAno.persist();
        }

        PresencaUsuario presenca = new PresencaUsuario();
        presenca.usuario = usuario;
        presenca.usuarioAno = usuarioAno;
        presenca.status = dto.status();
        presenca.observacao = dto.observacao();
        presenca.data = dto.data();

        presenca.persist();

        return PresencaUsuarioResponse.fromEntity(presenca);
    }

    @Transactional
    public PresencaUsuarioResponse atualizar(Long id, PresencaUsuarioRequest dto) {

        PresencaUsuario presenca = PresencaUsuario.findById(id);

        if (presenca == null) {
            throw new NotFoundException("Presença não encontrada");
        }

        presenca.status = dto.status();
        presenca.observacao = dto.observacao();

        return PresencaUsuarioResponse.fromEntity(presenca);
    }

    @Transactional
    public void deletar(Long id) {
        if (!PresencaUsuario.deleteById(id)) {
            throw new NotFoundException("Presença não encontrada");
        }
    }
}
