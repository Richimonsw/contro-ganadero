package com.control.ganadero.controganadero.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.control.ganadero.controganadero.dto.CuidadorListDTO;
import com.control.ganadero.controganadero.dto.CuidadorDTO;
import com.control.ganadero.controganadero.dto.NewCuidadorDTO;
import com.control.ganadero.controganadero.exceptions.NoContentException;
import com.control.ganadero.controganadero.exceptions.ResourceNotFoundException;
import com.control.ganadero.controganadero.models.Cuidador;
import com.control.ganadero.controganadero.repositories.CuidadorRepository;
import com.control.ganadero.controganadero.services.CuidadorService;

@Service
public class CuidadorServiceImpl implements CuidadorService {

    final ModelMapper modelMapper;
    final CuidadorRepository repository;
    
    public CuidadorServiceImpl(CuidadorRepository r, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = r;
    }

    @Override
    @Transactional
    public CuidadorDTO create(NewCuidadorDTO cuidadorDTO) {
        Cuidador cuidador = modelMapper.map(cuidadorDTO, Cuidador.class);
        repository.save(cuidador);
        return modelMapper.map(cuidador, CuidadorDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public CuidadorDTO retrieve(Long id) {
        Cuidador cuidador = repository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found."));
        return modelMapper.map(cuidador, CuidadorDTO.class);
    }

    @Override
    @Transactional
    public CuidadorDTO update(CuidadorDTO cuidadorDTO, Long id) {
        Cuidador cuidador = repository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found."));
        cuidador.setId(id);
        cuidador = modelMapper.map(cuidadorDTO, Cuidador.class);
        repository.save(cuidador);
        return modelMapper.map(cuidador, CuidadorDTO.class);
    }

    @Override
    @Transactional
    public void delete( Long id) {
        Cuidador cuidador = repository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found."));
        repository.deleteById(cuidador.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<CuidadorListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ?
            PageRequest.of(page, size)
        :   PageRequest.of(page, size, Sort.by(sort));

        Page<Cuidador> cuidadores = repository.findAll(pageable);
        if(cuidadores.isEmpty()) throw new NoContentException("Animal is empty");
        return cuidadores.stream().map(cuidador -> modelMapper.map(cuidador, CuidadorListDTO.class))
            .collect(Collectors.toList());
    }
    
    @Override
    public long count() {
        return repository.count();
    }
}