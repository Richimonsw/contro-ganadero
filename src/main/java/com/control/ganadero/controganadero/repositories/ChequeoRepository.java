package com.control.ganadero.controganadero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.ganadero.controganadero.models.Animal;
import com.control.ganadero.controganadero.models.Chequeo;


public interface ChequeoRepository extends JpaRepository<Chequeo, Long> {

    public List<Chequeo> findByAnimal(Animal animal);
    
}
