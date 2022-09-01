package com.control.ganadero.controganadero.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimalCuidadorDTO extends AnimalDTO {
    
    private CuidadorDTO cuidador;
}
