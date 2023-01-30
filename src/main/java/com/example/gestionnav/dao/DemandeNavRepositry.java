package com.example.gestionnav.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gestionnav.entites.DemandeNavettes;
import com.example.gestionnav.entites.DemandesCount;
import com.example.gestionnav.entites.Navettes;

public interface DemandeNavRepositry extends JpaRepository<DemandeNavettes, Long> {
	
//	@Query("SELECT d.date_debut , d.date_fin , d.h_dep , d.h_ar , d.v_dep , d.v_ar , COUNT(d.id) AS clients FROM DemandeNavettes AS d group by d.date_debut , d.date_fin , d.h_dep , d.h_ar , d.v_dep , d.v_ar ")
//	ArrayList<Object[]> findDemandes() ;
	
	@Query("SELECT new com.example.gestionnav.entites.DemandesCount(d.date_debut , d.date_fin , d.h_dep , d.h_ar , d.v_dep , d.v_ar , COUNT(d.id)) FROM DemandeNavettes AS d group by d.date_debut , d.date_fin , d.h_dep , d.h_ar , d.v_dep , d.v_ar")
	ArrayList<DemandesCount> findeDemandesCount() ;
	
	@Query("SELECT d FROM DemandeNavettes d  WHERE d.v_dep like %:dep% and d.v_ar like  %:arr% ")
	ArrayList<DemandeNavettes>  finddemand(@Param("dep") String dep  , @Param("arr") String arr);

}
