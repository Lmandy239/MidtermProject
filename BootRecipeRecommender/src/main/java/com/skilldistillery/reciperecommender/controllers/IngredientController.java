package com.skilldistillery.reciperecommender.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(path = "findall.do")
	public String findAll(Model model) {
	    List<Recipe> recipes = ingredientDAO.findAll();
	    model.addAttribute("recipes", recipes);
	    return "list";
	}
}
