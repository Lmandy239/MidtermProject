package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

public interface IngredientDAO {

	List<Ingredient> findIngredientByName(User user, String namePattern);

	void removeIngredient(User user, Ingredient ingredient);

	List<Recipe> generateRecipes(User user);

	void addToPantry(User user, Ingredient ingredient);

	Ingredient findById(int id);
	
	List<Recipe> findAll();
	
	List<Recipe> findRecipesByIngredients(String name);
	
	public List<Recipe> allRecipe();
	
	// test changes
	//
	//
}