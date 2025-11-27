package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"data"})
})
public class SabadoReuniao extends BaseEntity {

    @Column(nullable = false, unique = true)
    public LocalDate data;

    @Column(nullable = false)
    public boolean letivo = true;

    @Column(nullable = false)
    public boolean realizado = false;
}
