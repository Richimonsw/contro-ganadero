package com.control.ganadero.controganadero.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.ganadero.controganadero.dto.AnimalCuidadorDTO;
import com.control.ganadero.controganadero.dto.AnimalDTO;
import com.control.ganadero.controganadero.dto.NewAnimalDTO;
import com.control.ganadero.controganadero.services.AnimalService;


@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/cuidador")
public class AnimalController {
    
    final AnimalService service;

    public AnimalController(AnimalService srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/{id}/animal")
    public ResponseEntity<AnimalDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewAnimalDTO animalDTO){
        AnimalDTO questioDTO = service.create(id, animalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(questioDTO);        
    }

    /* ================ RETRIEVE ================ */
    @Secured({"ROLE_ADMIN", "ROLE_VISITANTE"})
    @GetMapping("/{idCuidador}/animal/{id}")
    public ResponseEntity<AnimalCuidadorDTO> retrive(@PathVariable("idCuidador") Long idCuidador, @PathVariable("id") Long id){
        AnimalCuidadorDTO result = service.retrieve(idCuidador, id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @Secured({"ROLE_ADMIN"})
    @PutMapping("/{idCuidador}/animal/{id}")
    public ResponseEntity<AnimalCuidadorDTO> update(@RequestBody AnimalDTO animalDTO, @PathVariable("idCuidador") Long idCuidador, @PathVariable("id") Long id){
        AnimalCuidadorDTO result = service.update(animalDTO, idCuidador, id);
        return ResponseEntity.ok().body(result);
    }
    
    /* ================ DELETE ================ */
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{idCuidador}/animal/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idCuidador") Long idCuidador, @PathVariable("id") Long id){
        service.delete(idCuidador, id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @Secured({"ROLE_ADMIN", "ROLE_VISITANTE"})
    @GetMapping("/{id}/animal")
    public ResponseEntity<List<AnimalDTO>> list(@PathVariable("id") Long id){
        List<AnimalDTO> animals = service.list(id);
        return ResponseEntity.ok().body(animals);        
    }
}
