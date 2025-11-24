package com.github.paulovgl.sistema_oanse_backend.entity;

import java.util.List;

import com.github.paulovgl.sistema_oanse_backend.type.ClubeNomeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Clube extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    public ClubeNomeType name;

    @OneToOne
    public Usuario diretor;

    @OneToMany
    public List<Usuario> lideres;

    @OneToMany(mappedBy = "clube")
    public List<Oansista> oansistas;

    @OneToMany(mappedBy = "clube")
    public List<Secao> secoes;
}
