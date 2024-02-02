package com.skilldistillery.reciperecommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.UserDAO;
import com.skilldistillery.reciperecommender.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@GetMapping({"", "/", "home"})
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

	@GetMapping("register.do")
	public String showRegistrationForm(User user) {
		return "register";
	}
	
	@RequestMapping(path = "registerResult.do", params = {"username", "password"})
	public String registerUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			userDAO.registerUser(username, password);
			return "recipe";
		} catch (Exception e) {
			return "register";
		}
	}
}
//	}
//	@RequestMapping(path = "registerResult.do", params = {"username", "password"})
//	public String registerUser(@RequestParam String username, @RequestParam  String password) {
//		try {
//			userDAO.registerUser(username, password);
//			return "recipe";
//		} catch (Exception e) {
//			return "register";
//		}
//	}