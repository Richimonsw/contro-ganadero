package com.control.ganadero.controganadero.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.control.ganadero.controganadero.dto.ChequeoDTO;
import com.control.ganadero.controganadero.dto.NewChequeoDTO;
import com.control.ganadero.controganadero.exceptions.NoContentException;
import com.control.ganadero.controganadero.exceptions.ResourceNotFoundException;
import com.control.ganadero.controganadero.models.Animal;
import com.control.ganadero.controganadero.models.Chequeo;
import com.control.ganadero.controganadero.models.Cuidador;
import com.control.ganadero.controganadero.repositories.AnimalRepository;
import com.control.ganadero.controganadero.repositories.ChequeoRepository;
import com.control.ganadero.controganadero.repositories.CuidadorRepository;
import com.control.ganadero.controganadero.services.ChequeoService;

@Service
public class ChequeoServiceImpl implements ChequeoService{

    final ModelMapper modelMapper;
    final ChequeoRepository chequeoRespository;
    final AnimalRepository animalRepository;
    final CuidadorRepository cuidadorRepository;

    public ChequeoServiceImpl(ModelMapper mapper, ChequeoRepository  respository, AnimalRepository arepo, CuidadorRepository crepo){
        this.modelMapper = mapper;
        this.chequeoRespository = respository;
        this.animalRepository = arepo;
        this.cuidadorRepository = crepo;
    }

    @Override
    @Transactional
    public List<ChequeoDTO> create(Long idCuidador, Long idAnimal, List<NewChequeoDTO> chequeos) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador).orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = animalRepository.findById(idAnimal).orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal.setCuidador(cuidador);
        List<ChequeoDTO> result = new ArrayList<ChequeoDTO>();
        for(NewChequeoDTO op : chequeos){
            Chequeo chequeo = modelMapper.map(op, Chequeo.class);
            chequeo.setAnimal(animal);
            chequeoRespository.save(chequeo);
            result.add(modelMapper.map(chequeo, ChequeoDTO.class));
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChequeoDTO> list(Long idCuidador, Long idAnimal) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador).orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = animalRepository.findById(idAnimal).orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal.setCuidador(cuidador);
        if(animal.getChequeo().isEmpty()) throw new NoContentException("Chequeo is empty");
        return animal.getChequeo().stream().map(op -> modelMapper.map(op, ChequeoDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void remove(Long idCuidador, Long idAnimal) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador).orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = animalRepository.findById(idAnimal).orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal.setCuidador(cuidador);
        if(animal.getChequeo().isEmpty()) throw new NoContentException("Chequeo is empty");
        animal.getChequeo().forEach(op -> {
            chequeoRespository.delete(op);            
        });                      
    }


    
    

    
}
