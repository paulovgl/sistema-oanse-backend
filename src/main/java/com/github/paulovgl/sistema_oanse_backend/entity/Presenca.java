package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"oansista_id", "data"})
})
public class Presenca extends BaseEntity {

    @ManyToOne(optional = false)
    public OansistaAno oansistaAno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "oansista_id")
    public Oansista oansista;

    @Column(nullable = false)
    public LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PresencaStatusType status;

    @Column(length = 255)
    public String observacao;

    @CreationTimestamp
    public LocalDate criadaEm;
}
