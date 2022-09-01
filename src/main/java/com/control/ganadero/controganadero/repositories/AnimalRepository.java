package com.control.ganadero.controganadero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.ganadero.controganadero.models.Animal;
import com.control.ganadero.controganadero.models.Cuidador;

//animal - vacuna
//cuidador - chequeo
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
    public List<Animal> findByCuidador(Cuidador cuidador);
}
