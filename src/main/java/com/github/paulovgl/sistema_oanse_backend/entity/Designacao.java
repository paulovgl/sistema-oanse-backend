package com.github.paulovgl.sistema_oanse_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"sabado_id", "oansista_id"}
        )
)
public class Designacao extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "sabado_id")
    public SabadoReuniao sabado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lider_id")
    public UsuarioAno lider;

    @ManyToOne(optional = false)
    @JoinColumn(name = "oansista_id")
    public Oansista oansista;
}
