package com.example.gestionnav.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnav.entites.Client;

public interface ClientRepositry extends JpaRepository<Client, Long>   {
	
	

}
