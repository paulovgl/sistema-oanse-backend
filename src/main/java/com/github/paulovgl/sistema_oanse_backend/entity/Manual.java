package com.github.paulovgl.sistema_oanse_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Manual extends BaseEntity {

    @Column(nullable = false)
    public String nome;

    @ManyToOne(optional = false)
    public Clube clube;

    @OneToMany(mappedBy = "manual", cascade = CascadeType.ALL)
    public List<Secao> secoes;
}
