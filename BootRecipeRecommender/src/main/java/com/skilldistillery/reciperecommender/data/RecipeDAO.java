package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

public interface RecipeDAO {
	Recipe findById(int id);

	List<Recipe> allRecipe();

	List<Recipe> generateRecipes(User user);

	Recipe addRecipe();

	public Recipe favoriteThisRecipe(User user, Recipe recipe);

	void saveThisRecipe(User user, Recipe recipe);

}
