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
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientDAOImpl implements IngredientDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> findIngredientByName(User user, String namePattern) {
		String jpql = "SELECT i FROM Ingredient i WHERE LOWER(i.name) LIKE LOWER(:pattern || '%')";

		Query query = em.createQuery(jpql);
		
		List<Ingredient> ingredients;
		
		ingredients = query.setParameter("pattern", namePattern.toLowerCase()).getResultList();

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
	public void addToPantry(User user, Ingredient ingredient) {
		user.addIngredient(ingredient);
	}
}
