package com.skilldistillery.reciperecommender.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.IngredientDAO;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class IngredientController {
	@Autowired
	private IngredientDAO ingredientDAO;

	@GetMapping(path = "findall.do")
	public String findAll(Model model) {
		List<Recipe> recipes = ingredientDAO.findAll();
		model.addAttribute("recipes", recipes);
		return "list";
	}

	@RequestMapping(path = "generateRecipes.do")
	public String generateRecipes(HttpSession session, Model model) {
		try {
			User user = (User) session.getAttribute("user");
			List<Recipe> topRecipes = ingredientDAO.generateRecipes(user);
			model.addAttribute("topRecipes", topRecipes);
			return "displayRecipe";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
