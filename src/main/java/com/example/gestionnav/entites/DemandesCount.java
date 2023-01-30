package com.example.gestionnav.entites;

import lombok.Data;

@Data
public class DemandesCount {
	
	private String date_debut ;
    private String date_fin ;
    private String h_dep ;
    private String h_ar ;
    private String v_dep ;
    private String v_ar ;
    private Long nbcl ;
	public DemandesCount(String date_debut, String date_fin, String h_dep, String h_ar, String v_dep, String v_ar,
			Long nbcl) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.h_dep = h_dep;
		this.h_ar = h_ar;
		this.v_dep = v_dep;
		this.v_ar = v_ar;
		this.nbcl = nbcl;
	}
	@Override
	public String toString() {
		return "DemandesCount [date_debut=" + date_debut + ", date_fin=" + date_fin + ", h_dep=" + h_dep + ", h_ar="
				+ h_ar + ", v_dep=" + v_dep + ", v_ar=" + v_ar + ", nbcl=" + nbcl + "]";
	}
    
    
    

}
