package com.control.ganadero.controganadero.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewCuidadorDTO {
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String telefono;

}
