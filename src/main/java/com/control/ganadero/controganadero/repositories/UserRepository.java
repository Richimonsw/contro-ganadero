package com.control.ganadero.controganadero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.ganadero.controganadero.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
}
