package com.example.gestionnav.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Client {
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private  long id  ;
	    private String nomc ;
	    private String adresse ;
	    private String num_tel ;
	    
	    @ManyToMany
		@JoinTable( 
		        name = "abonnement", 
		        joinColumns = @JoinColumn(
		          name = "cl_id", referencedColumnName = "id"), 
		        inverseJoinColumns = @JoinColumn(
		          name = "navettes_id", referencedColumnName = "id")) 
		private Collection<Navettes> navettes = new ArrayList<Navettes>(); 
	    
	    @OneToOne
	    private User user ;
//	    Eager Loading is a design pattern in which data initialization occurs on the spot.
//	    Lazy Loading is a design pattern that we use to defer initialization of an object as long as it's possible.
	    @OneToMany(mappedBy = "client")
	    List<DemandeNavettes> listdemand = new ArrayList<DemandeNavettes>();
}
