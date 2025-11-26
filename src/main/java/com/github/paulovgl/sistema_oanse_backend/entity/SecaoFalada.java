package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class SecaoFalada extends BaseEntity {

    @ManyToOne(optional = false)
    public OansistaAno oansistaAno;

    @ManyToOne(optional = false)
    public Secao secao;

    @ManyToOne(optional = false)
    public Lider lider;

    @Column(nullable = false)
    public LocalDate data;

    @Column(nullable = false)
    public Integer talentosRecebidos;

    @Column(length = 255)
    public String observacao;
}
