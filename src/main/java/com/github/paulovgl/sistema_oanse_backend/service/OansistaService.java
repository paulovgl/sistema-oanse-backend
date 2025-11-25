package com.github.paulovgl.sistema_oanse_backend.service;

import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.dto.OansistaRequest;
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

    public List<Oansista> listar(Integer page, Integer pageSize) {

        // Verifica se os valores são menores que zero
        if (page < 0 || pageSize < 0) {
            throw new PositiveOrZeroException();
        }

        List<Oansista> oansistas = Oansista.findAll().page(page, pageSize).list();

        // Verifica se a requisição retornou um ou mais objetos
        if (oansistas.isEmpty()) {
            throw new ListAllOansistasException();
        }

        return oansistas;
    }

    public Oansista buscarPorId(Long id) {
        Oansista oansista = Oansista.findById(id);

        // Verifica se o objeto foi encontrado
        if (oansista == null) {
            throw new NotFoundException("Oansista não encontrado");
        }

        return oansista;
    }

    public List<Oansista> buscarPorClube(Long clubeId) {

        List<Oansista> oansistasDoClube = Oansista.list("clube.id", clubeId);

        // Verifica se a requisição retornou um ou mais objetos
        if (oansistasDoClube.isEmpty()) {
            throw new ListOansistasPerClubException();
        }

        return oansistasDoClube;
    }

    public List<Oansista> buscarPorNome(String nome) {
        return Oansista.list("LOWER(name) LIKE ?1", "%" + nome.toLowerCase() + "%");
    }

    @Transactional
    public Oansista criar(OansistaRequest dto) {

        Clube clube = Clube.findById(dto.clubeId());

        // TODO: Modificar quando a lógica do clube for feita
        if (clube == null) {
            throw new NotFoundException("Clube não encontrado");
        }

        Oansista newOansista = new Oansista();
        newOansista.name = dto.name();
        newOansista.responsavel = dto.responsavel();
        newOansista.dataNasc = dto.dataNasc();
        newOansista.contato = dto.contato();
        newOansista.observacao = dto.observacao();
        newOansista.clube = clube;

        newOansista.persist();

        return newOansista;
    }

    @Transactional
    public Oansista atualizar(Long id, OansistaRequest dto) {

        Oansista oansista = buscarPorId(id);
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

        return oansista;
    }

    @Transactional
    public void deletar(Long id) {
        boolean deletado = Oansista.deleteById(id);

        if (!deletado) {
            throw new NotDeletedOansistaException();
        }
    }
}
