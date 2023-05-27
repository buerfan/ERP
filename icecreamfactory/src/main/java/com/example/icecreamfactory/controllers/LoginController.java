package com.example.icecreamfactory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.icecreamfactory.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/signin")
	String login() {
		return "signin";
	}
	
	@PostMapping("/dologin")
	String performLogin() {
		return "logintest";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String loadForm(Model model) {
		
		List<com.example.icecreamfactory.entity.User> listOfUser=userService.getAllUsers();
        model.addAttribute("user", listOfUser);
        return "redirect:/login";
    }
}
