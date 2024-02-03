package com.skilldistillery.reciperecommender.data;

import java.util.List;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

public interface UserDAO {

	User authenticateUser(String username, String password);

	User registerUser(String username, String password);

//	Ingredient selectIngredient(User user, String name);

	void removeIngredient(String input);

	List<Ingredient> displayCart(String input);

}