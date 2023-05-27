package com.example.icecreamfactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.icecreamfactory.entity.CustomUserDetails;
import com.example.icecreamfactory.entity.User;
import com.example.icecreamfactory.repository.UserRepository;

@Service
public class CustomUserDetailService{

	@Autowired
	private UserRepository userRepository;
	

}
