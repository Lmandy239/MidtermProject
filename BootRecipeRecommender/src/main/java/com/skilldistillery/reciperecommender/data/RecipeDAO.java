package com.skilldistillery.reciperecommender.data;

import com.skilldistillery.reciperecommender.entities.Recipe;

public interface RecipeDAO {
	Recipe findById(int id);
}
