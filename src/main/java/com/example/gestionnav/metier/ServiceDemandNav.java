package com.example.gestionnav.metier;

import java.util.ArrayList;
import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gestionnav.dao.ClientRepositry;
import com.example.gestionnav.dao.DemandeNavRepositry;
import com.example.gestionnav.entites.Client;
import com.example.gestionnav.entites.DemandeNavettes;
import com.example.gestionnav.entites.DemandesCount;

@Component
@Transactional
public class ServiceDemandNav {
	
	@Autowired
	DemandeNavRepositry dnavrepo ;
	
	@Autowired
	ClientRepositry clrepo ;
	
	public void addDemand(Client cl , DemandeNavettes demande) {
		demande.setClient(cl);
		cl.getListdemand().add(demande);
		dnavrepo.save(demande) ;
	}
//    public ArrayList<Object[]> afficheDemandes(){
//    	return dnavrepo.findDemandes() ;
//    }
    public ArrayList<DemandesCount> afficheDemandesCountes(){
    	return dnavrepo.findeDemandesCount();
    }
    
    public void deletedemande(String ddubet , String date_fin) {
    	ArrayList<DemandeNavettes> demandes = dnavrepo.finddemand(ddubet, date_fin);
    	
    	for(DemandeNavettes d : demandes) {
    		dnavrepo.delete(d);
    	}
    	
    }
    

}
