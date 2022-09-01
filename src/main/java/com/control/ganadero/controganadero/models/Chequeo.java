package com.control.ganadero.controganadero.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_CHEQUEO")
@Getter
@Setter
public class Chequeo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="FECHA_CHEQUEO")
    private String fechaCheq;

    @Column(name="OBSERVACIONES")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_ID", nullable=false)
    private Animal animal;
}

