package com.example.icecreamfactory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.icecreamfactory.entity.User;
import com.example.icecreamfactory.repository.UserRepository;
import com.example.icecreamfactory.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	List<User> list=new ArrayList<>();
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository=userRepository;
//		
//		list.add(new User("abc","abc","abc@gmail.com","NORMAL"));
//		list.add(new User("xyz","xyz","xyz@gmail.com","ADMIN"));
	}

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}

	@Override
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}

	

}
