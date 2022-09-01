package com.control.ganadero.controganadero.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewAnimalDTO {
    
    private String nombre;
    private String fechaNac;
    private String raza;
    private String propocito;
}
