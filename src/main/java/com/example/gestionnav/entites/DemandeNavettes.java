package com.example.gestionnav.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class DemandeNavettes {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String date_debut ;
    private String date_fin ;
    private String h_dep ;
    private String h_ar ;
    private String v_dep ;
    private String v_ar ;
    
    @ManyToOne
    private Client client ;

	public DemandeNavettes(String date_debut, String date_fin, String h_dep, String h_ar, String v_dep, String v_ar) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.h_dep = h_dep;
		this.h_ar = h_ar;
		this.v_dep = v_dep;
		this.v_ar = v_ar;
	}

	public DemandeNavettes() {
		super();
	}
    
}
