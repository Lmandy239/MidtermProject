package com.skilldistillery.reciperecommender.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private boolean enabled;

	private String role;

	@ManyToMany
	@JoinTable(name = "recipe_impression", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<Recipe> favoriteRecipes;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_ingredient", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredientsInPantry;

	@OneToMany(mappedBy = "user")
	private List<Recipe> recipes = new ArrayList<>();

	@Transient
	List<Ingredient> goShopping;
	
	
	 @OneToMany(mappedBy = "user")
	 private List<UserIngredient> cart;

	public User() {
	}
	
	public void searchIngredient(Ingredient ingredient) {
		if (goShopping == null) {
			goShopping = new ArrayList<>();
		}
		if (!goShopping.contains(ingredient)) {
			goShopping.add(ingredient);
		}
	}

	public void displayWhatsInGroceryCart() {
		for (Ingredient ingredient : goShopping) {
			ingredient.getName();
		}
	}

	public List<Ingredient> getGoShopping() {
		return goShopping;
	}

	public void setGoShopping(List<Ingredient> goShopping) {
		this.goShopping = goShopping;
	}

	public List<Ingredient> getIngredientsInPantry() {
		return ingredientsInPantry;
	}

	public void setIngredientsInPantry(List<Ingredient> ingredientsInPantry) {
		this.ingredientsInPantry = ingredientsInPantry;
	}
	
	public void addIngredient(Ingredient ingredient) {
		if (ingredientsInPantry == null) {
			ingredientsInPantry = new ArrayList<>();
		}
		if (!ingredientsInPantry.contains(ingredient)) {
			ingredientsInPantry.add(ingredient);
			ingredient.addUser(this);
		}
	}

	public void removeIngredient(Ingredient ingredient) {
		if (ingredientsInPantry != null && ingredientsInPantry.contains(ingredient)) {
			ingredientsInPantry.remove(ingredient);
			ingredient.removeUser(this);
		}
	}


	public void addRecipe(Recipe recipe) {
		if (favoriteRecipes == null) {
			favoriteRecipes = new ArrayList<>();
		}
		if (!favoriteRecipes.contains(recipe)) {
			favoriteRecipes.add(recipe);
			recipe.addUser(this);
		}
	}

	public void removeRecipe(Recipe recipe) {
		if (favoriteRecipes != null && favoriteRecipes.contains(recipe)) {
			favoriteRecipes.remove(recipe);
			recipe.removeUser(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Ingredient> getIngredients() {
		return ingredientsInPantry;
	}

	public Ingredient showIngredients() {
		if (ingredientsInPantry != null) {
			for (Ingredient ingredient : ingredientsInPantry) {
				return ingredient;
			}
		}
		return null;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredientsInPantry = ingredients;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<Recipe> getFavoriteRecipes() {
		return favoriteRecipes;
	}

	public void setFavoriteRecipes(List<Recipe> favoriteRecipes) {
		this.favoriteRecipes = favoriteRecipes;
	}

	public List<UserIngredient> getCart() {
		return cart;
	}

	public void setCart(List<UserIngredient> cart) {
		this.cart = cart;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Ingredient : [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + "]";
	}
}