package com.skilldistillery.reciperecommender.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Comment;
import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.RecipeImpression;
import com.skilldistillery.reciperecommender.entities.User;
import com.skilldistillery.reciperecommender.entities.UserIngredient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeDAOImpl implements RecipeDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Recipe findById(int id) {
		Recipe recipe = em.find(Recipe.class, id);
		List<String> ingredientDescriptionList = parseIngredientDescription(recipe.getIngredientDescription());
		recipe.setIngredientDescriptionList(ingredientDescriptionList);
		return recipe;
	}

	@Override
	public List<Recipe> allRecipe() {
		String jpql = "SELECT r FROM Recipe r";
		List<Recipe> allRecipe = em.createQuery(jpql, Recipe.class).getResultList();
		for (Recipe recipe : allRecipe) {
			List<String> ingredientDescriptionList = parseIngredientDescription(recipe.getIngredientDescription());
			recipe.setIngredientDescriptionList(ingredientDescriptionList);
		}
		return allRecipe;
	}

	@Override
	public List<Recipe> generateRecipes(User user) {
		List<Recipe> allRecipes = allRecipe();
		List<Recipe> topRecipes = new ArrayList<>();
		List<Ingredient> ingredients = user.getIngredients();

		// Calculate the intersection sizes and store them in a separate list
		List<Integer> intersectionSizes = new ArrayList<>();

		for (Recipe recipe : allRecipes) {
			int intersectionSize = calculateIntersectionSize(recipe.getIngredients(), user.getIngredientsInPantry());
			intersectionSizes.add(intersectionSize);
		}

		for (int i = 0; i < Math.min(6, allRecipes.size()); i++) {
			int maxIntersectionSize = Collections.max(intersectionSizes);
			int maxIndex = intersectionSizes.indexOf(maxIntersectionSize);
			if (maxIntersectionSize < 1) {
				return topRecipes;
			}

			topRecipes.add(allRecipes.get(maxIndex));

			intersectionSizes.set(maxIndex, -1); // Mark this index as visited

			// You don't need to remove the elements or the recipes from the list
		}

		return topRecipes;
	}

	private int calculateIntersectionSize(List<Ingredient> list1, List<Ingredient> list2) {
		List<Ingredient> smallerList = (list1.size() < list2.size()) ? list1 : list2;
		List<Ingredient> largerList = (list1.size() < list2.size()) ? list2 : list1;

		int count = 0;
		for (Ingredient ingredient : smallerList) {
			if (largerList.contains(ingredient)) {
				count++;
			}
		}
		return count;
	}

	private List<String> parseIngredientDescription(String ingredientDescription) {
		System.out.println(ingredientDescription);
		List<String> ingredients = new ArrayList<>();
		// Parse the string representation of the array and create a list
		String pattern = "(?<=')\\s*,\\s*";
	    String[] ingredientsArray = ingredientDescription.split(pattern);
	    for (String ingredient : ingredientsArray) {
	    	System.out.println(ingredient);
	        // Remove leading and trailing whitespace, and single quotes if any
	    	ingredient = ingredient.trim().replaceAll("^'|^\\['|'\\]$|'$", "");
	        ingredients.add(ingredient);
	    }
		return ingredients;
	}

	@Override
	@Transactional
	public RecipeImpression mapThisRecipeToUser(User user, Recipe recipe) {
		RecipeImpression recipeImpression = new RecipeImpression();
		recipeImpression.setUser(user);
		recipeImpression.setRecipe(recipe);
		if (em.contains(recipeImpression)) {
			em.persist(recipeImpression);
		} else {
			em.merge(recipeImpression);
		}
		return recipeImpression;
	}

	@Override
	@Transactional
	public void unmapThisRecipeToUser(User user, Recipe recipe) {
		RecipeImpression recipeImpression = em
				.createQuery("SELECT ri FROM RecipeImpression ri WHERE ri.user = :user AND ri.recipe = :recipe",
						RecipeImpression.class)
				.setParameter("user", user).setParameter("recipe", recipe).getSingleResult();

		em.remove(recipeImpression);
	}

	@Override
	public Recipe favoriteThisRecipe(User user, Recipe recipe) {
		user.addRecipe(recipe);
		return recipe;
	}

	@Override
	public void unfavoriteThisRecipe(User user, Recipe recipe) {
		user.removeRecipe(recipe);
	}

	@Override
	public Recipe create(Recipe recipe) {
		em.persist(recipe);
		List<String> ingredientDescriptionList = parseIngredientDescription(recipe.getIngredientDescription());
		recipe.setIngredientDescriptionList(ingredientDescriptionList);
		return recipe;
	}

	// COMMENT METHODS
	@Override
	public List<Comment> findCommentsByRecipeId(int recipeId) {
		String jpql = "SELECT c FROM Comment c WHERE c.recipe.id = :recipeId";
		Query query = em.createQuery(jpql);
		query.setParameter("recipeId", recipeId);
		return query.getResultList();
	}

	@Override
	public void addCommentToRecipe(int recipeId, Comment comment) {
		Recipe recipe = findById(recipeId);
		comment.setRecipe(recipe);
		comment.setCreatedAt(LocalDateTime.now());
		em.persist(comment);
	}
}
