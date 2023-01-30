package com.example.gestionnav.metier;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gestionnav.dao.SocieteRepositry;
import com.example.gestionnav.entites.Societe;

@Component
public class ServiceSociete {
     @Autowired
	 SocieteRepositry sr ;
     public ArrayList<Societe> affichs(){
    	 return (ArrayList<Societe>) sr.findAll();
     }
     public Optional<Societe> findSociete(long id) {
    	 return sr.findById(id);
     }
     public Societe findSociete(String socite) {
    	 return sr.findByNoms(socite);
     }
    
}
