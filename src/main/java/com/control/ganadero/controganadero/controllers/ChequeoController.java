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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.ganadero.controganadero.dto.ChequeoDTO;
import com.control.ganadero.controganadero.dto.NewChequeoDTO;
import com.control.ganadero.controganadero.services.ChequeoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cuidador")
public class ChequeoController {

    final ChequeoService service;

    public ChequeoController(ChequeoService srv) {
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/{id}/animal/{idAnimal}/chequeo")
    public ResponseEntity<List<ChequeoDTO>> create(@PathVariable("id") Long id, @PathVariable("idAnimal") Long idAnimal, @Valid @RequestBody List<NewChequeoDTO> chequeosDTO){
        List<ChequeoDTO> chequeoDTOs = service.create(id, idAnimal, chequeosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(chequeoDTOs);        
    }

    /* ================ DELETE ================ */
    
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}/animal/{idAnimal}/chequeo")
    public ResponseEntity<List<ChequeoDTO>> delete(@PathVariable("id") Long id, @PathVariable("idAnimal") Long idChequeo){
        service.remove(id, idChequeo);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @Secured({"ROLE_ADMIN", "ROLE_VISITANTE"})
    @GetMapping("/{id}/animal/{idAnimal}/chequeo")
    public ResponseEntity<List<ChequeoDTO>> list(@PathVariable("id") Long id, @PathVariable("idAnimal") Long idChequeo){
        List<ChequeoDTO> chequeoDTOs = service.list(id, idChequeo);
        return ResponseEntity.status(HttpStatus.OK).body(chequeoDTOs);        
    }
}
