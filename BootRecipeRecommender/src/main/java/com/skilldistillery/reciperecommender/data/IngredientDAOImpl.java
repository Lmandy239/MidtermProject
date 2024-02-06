package com.skilldistillery.reciperecommender.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		List<Ingredient> ingredients = (List<Ingredient>) query.setParameter("pattern", "%" + namePattern + "%").getResultList();

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
	public List<Recipe> generateRecipes(User user, List<Ingredient> ingredients) {
		return null;
//		ingredients = user.getIngredients();
//		int index = 0;
//		int count = 0;
//		Recipe [] topSixRecipes = new Recipe[6];
//		for (Ingredient ingredient : ingredients) {
//			for (Recipe recipe: recipes) {
//				if (recipe.contains(ingredient)) {
//					count++;
//					topSixRecipes[index] = recipe;
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
