package com.example.gestionnav.metier;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gestionnav.dao.ClientRepositry;
import com.example.gestionnav.dao.DemandeNavRepositry;
import com.example.gestionnav.dao.NavettesRepositry;
import com.example.gestionnav.entites.Client;
import com.example.gestionnav.entites.Navettes;
//au demarage creer moi un objet de cette class
@Component
@Transactional
public class ServiceClient {
	
	@Autowired
	NavettesRepositry nvtrepo ;
	@Autowired
	ClientRepositry clrepo ;
	

	public void addClient(Client cl) {
		clrepo.save(cl);
	}
	public void addAbonnment(Optional<Navettes> nvt , Client cl ) {
		if (nvt != null && cl != null) {
			nvt.get().getClients().add(cl);
			cl.getNavettes().add(nvt.get());
		}
	
	}
	


}
