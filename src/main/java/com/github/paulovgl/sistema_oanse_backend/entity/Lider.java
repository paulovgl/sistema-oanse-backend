package com.github.paulovgl.sistema_oanse_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Lider extends BaseEntity {

    @Column(nullable = false)
    public String nome;

    @Column(unique = true, nullable = false)
    public String email;

    @ManyToOne
    public Clube clube;
}
