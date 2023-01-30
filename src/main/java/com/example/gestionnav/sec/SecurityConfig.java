package com.example.gestionnav.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailes customUserdetailes ;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customUserdetailes) ;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.logout().permitAll();
		http.authorizeRequests().antMatchers("resources/static/**","/login","/").permitAll();
		http.authorizeRequests().antMatchers("/registeruser","/Postregister").permitAll();
//		http.authorizeHttpRequests().antMatchers("/admin").hasAuthority("ADMIN");
		
		http.authorizeRequests().anyRequest().authenticated() ;
		http.exceptionHandling().accessDeniedPage("/403");
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder() ;
	}

}
