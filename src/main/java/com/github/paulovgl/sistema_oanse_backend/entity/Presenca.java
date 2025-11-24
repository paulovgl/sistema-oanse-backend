package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Presenca extends BaseEntity {

    public LocalDate data;

    @ManyToOne
    public Oansista oansista;

    @ManyToOne
    public OansistaAno oansistaAno;

    @ManyToOne
    public Usuario registradoPor;
}
