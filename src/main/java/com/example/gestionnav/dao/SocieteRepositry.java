package com.example.gestionnav.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnav.entites.Societe;

public interface SocieteRepositry extends JpaRepository<Societe,Long> {
    
    Societe findByNoms(String noms) ;
    
}
