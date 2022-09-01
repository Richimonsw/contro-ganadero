package com.control.ganadero.controganadero.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_ANIMALES")
@Getter
@Setter
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNac;

    @Column(name = "RAZA")
    private String raza;

    @Column(name = "PROPOCITO", nullable= false)
    private String propocito;

    @ManyToOne
    @JoinColumn(name = "CUIDADOR_ID", nullable = false)
    private Cuidador cuidador;

    @OneToMany(mappedBy = "animal")
    private List<Chequeo> chequeo;


}
