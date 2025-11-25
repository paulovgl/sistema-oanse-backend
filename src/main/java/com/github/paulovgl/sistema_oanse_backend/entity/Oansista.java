package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Oansista extends BaseEntity {

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String responsavel;

    public LocalDate dataNasc;

    public String contato;

    @Column(columnDefinition = "TEXT")
    public String observacao;

    @ManyToOne
    public Clube clube;

    @OneToMany(mappedBy = "oansista")
    public List<OansistaAno> anos;

    @OneToMany(mappedBy = "oansista")
    public List<Presenca> presencas;
}
