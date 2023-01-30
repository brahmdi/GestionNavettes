package com.example.gestionnav.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "USER")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(unique = true)
	private String username;
	private String password;
	 
	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name= "user_id")}, inverseJoinColumns = {@JoinColumn( name = "role_id")})
	@JoinTable( 
	        name = "users_roles", 
	        joinColumns = @JoinColumn(
	          name = "user_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "id")) 
	private Collection<Roles> roles = new ArrayList<Roles>() ;
	
	@OneToOne(mappedBy = "user")
    @JoinColumn(name ="user_id")
	private Client client ;

}
