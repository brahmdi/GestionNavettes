package com.example.gestionnav.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Societe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id  ;
    private String noms ;
    private String adresses ;
    private String num_tel ;
    
    @OneToMany(mappedBy = "societe")
    private Collection<Navettes> navettes = new ArrayList<Navettes>() ;

	@Override
	public String toString() {
		return "Societe [id=" + id + ", noms=" + noms + ", adresses=" + adresses + ", num_tel=" + num_tel;
	}
    
    
}
