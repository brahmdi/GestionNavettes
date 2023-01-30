package com.example.gestionnav.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "ROLE")
public class Roles {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	private String role ;
	
	@ManyToMany( mappedBy = "roles" , fetch = FetchType.EAGER)
	private Collection<User> users = new ArrayList<User>() ;

	
}
