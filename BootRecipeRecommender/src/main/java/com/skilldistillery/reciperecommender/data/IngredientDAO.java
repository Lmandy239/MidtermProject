package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

public interface IngredientDAO {

	List<Ingredient> findIngredientByName(User user, String namePattern);
	void removeIngredient(User user, Ingredient ingredient);
}