package com.github.paulovgl.sistema_oanse_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Secao extends BaseEntity {

    @Column(nullable = false)
    public String name;

    public Double talentos;

    @ManyToOne
    public Clube clube;
}
