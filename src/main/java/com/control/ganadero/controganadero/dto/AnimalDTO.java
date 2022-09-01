package com.control.ganadero.controganadero.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO extends NewAnimalDTO {
    private Long id;
    private List<ChequeoDTO> chequeos;
}
