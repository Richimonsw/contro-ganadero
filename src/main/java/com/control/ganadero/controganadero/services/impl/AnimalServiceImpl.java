package com.control.ganadero.controganadero.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.control.ganadero.controganadero.dto.AnimalCuidadorDTO;
import com.control.ganadero.controganadero.dto.AnimalDTO;
import com.control.ganadero.controganadero.dto.NewAnimalDTO;
import com.control.ganadero.controganadero.exceptions.NoContentException;
import com.control.ganadero.controganadero.exceptions.ResourceNotFoundException;
import com.control.ganadero.controganadero.models.Animal;
import com.control.ganadero.controganadero.models.Cuidador;
import com.control.ganadero.controganadero.repositories.AnimalRepository;
import com.control.ganadero.controganadero.repositories.CuidadorRepository;
import com.control.ganadero.controganadero.services.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {


    final ModelMapper modelMapper;
    final AnimalRepository animalRepository;
    final CuidadorRepository cuidadorRepository;

    public AnimalServiceImpl(AnimalRepository repository, ModelMapper maper, CuidadorRepository cuidrepo){
        this.animalRepository = repository;
        this.modelMapper = maper;
        this.cuidadorRepository = cuidrepo;
    }


    @Override
    @Transactional
    public AnimalDTO create(Long idCuidador, NewAnimalDTO animalDTO) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = modelMapper.map(animalDTO, Animal.class);
        animal.setCuidador(cuidador);
        animalRepository.save(animal);
        return modelMapper.map(animal, AnimalDTO.class);
    }

   
    @Override
    @Transactional(readOnly = true)
    public AnimalCuidadorDTO retrieve(Long idCuidador, Long id) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = animalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal.setCuidador(cuidador);
        return modelMapper.map(animal, AnimalCuidadorDTO.class);
    }

    @Override
    @Transactional
    public AnimalCuidadorDTO update(AnimalDTO animalDTO,Long idCuidador, Long id) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = animalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal = modelMapper.map(animalDTO, Animal.class);
        animal.setCuidador(cuidador);
        animalRepository.save(animal);
        return modelMapper.map(animal, AnimalCuidadorDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long idCuidador, Long id) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        Animal animal = animalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal.setCuidador(cuidador);
        animalRepository.deleteById(animal.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalDTO> list(Long idCuidador) {
        Cuidador cuidador = cuidadorRepository.findById(idCuidador)
            .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        List<Animal> animales = animalRepository.findByCuidador(cuidador);
        if(animales.isEmpty()) throw new NoContentException("Animal is empty");
        return animales.stream().map(a -> modelMapper.map(a, AnimalDTO.class)).collect(Collectors.toList());
    }
}
