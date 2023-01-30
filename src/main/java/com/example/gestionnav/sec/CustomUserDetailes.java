package com.example.gestionnav.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.gestionnav.dao.UserRepositry;
import com.example.gestionnav.entites.User;

@Service
public class CustomUserDetailes implements UserDetailsService {
    
	@Autowired
	UserRepositry userRepo ;
	
	public CustomUserDetailes(UserRepositry userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userE = userRepo.findByUsername(username) ;
		if (userE == null) {
            throw new UsernameNotFoundException(username);
        }
		return new  MyuserDetailes(userE);
	}

}
