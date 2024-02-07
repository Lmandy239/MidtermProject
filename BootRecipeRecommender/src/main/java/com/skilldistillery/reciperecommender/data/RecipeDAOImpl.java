package com.skilldistillery.reciperecommender.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecipeDAOImpl implements RecipeDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Recipe findById(int id) {
		return em.find(Recipe.class, id);
	}
	
	@Override
	public List<Recipe> allRecipe() {
		String jpql = "SELECT r FROM Recipe r";
		List<Recipe> allRecipe = em.createQuery(jpql, Recipe.class).getResultList();
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
	

}
