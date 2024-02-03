package com.skilldistillery.reciperecommender.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.reciperecommender.data.IngredientDAO;
import com.skilldistillery.reciperecommender.entities.Ingredient;

import jakarta.servlet.http.HttpSession;

@Controller
public class IngredientController {
	@Autowired
	private IngredientDAO ingredientDAO;


	@RequestMapping(path = "selectIngredient.do", params = "name")
	public String addIngredientToCart(HttpSession session, @RequestParam("name") String input, Model model) {
		try {
			model.addAttribute("ingredients", ingredientDAO.findIngredientsByName(input));
			return "recipe";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "recipe";
	}

	@RequestMapping(path = "displayIngredients.do", params = "name")
	public List<Ingredient> index(HttpSession session, @RequestParam("name") String input) {
		List<Ingredient> cart = (List<Ingredient>) session.getAttribute("userCart");
		List<Ingredient> patternIngredients = ingredientDAO.findIngredientsByName(input);
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("userCart", cart);
		}
		cart.addAll(patternIngredients);
		return cart;
	}
}
