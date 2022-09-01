package com.control.ganadero.controganadero.services;

import java.util.List;

import com.control.ganadero.controganadero.dto.AnimalCuidadorDTO;
import com.control.ganadero.controganadero.dto.AnimalDTO;
import com.control.ganadero.controganadero.dto.NewAnimalDTO;

public interface AnimalService {
    
    public AnimalDTO create(Long idCuidador, NewAnimalDTO animalDTO);
    public AnimalCuidadorDTO retrieve(Long idCuidador, Long id);
    public AnimalCuidadorDTO update(AnimalDTO animalDTO, Long idCuidador, Long id);
    public void delete(Long idCuidador, Long id);
    public List<AnimalDTO> list(Long idCuidador);
}
