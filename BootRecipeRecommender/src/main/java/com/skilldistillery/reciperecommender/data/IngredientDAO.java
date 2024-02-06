package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

public interface IngredientDAO {

	List<Ingredient> findIngredientByName(User user, String namePattern);

	void removeIngredient(User user, Ingredient ingredient);

	public List<Recipe> generateRecipes(User user, List<Ingredient> ingredients, Ingredient ingredient);

	void addToPantry(User user, Ingredient ingredient);

	Ingredient findById(int id);

	List<Recipe> findAll();

	List<Recipe> findRecipesByIngredients(String name);

}