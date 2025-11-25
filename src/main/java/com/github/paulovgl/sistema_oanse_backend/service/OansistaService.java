package com.github.paulovgl.sistema_oanse_backend.service;

import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.dto.OansistaRequest;
import com.github.paulovgl.sistema_oanse_backend.entity.Clube;
import com.github.paulovgl.sistema_oanse_backend.entity.Oansista;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class OansistaService {

    public List<Oansista> listar(Integer page, Integer pageSize) {
        return Oansista.findAll().page(page, pageSize).list();
    }

    public Oansista buscarPorId(Long id) {
        Oansista oansista = Oansista.findById(id);

        if (oansista == null) {
            throw new NotFoundException("Oansista não encontrado");
        }

        return oansista;
    }

    public List<Oansista> buscarPorClube(Long clubeId) {
        return Oansista.list("clube.id", clubeId);
    }

    public List<Oansista> buscarPorNome(String nome) {
        return Oansista.list("LOWER(name) LIKE ?1", "%" + nome.toLowerCase() + "%");
    }

    @Transactional
    public Oansista criar(OansistaRequest dto) {

        Clube clube = Clube.findById(dto.clubeId());

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

        return newOansista;
    }

    @Transactional
    public Oansista atualizar(Long id, OansistaRequest dto) {

        Oansista oansista = buscarPorId(id);
        Clube clube = Clube.findById(dto.clubeId());

        if (clube == null) {
            throw new NotFoundException("Clube não encontrado");
        }

        oansista.name = dto.name();
        oansista.responsavel = dto.responsavel();
        oansista.dataNasc = dto.dataNasc();
        oansista.contato = dto.contato();
        oansista.observacao = dto.observacao();
        oansista.clube = clube;

        Oansista.persist(oansista);

        return oansista;
    }

    @Transactional
    public void deletar(Long id) {
        boolean deletado = Oansista.deleteById(id);

        if (!deletado) {
            throw new NotFoundException("Oansista não encontrado");
        }
    }
}
