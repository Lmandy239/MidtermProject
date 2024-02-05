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
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class IngredientController {
	@Autowired
	private IngredientDAO ingredientDAO;

	@RequestMapping(path = "selectIngredient.do", params = "name")
	public String addIngredientToCart(HttpSession session, @RequestParam("name") String input,
			@ModelAttribute("user") User user, Model model) {
		
		try {
			List<Ingredient> ingredients = ingredientDAO.findIngredientByName(user, input);
			
			for (Ingredient ingredient : ingredients) {
				model.addAttribute("ingredient", ingredient);
			}
			

			return "userIngredient";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@RequestMapping(path = "removeIngredient.do", params = "name")
	public String removeIngredientFromCart(HttpSession session, @RequestParam("name") String name, User user) {
		try {
			Ingredient ingredient = (Ingredient) ingredientDAO.findIngredientByName(user, name);
			ingredientDAO.removeIngredient(user, ingredient);
			return "recipe";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
