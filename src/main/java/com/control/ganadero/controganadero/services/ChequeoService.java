package com.control.ganadero.controganadero.services;

import java.util.List;

import com.control.ganadero.controganadero.dto.ChequeoDTO;
import com.control.ganadero.controganadero.dto.NewChequeoDTO;



public interface ChequeoService {
    public List<ChequeoDTO> create(Long idCuidador, Long idAnimal, List<NewChequeoDTO> list);
    public List<ChequeoDTO> list(Long idCuidador, Long idAnimal);
    public void remove(Long idCuidador, Long idAnimal);
}
