package com.skilldistillery.reciperecommender.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.UserDAO;
import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@GetMapping({ "", "/", "home" })
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(path = "login.do", params = { "username", "password" })
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

	@RequestMapping(path = "registerResult.do", params = { "username", "password" })
	public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		try {
			userDAO.registerUser(username, password);
			return "registerResult";
		} catch (Exception e) {
			return "register";
		}
	}

	// tried to add ingredient to user entity list, but it didnt work.

	@RequestMapping(path = "selectIngredient.do", params = "name")
	public String addIngredientToCart(HttpSession session, @RequestParam("name") String input, Model model) {
		try {
			//userDAO.selectIngredient(input);
			model.addAttribute("ingredients", userDAO.displayCart(input));
			return "recipe";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "recipe";
	}

	// tried to remove ingredient from user cart

	@RequestMapping(path = "removeIngredient.do", params = "name")
	public String removingIngredientInCart(@ModelAttribute User user, @RequestParam("name") String name) {
		try {
			//userDAO.removeIngredient(user, name);
			return "recipe";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "recipe";
	}

	@RequestMapping(path = "showIngredients.do", params = "name")
	public String index(@ModelAttribute User user, @RequestParam("name") String input, Model model) {
		List<Ingredient> ingredients = userDAO.displayCart(input);
		model.addAttribute("ingredients", ingredients);
		return "recipe";
	}

	@RequestMapping(path = "displayIngredients.do", params = "name")
	public List<Ingredient> index(HttpSession session, @RequestParam("name") String input) {
		List<Ingredient> cart = (List<Ingredient>) session.getAttribute("userCart");
		List<Ingredient> patternIngredients = userDAO.displayCart(input);
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("userCart", cart);
		}
		cart.addAll(patternIngredients);
		return cart;
	}
}
