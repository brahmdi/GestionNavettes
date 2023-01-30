package com.example.gestionnav.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnav.entites.*;

public interface UserRepositry extends JpaRepository<User, Long> {
  
	User findByUsername(String username) ;
//	Boolean exsitByUsername(String username) ;
	
}
