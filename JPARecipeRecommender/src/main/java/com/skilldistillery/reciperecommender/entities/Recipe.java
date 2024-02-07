package com.skilldistillery.reciperecommender.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class Recipe {

	public Recipe() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToMany
	@JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;

	@Column(name = "recipe_image")
	private String image;

	private String description;

	@Column(name = "ingredient_description")
	private String ingredientDescription;

	@Transient
	private List<String> ingredientDescriptionList;

	@ManyToMany(mappedBy = "favoriteRecipes", fetch = FetchType.EAGER)
	private List<User> userFavoriteRecipes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredientDescription() {
		return ingredientDescription;
	}

	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}

	public List<String> getIngredientDescriptionList() {
		return ingredientDescriptionList;
	}

	public void setIngredientDescriptionList(List<String> ingredientDescriptionList) {
		this.ingredientDescriptionList = ingredientDescriptionList;
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
		Recipe other = (Recipe) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + "description=" + description + "]";
	}

	public List<User> getUserFavoriteRecipes() {
		return userFavoriteRecipes;
	}

	public void setUserFavoriteRecipes(List<User> userFavoriteRecipes) {
		this.userFavoriteRecipes = userFavoriteRecipes;
	}

}
