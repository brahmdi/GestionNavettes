package com.example.gestionnav.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnav.entites.*;

public interface RoleRepositry extends JpaRepository<Roles, Long> {
	
	Roles findByRole(String role) ;
	

}
