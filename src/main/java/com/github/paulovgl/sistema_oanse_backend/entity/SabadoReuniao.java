package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"data", "clube_id"})
})
public class SabadoReuniao extends BaseEntity {

    @Column(nullable = false)
    public LocalDate data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clube_id")
    public Clube clube;

    @Column(nullable = false)
    public boolean realizado = false;

    @OneToMany(mappedBy = "sabado", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Designacao> designacoes = new ArrayList<>();
}
