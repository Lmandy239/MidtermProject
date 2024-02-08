package com.skilldistillery.reciperecommender.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserIngredient {

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UserIngredient(User user, Ingredient ingredient) {
		super();
		this.user = user;
		this.ingredient = ingredient;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

}