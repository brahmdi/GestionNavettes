package com.example.gestionnav.dao;



import java.util.ArrayList;

import org.hibernate.mapping.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gestionnav.entites.Navettes;


public interface NavettesRepositry extends JpaRepository<Navettes,Long> {
       
	@Query("SELECT n FROM Navettes n  WHERE n.v_dep like %:dep% and n.v_ar like  %:arr% ")
	ArrayList<Navettes>  findNavettesByDepandAr(@Param("dep") String dep  , @Param("arr") String arr);
}
