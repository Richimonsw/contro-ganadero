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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.control.ganadero.controganadero.dto.CuidadorDTO;
import com.control.ganadero.controganadero.dto.CuidadorListDTO;
import com.control.ganadero.controganadero.dto.NewCuidadorDTO;
import com.control.ganadero.controganadero.services.CuidadorService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/cuidador")
public class CuidadorController {

    private final CuidadorService service;

    public CuidadorController(CuidadorService srv){
        this.service =srv;
    }
    /* ================ CREATE ================ */
    
    @Secured({"ROLE_ADMIN"})
    @PostMapping()
    public ResponseEntity<CuidadorDTO> create(@Valid @RequestBody NewCuidadorDTO cuidadorDTO){
        CuidadorDTO result = service.create(cuidadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    /* ================ RETRIEVE ================ */
    
    @Secured({"ROLE_ADMIN", "ROLE_VISITANTE"})
    @GetMapping("/{id}")
    public ResponseEntity<CuidadorDTO> retrive(@PathVariable("id") Long id){
        CuidadorDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }
    /* ================ UPDATE ================ */
    
    @Secured({"ROLE_ADMIN"})
    @PutMapping("/{id}")
    public ResponseEntity<CuidadorDTO> update(@RequestBody CuidadorDTO cuidadorDTO, @PathVariable("id") Long id){
        CuidadorDTO result = service.update(cuidadorDTO, id);
        return ResponseEntity.ok().body(result);
    }
    /* ================ DELETE ================ */
    
    
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */ 
    @Secured({"ROLE_ADMIN", "ROLE_VISITANTE"})
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<CuidadorListDTO>> list(@PathVariable("page") int page, 
        @PathVariable("size") int size,
        @RequestParam(name = "sort", required = false) String sort){
        List<CuidadorListDTO> result  = service.list(page, size, sort);
        return ResponseEntity.ok().body(result);        
    }

     /* ================ COUNT ================ */ 
     @Secured({"ROLE_ADMIN", "ROLE_VISITANTE"})
     @GetMapping("/count")
     public ResponseEntity<Long> count(){
         long result = service.count();
         return ResponseEntity.ok().body(result);        
     }
}
