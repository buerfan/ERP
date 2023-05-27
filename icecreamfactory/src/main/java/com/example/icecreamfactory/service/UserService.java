package com.example.icecreamfactory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.icecreamfactory.entity.Student;
import com.example.icecreamfactory.entity.User;


public interface UserService  {
	
	public List<User> getAllUsers();
	public User getUser(String username);
	public User addUser(User user);

}
