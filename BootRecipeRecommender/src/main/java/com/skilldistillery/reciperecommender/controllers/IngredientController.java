package com.skilldistillery.reciperecommender.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.reciperecommender.data.IngredientDAO;
import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class IngredientController {
	@Autowired
	private IngredientDAO ingredientDAO;

	@RequestMapping(path = "generateRecipes.do")
	public String generateRecipes(HttpSession session, User user, Ingredient ingredient) {
		try {
	        user = (User) session.getAttribute("user");
			//user.addIngredient(ingredient);
			List<Ingredient> ingredients = user.getIngredients();
			List<Recipe> recipes = ingredientDAO.generateRecipes(user, ingredients, ingredient);
			session.setAttribute("recipes", recipes);
			return "showRecipe";
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@RequestMapping("displayRecipe.do")
	public String displayRecipePage(HttpSession session, Ingredient ingredient) {
		@SuppressWarnings("unchecked")
		List<Recipe> recipes = (List<Recipe>) session.getAttribute("recipes");
		ingredient.setRecipes(recipes);
		for (Recipe recipe : recipes) {
			session.setAttribute("recipe", recipe);
		}
		return "recipeInfoPage";
	}

	@GetMapping(path = "findall.do")
	public String findAll(Model model) {
		List<Recipe> recipes = ingredientDAO.findAll();
		model.addAttribute("recipes", recipes);
		return "list";
	}
}
