package com.github.paulovgl.sistema_oanse_backend.entity;

import com.github.paulovgl.sistema_oanse_backend.type.PapelType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario extends BaseEntity {

    @Column(nullable = false)
    public String name;

    @Column(unique = true)
    public String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PapelType role;

    @ManyToOne
    public Clube clube;
}
