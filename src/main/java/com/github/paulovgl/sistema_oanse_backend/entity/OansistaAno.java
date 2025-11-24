package com.github.paulovgl.sistema_oanse_backend.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"year", "oansista_id"})
})
public class OansistaAno extends BaseEntity {

    @Column(nullable = false)
    public Integer year;

    @ManyToOne
    @JoinColumn(name = "oansista_id")
    public Oansista oansista;

    @ManyToOne
    public Clube clube;

    public Double talentos;

    @OneToMany(mappedBy = "oansistaAno")
    public List<Presenca> presencas;

    @OneToMany(mappedBy = "oansistaAno")
    public List<SecaoFalada> secoesFaladas;
}
