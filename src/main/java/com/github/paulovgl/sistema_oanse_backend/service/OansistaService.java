package com.github.paulovgl.sistema_oanse_backend.service;

import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.dto.OansistaRequest;
import com.github.paulovgl.sistema_oanse_backend.dto.OansistaResponse;
import com.github.paulovgl.sistema_oanse_backend.entity.Clube;
import com.github.paulovgl.sistema_oanse_backend.entity.Oansista;
import com.github.paulovgl.sistema_oanse_backend.exception.PositiveOrZeroException;
import com.github.paulovgl.sistema_oanse_backend.exception.oansista.ListAllOansistasException;
import com.github.paulovgl.sistema_oanse_backend.exception.oansista.ListOansistasPerClubException;
import com.github.paulovgl.sistema_oanse_backend.exception.oansista.NotDeletedOansistaException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class OansistaService {

    public List<OansistaResponse> listar(Integer page, Integer pageSize) {

        // Verifica se os valores são menores que zero
        if (page < 0 || pageSize < 0) {
            throw new PositiveOrZeroException();
        }

        List<Oansista> oansistas = Oansista.findAll().page(page, pageSize).list();

        // Verifica se a requisição retornou um ou mais objetos
        if (oansistas.isEmpty()) {
            throw new ListAllOansistasException();
        }

        return OansistaResponse.mapAll(oansistas);
    }

    public OansistaResponse buscarPorId(Long id) {
        Oansista oansista = Oansista.findById(id);

        // Verifica se o objeto foi encontrado
        if (oansista == null) {
            throw new NotFoundException("Oansista não encontrado");
        }

        return OansistaResponse.fromEntity(oansista);
    }

    public List<OansistaResponse> buscarPorClube(Long clubeId) {

        List<Oansista> oansistas = Oansista.list("clube.id", clubeId);

        // Verifica se a requisição retornou um ou mais objetos
        if (oansistas.isEmpty()) {
            throw new ListOansistasPerClubException();
        }

        return OansistaResponse.mapAll(oansistas);
    }

    public List<OansistaResponse> buscarPorNome(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio");
        }

        List<Oansista> oansistas = Oansista.list(
                "LOWER(name) LIKE ?1",
                "%" + nome.toLowerCase() + "%"
        );

        if (oansistas.isEmpty()) {
            throw new ListAllOansistasException(); // ou uma específica se quiser
        }

        return OansistaResponse.mapAll(oansistas);
    }

    @Transactional
    public OansistaResponse criar(OansistaRequest dto) {

        Clube clube = Clube.findById(dto.clubeId());

        // TODO: Modificar quando a lógica do clube for feita
        if (clube == null) {
            throw new NotFoundException("Clube não encontrado");
        }

        Oansista oansista = new Oansista();
        oansista.name = dto.name();
        oansista.responsavel = dto.responsavel();
        oansista.dataNasc = dto.dataNasc();
        oansista.contato = dto.contato();
        oansista.observacao = dto.observacao();
        oansista.clube = clube;

        oansista.persist();

        return OansistaResponse.fromEntity(oansista);
    }

    @Transactional
    public OansistaResponse atualizar(Long id, OansistaRequest dto) {

        Oansista oansista = Oansista.findById(id);

        // Verifica se o objeto foi encontrado
        if (oansista == null) {
            throw new NotFoundException("Oansista não encontrado");
        }

        Clube clube = Clube.findById(dto.clubeId());

        // TODO: Modificar quando a lógica do clube for feita
        if (clube == null) {
            throw new NotFoundException("Clube não encontrado");
        }

        oansista.name = dto.name();
        oansista.responsavel = dto.responsavel();
        oansista.dataNasc = dto.dataNasc();
        oansista.contato = dto.contato();
        oansista.observacao = dto.observacao();
        oansista.clube = clube;

        return OansistaResponse.fromEntity(oansista);
    }

    @Transactional
    public void deletar(Long id) {
        boolean deletado = Oansista.deleteById(id);

        if (!deletado) {
            throw new NotDeletedOansistaException();
        }
    }
}
