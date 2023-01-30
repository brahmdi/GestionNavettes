package com.example.gestionnav.metier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.gestionnav.dao.RoleRepositry;
import com.example.gestionnav.dao.UserRepositry;
import com.example.gestionnav.entites.Roles;
import com.example.gestionnav.entites.User;



@Component
@Transactional
public class ServiceUser {
	
	@Autowired 
    UserRepositry userrepo ;
	@Autowired
	RoleRepositry rolerepo ;
	public void adduser(User user) {
		userrepo.save(user);
	}
	
	public void addrole(Roles roles) {
		rolerepo.save(roles) ;
	}
	public User finduserbyname(String username) {
		return userrepo.findByUsername(username) ;
	}
	
	public Roles findrolebyname(String role) {
		return rolerepo.findByRole(role);
	}
	
	public void addRolToUser(String username , String rolename ) {
		 User user = finduserbyname(username) ;
		 Roles role = findrolebyname(rolename);
		 if(user.getRoles() != null) {
			 user.getRoles().add(role);
			 role.getUsers().add(user);
			 
		 }
		 
		 
	}


}
