package com.github.paulovgl.sistema_oanse_backend.service;

import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.entity.Clube;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClubeService {

    public List<Clube> listar() {
        return Clube.listAll();
    }
}
