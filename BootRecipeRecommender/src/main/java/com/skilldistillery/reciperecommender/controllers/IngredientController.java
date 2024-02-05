package com.skilldistillery.reciperecommender.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.IngredientDAO;
import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class IngredientController {
	@Autowired
	private IngredientDAO ingredientDAO;

	@RequestMapping(path = "searchIngredientFromStore.do", params = "name")
	public String searchIngredientFromStore(HttpSession session, @RequestParam("name") String input,
			@ModelAttribute("user") User user, Model model) {
		try {
			List<Ingredient> ingredients = ingredientDAO.findIngredientByName(user, input);
			model.addAttribute("ingredients", ingredients);
			for (Ingredient ingredient : ingredients) {
				session.setAttribute("itemToAdd", ingredient);
			}
			return "userIngredient";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@RequestMapping(path = "removeIngredientFromPantry.do")
	public String removeIngredientFromPantry(HttpSession session, User user) {
		try {
			Ingredient ingredient = (Ingredient) session.getAttribute("itemToAdd");
			ingredientDAO.removeIngredient(user, ingredient);
			return "userIngredient";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@RequestMapping(path = "populatePantry.do")
	public String addIngredientToPantry(HttpSession session, User user) {
		try {
			Ingredient ingredient = (Ingredient) session.getAttribute("itemToAdd");
			ingredientDAO.addToPantry(user, ingredient);
			return "userIngredient";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@RequestMapping(path = "generateRecipe.do")
	public String generateRecipes(HttpSession session, List<Ingredient> ingredients, User user) {
		try {
			List<Recipe> recipes = ingredientDAO.generateRecipes(user, ingredients);
			return "userIngredient";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
