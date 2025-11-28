package com.github.paulovgl.sistema_oanse_backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UsuarioAno extends BaseEntity {

    @Column(nullable = false)
    public Integer ano;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;

    @ManyToOne
    public Clube clube;

    public Double talentos;

    @OneToMany(mappedBy = "usuarioAno")
    public List<PresencaUsuario> presencas = new ArrayList<>();
}
