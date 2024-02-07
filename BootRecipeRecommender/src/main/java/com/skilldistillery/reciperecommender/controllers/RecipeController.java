package com.skilldistillery.reciperecommender.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.RecipeDAO;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;


@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO recipeDAO;

	@GetMapping(path = "findall.do")
	public String findAll(Model model) {
		List<Recipe> recipes = recipeDAO.allRecipe();
		model.addAttribute("recipes", recipes);
		return "list";
	}

	@RequestMapping(path = "showRecipe.do")
	public String showRecipe(@RequestParam("recipeId") int recipeId, Model model) {
	    Recipe recipe = recipeDAO.findById(recipeId); // Adjust this method according to your DAO implementation
	    model.addAttribute("recipe", recipe);
	    return "showRecipe";
	}
	
	@RequestMapping(path = "generateRecipes.do")
	public String generateRecipes(HttpSession session, Model model) {
		try {
			User user = (User) session.getAttribute("user");
			List<Recipe> topRecipes = recipeDAO.generateRecipes(user);
			model.addAttribute("topRecipes", topRecipes);
			return "displayRecipe";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}