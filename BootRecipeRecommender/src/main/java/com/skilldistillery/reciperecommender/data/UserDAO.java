package com.skilldistillery.reciperecommender.data;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

public interface UserDAO {

	User authenticateUser(String username, String password);

	User registerUser(String username, String password);

	void save(User user);

	User findById(int id);

	void addToCart(User user, Ingredient ingredient, int quantity);

	void removeFromCart(User user, Ingredient ingredient);
}