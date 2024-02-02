package com.skilldistillery.reciperecommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.UserDAO;
import com.skilldistillery.reciperecommender.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@GetMapping("home")
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(path = "login.do", params = {"username", "password"})
	public String authenticateLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User u = userDAO.authenticateUser(username, password);
		if (u != null) {
			return "recipe";
		} else {
			return "home";
		}

	}

	@PostMapping("register.do")
	public String showRegistrationForm(User user, Model model) {
		model.addAttribute("user", new User());
		
		return "register";
		
	}
	
	@PostMapping("registerResult.do")
	public String registerUser(@RequestParam User user, String username, String password, Model model) {
		
		try {
			userDAO.registerUser(user, username, password);
			return "registerResult";
		} catch (Exception e) {
			return "register";
		}
	}
}