package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Ingredient;

public interface IngredientDAO {

	List<Ingredient> findIngredientsByName(String namePattern);

}