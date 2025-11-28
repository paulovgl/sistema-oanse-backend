package com.github.paulovgl.sistema_oanse_backend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.github.paulovgl.sistema_oanse_backend.type.PresencaStatusType;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"usuario_id", "data"})
})
public class PresencaUsuario extends BaseEntity {

    @ManyToOne(optional = false)
    public UsuarioAno usuarioAno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;

    @Column(nullable = false)
    public LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PresencaStatusType status;

    @Column(length = 255)
    public String observacao;

    @CreationTimestamp
    public LocalDateTime criadaEm;
}
