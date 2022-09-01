package com.control.ganadero.controganadero.services;

import java.util.List;

import com.control.ganadero.controganadero.dto.CuidadorDTO;
import com.control.ganadero.controganadero.dto.CuidadorListDTO;
import com.control.ganadero.controganadero.dto.NewCuidadorDTO;


public interface CuidadorService {
    public CuidadorDTO create(NewCuidadorDTO cuidadorDTO);
    public CuidadorDTO retrieve(Long id);
    public CuidadorDTO update(CuidadorDTO cuidadorDTO, Long id);
    public void delete( Long id);
    public long count();
    public List<CuidadorListDTO> list(int page, int size, String sort);
}
