package com.skilldistillery.reciperecommender.controllers;

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

	@RequestMapping(path = "selectIngredient.do", params = { "ingredient" })
	public String addIngredientToCart(@ModelAttribute User user, @RequestParam("ingredient") String name, Model model) {
		try {
			Ingredient ingredient = userDAO.selectIngredient(name);
			user.addIngredient(ingredient);
			model.addAllAttributes(user.getIngredients());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "recipe";
	}

	// tried to remove ingredient from user cart

	@RequestMapping(path = "removeIngredient.do", params = { "ingredient" })
	public String removingIngredientInCart(@ModelAttribute User user, @RequestParam("ingredient") Ingredient ingredient,
			Model model) {
		try {
			user.removeIngredient(ingredient);
			model.addAllAttributes(user.getIngredients());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "recipe";
	}
//	
//	@GetMapping("showIngredients.do")
//	public String index(Model model) {
//		List<Ingredient> ingredients = userDAO.displayCart();
//		model.addAttribute("ingredients", ingredients);
//		return "recipe";
//	}
}
