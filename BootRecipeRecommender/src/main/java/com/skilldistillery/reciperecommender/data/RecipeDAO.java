package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Comment;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.RecipeImpression;
import com.skilldistillery.reciperecommender.entities.User;

public interface RecipeDAO {
	Recipe findById(int id);

	List<Recipe> allRecipe();

	List<Recipe> generateRecipes(User user);

	Recipe favoriteThisRecipe(User user, Recipe recipe);

	void unfavoriteThisRecipe(User user, Recipe recipe);

	RecipeImpression mapThisRecipeToUser(User user, Recipe recipe);

	void unmapThisRecipeToUser(User user, Recipe recipe);

	List<Comment> findCommentsByRecipeId(int recipeId);

	void addCommentToRecipe(int recipeId, Comment comment);
	
	Recipe create(Recipe recipe);

}
