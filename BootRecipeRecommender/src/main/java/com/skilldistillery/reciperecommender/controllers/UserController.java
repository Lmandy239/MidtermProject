package com.skilldistillery.reciperecommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skilldistillery.reciperecommender.data.UserDAO;
import com.skilldistillery.reciperecommender.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	
	@GetMapping("/")
	public String home(Model model) {
		User u = userDAO.authenticateUser("test", "test");
		model.addAttribute("testUser",u);
		return "home";
		
	}
}
