package com.example.icecreamfactory.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	      .csrf()
	      .disable();
	    return http.build();
	}
	
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        
		Collection<UserDetails> collectionOfUsers=new ArrayList<UserDetails>();
		UserDetails user1 = User.withDefaultPasswordEncoder()
            .username("erfan")
            .password("erfan")
            .roles("USER")
            .build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
	            .username("asha")
	            .password("asha")
	            .roles("USER")
	            .build();
        
        collectionOfUsers.add(user1);
        collectionOfUsers.add(user2);
        return new InMemoryUserDetailsManager(collectionOfUsers);
    }

}
