package com.skilldistillery.reciperecommender.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.IngredientDAO;
import com.skilldistillery.reciperecommender.data.UserDAO;
import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private IngredientDAO ingredientDAO;
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(path = "searchIngredientFromStore.do", params = "searchResults")
	public String searchIngredientFromStore(@RequestParam("searchResults") String searchResults, HttpSession session,
			Model model, User user) {
		List<Ingredient> ingredients = ingredientDAO.findIngredientByName(user, searchResults);
		model.addAttribute("ingredients", ingredients);

		// Retrieve user from session
		user = (User) session.getAttribute("user");
		model.addAttribute("user", user);

		return "userIngredient";
	}

	@RequestMapping("addToCart.do")
	public String addToCart(@RequestParam("id") int ingredientId, HttpSession session, Model model) {
		// Retrieve user from session
		User user = (User) session.getAttribute("user");

		// Make sure there is a user
		if (user != null) {
			// Find the selected ingredient
			Ingredient ingredient = ingredientDAO.findById(ingredientId);
			// Add ingredient to the user's cart
			user.addIngredient(ingredient);
			System.out.println("++++++++++++++++++++++++++++++++++++++++" + user);
			session.setAttribute("user", user);
		}
		return "userIngredient";
	}

	@RequestMapping("removeFromCart.do")
	public String removeFromCart(@RequestParam("id") int ingredientId, HttpSession session) {
		// Retrieve user from session
		User user = (User) session.getAttribute("user");

		Ingredient ingredient = ingredientDAO.findById(ingredientId);
		// Remove ingredient from the user's cart
		user.removeIngredient(ingredient);
		session.setAttribute("user", user);

		return "userIngredient";
	}

	public void refreshSession(HttpSession session) {
		User u = (User) session.getAttribute("user");
		session.setAttribute("user", userDAO.findById(u.getId()));
	}
}