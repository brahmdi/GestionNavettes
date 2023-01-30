package com.example.gestionnav.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Navettes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
    private String date_debut ;
    private String date_fin ;
    private String h_dep ;
    private String h_ar ;
    private String v_dep ;
    private String v_ar ;
    private String desc ;
    private long nbAbonne ;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Societe societe ;

	@Override
	public String toString() {
		return "Navettes [date_debut=" + date_debut + ", date_fin=" + date_fin + ", h_dep=" + h_dep + ", h_ar=" + h_ar
				+ ", v_dep=" + v_dep + ", v_ar=" + v_ar + ", desc=" + desc + ", nbAbonne=" + nbAbonne +  "]";
	}

	public Navettes(String date_debut, String date_fin, String h_dep, String h_ar, String v_dep, String v_ar,
			String desc, long nbAbonne) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.h_dep = h_dep;
		this.h_ar = h_ar;
		this.v_dep = v_dep;
		this.v_ar = v_ar;
		this.desc = desc;
		this.nbAbonne = nbAbonne;
	}

	public Navettes() {
		
	}
	@ManyToMany( mappedBy = "navettes")
	private Collection<Client> clients = new ArrayList<Client>() ;
	
    
}
