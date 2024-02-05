package com.skilldistillery.reciperecommender.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private boolean enabled;

	private String role;

	public User() {
	}

	@Transient
	List<Ingredient> goShopping;

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

	@ManyToMany
	@JoinTable(name = "user_ingredient", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredientsInPantry;

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

	public User(int id, String username, String password, boolean enabled, String role, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.ingredientsInPantry = ingredients;
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

	@Override
	public int hashCode() {
		return Objects.hash(enabled, id, ingredientsInPantry, password, role, username);
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
		return enabled == other.enabled && id == other.id
				&& Objects.equals(ingredientsInPantry, other.ingredientsInPantry)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Ingredient : [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + ", ingredients=" + "]";
	}
}
