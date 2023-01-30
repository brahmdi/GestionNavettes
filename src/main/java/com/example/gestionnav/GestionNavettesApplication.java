package com.example.gestionnav;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.gestionnav.entites.Roles;
import com.example.gestionnav.entites.User;
import com.example.gestionnav.metier.ServiceUser;



@SpringBootApplication
public class GestionNavettesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionNavettesApplication.class, args);
	}

}
