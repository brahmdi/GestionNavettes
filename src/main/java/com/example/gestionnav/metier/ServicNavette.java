package com.example.gestionnav.metier;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gestionnav.dao.NavettesRepositry;
import com.example.gestionnav.dao.SocieteRepositry;
import com.example.gestionnav.entites.Navettes;
import com.example.gestionnav.entites.Societe;

@Component
@Transactional
public class ServicNavette {
      @Autowired
	  NavettesRepositry nvt ;
      @Autowired
      SocieteRepositry sct ;
      public ArrayList<Navettes> afficheNavettes() {
    	  return (ArrayList<Navettes>) nvt.findAll();
      }
      
      public void addNavettes(Navettes navettes, String noms) {
    	  Societe s = sct.findByNoms(noms) ;
    	  navettes.setSociete(s);
    	  nvt.save(navettes) ;
    	  s.getNavettes().add(navettes);
      }
      
      public ArrayList<Navettes> findnavettesbyville(String dep , String arr){
    	  return nvt.findNavettesByDepandAr(dep, arr) ;
      }
      
      public Optional<Navettes> findByid(Long id) {
    	  return nvt.findById(id) ;
      }
      
      
      
}
