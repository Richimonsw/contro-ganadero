package com.control.ganadero.controganadero.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_CUIDADOR")
@Getter
@Setter
public class Cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "CEDULA", nullable = false)
    private String cedula;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONO")
    private String telefono;

    @OneToMany(mappedBy = "cuidador", cascade=CascadeType.REMOVE)
    private List<Animal> animal;
    
}
