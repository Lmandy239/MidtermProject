package com.skilldistillery.reciperecommender.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "recipe_image")
	private String image;

	private String description;

	@Column(name = "created_at")
	private LocalDateTime createDate;

	@Column(name = "ingredient_description")
	private String ingredientDescription;

	@Transient
	private List<String> ingredientDescriptionList;

	@ManyToMany
	@JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "recipe")
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@ManyToMany(mappedBy = "favoriteRecipes")
	private List<User> userFavoriteRecipes;

	public Recipe() {
	}
	
	public Recipe(String name, String description, String ingredientDescription, List<Ingredient> ingredients, User user, String image, LocalDateTime createdAt) {
	    super();
	    this.name = name;
	    this.description = description;
	    this.ingredientDescription = ingredientDescription;
	    this.ingredients = ingredients;
	    this.user = user;
	    this.image = image;
	    this.createDate = createdAt; // Set to null in your Java code
	}
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addUser(User user) {
		if (userFavoriteRecipes == null) {
			userFavoriteRecipes = new ArrayList<>();
		}
		if (!userFavoriteRecipes.contains(user)) {
			userFavoriteRecipes.add(user);
			user.addRecipe(this);
		}
	}

	public void removeUser(User user) {
		if (userFavoriteRecipes != null && userFavoriteRecipes.contains(user)) {
			userFavoriteRecipes.remove(user);
			user.removeRecipe(this);
		}
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
		return "Recipe Name=" + name + "\n Recipe Description=" + description + "\nimage";
	}

	public List<User> getUserFavoriteRecipes() {
		return userFavoriteRecipes;
	}

	public void setUserFavoriteRecipes(List<User> userFavoriteRecipes) {
		this.userFavoriteRecipes = userFavoriteRecipes;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}