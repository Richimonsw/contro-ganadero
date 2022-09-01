package com.control.ganadero.controganadero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.ganadero.controganadero.models.Cuidador;


public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    
    public List<Cuidador> findByNombre(String criteria);
}
