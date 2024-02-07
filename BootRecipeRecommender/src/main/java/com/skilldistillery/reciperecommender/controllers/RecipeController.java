package com.skilldistillery.reciperecommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.RecipeDAO;
import com.skilldistillery.reciperecommender.entities.Recipe;


@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO recipeDAO;


	@RequestMapping(path = "showRecipe.do")
	public String showRecipe(@RequestParam("recipeId") int recipeId, Model model) {
	    Recipe recipe = recipeDAO.findById(recipeId); // Adjust this method according to your DAO implementation
	    model.addAttribute("recipe", recipe);
	    return "showRecipe";
	}

}