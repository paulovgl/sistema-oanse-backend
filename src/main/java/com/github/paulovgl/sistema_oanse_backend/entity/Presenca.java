package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

import jakarta.persistence.*;

@Entity
public class Presenca extends BaseEntity {

    @ManyToOne(optional = false)
    public Designacao designacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PresencaStatusType status;

    @Column(length = 255)
    public String observacao;

    @CreationTimestamp
    public LocalDate criadaEm;
}
