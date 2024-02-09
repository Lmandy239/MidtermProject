package com.skilldistillery.reciperecommender.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	
	
	@RequestMapping("searchIngredientFromStore.do")
	public String searchIngredientFromStore(@RequestParam("searchResults") String searchResults,
			@RequestParam("formSource") String formSource, HttpSession session, Model model) {
		List<Ingredient> ingredients = ingredientDAO.findIngredientByName(searchResults);
		Collections.sort(ingredients, (ingredient1, ingredient2) -> {
			return Integer.compare(ingredient2.getRecipes().size(), ingredient1.getRecipes().size());
		});
		model.addAttribute("ingredients", ingredients);

		// Retrieve user from session
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		if ("addRecipe".equals(formSource)) {
			return "addRecipe";
		}
		return "userIngredient";
	}

	@RequestMapping("addToCart.do")
	public String addToCart(@RequestParam("id") int ingredientId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");

		if (user != null) {
			Ingredient ingredient = ingredientDAO.findById(ingredientId);

			userDAO.addToCart(user, ingredient, 1);

			session.setAttribute("user", userDAO.findById(user.getId()));
		}
		return "userIngredient";
	}

	@RequestMapping("removeFromCart.do")
	public String removeFromCart(@RequestParam("id") int ingredientId, HttpSession session) {
		User user = (User) session.getAttribute("user");

		Ingredient ingredient = ingredientDAO.findById(ingredientId);

		userDAO.removeFromCart(user, ingredient);

		session.setAttribute("user", userDAO.findById(user.getId()));

		return "userIngredient";
	}

	public void refreshSession(HttpSession session) {
		User u = (User) session.getAttribute("user");
		session.setAttribute("user", userDAO.findById(u.getId()));
	}
}