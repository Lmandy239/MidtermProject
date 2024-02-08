package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

public interface IngredientDAO {

	List<Ingredient> findIngredientByName(String namePattern);

	void removeIngredient(User user, Ingredient ingredient);

	void addToPantry(User user, Ingredient ingredient);

	Ingredient findById(int id);

	// test changes
	//
	//
}