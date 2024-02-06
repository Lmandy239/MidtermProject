package com.skilldistillery.reciperecommender.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientDAOImpl implements IngredientDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Ingredient> findIngredientByName(User user, String namePattern) {
		String jpql = "SELECT i FROM Ingredient i WHERE i.name LIKE :pattern";

		Query query = em.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<Ingredient> ingredients = (List<Ingredient>) query.setParameter("pattern", "%" + namePattern + "%")
				.getResultList();

		for (Ingredient ingredient : ingredients) {
			user.searchIngredient(ingredient);
		}
		return ingredients;
	}

	@Override
	public Ingredient findById(int id) {
		return em.find(Ingredient.class, id);
	}

	@Override
	public void removeIngredient(User user, Ingredient ingredient) {
		if (user.getIngredients() != null && user.getIngredients().contains(ingredient)) {
			user.removeIngredient(ingredient);
		}
	}

	@Override
	public List<Recipe> generateRecipes(User user, List<Ingredient> ingredients, Ingredient ingredient) {
		List<Recipe> top6Recipes = new ArrayList<>();

		// Constructing JPQL query to fetch recipes containing all provided ingredients
		String jpql = "SELECT r FROM Recipe r WHERE ";
		for (int i = 0; i < ingredients.size(); i++) {
			jpql += ":ingredient" + i + " MEMBER OF r.ingredients ";
			if (i < ingredients.size() - 1) {
				jpql += " AND ";
			}
		}

		// Creating query object and setting parameters
		TypedQuery<Recipe> query = em.createQuery(jpql, Recipe.class);
		for (int i = 0; i < ingredients.size(); i++) {
			query.setParameter("ingredient" + i, ingredients.get(i));
		}

		// Executing query and retrieving results
		List<Recipe> recipes = query.getResultList();

		// Adding unique recipes to top6Recipes list
		for (Recipe recipe : recipes) {
			if (!top6Recipes.contains(recipe) && top6Recipes.size() < 6) {
				top6Recipes.add(recipe);
			}
		}

		return top6Recipes;
	}

	@Override
	public void addToPantry(User user, Ingredient ingredient) {
		user.addIngredient(ingredient);
	}

	@Override
	public List<Recipe> findAll() {

		String jpql = "SELECT r FROM Recipe r";
		List<Recipe> recipes = em.createQuery(jpql, Recipe.class).getResultList();

		return recipes;
	}

	@Override
	public List<Recipe> findRecipesByIngredients(String name) {
		String jpql = "SELECT r FROM Recipe JOIN r.ingredients WHERE i.name IN :ingredientNames";
		List<Recipe> recipes = em.createQuery(jpql, Recipe.class).getResultList();

		return recipes;

	}

}
