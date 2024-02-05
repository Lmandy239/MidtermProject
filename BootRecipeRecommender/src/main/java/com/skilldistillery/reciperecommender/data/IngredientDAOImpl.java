package com.skilldistillery.reciperecommender.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
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
		System.out.println("**********************entering method***************************");
		String jpql = "SELECT i FROM Ingredient i WHERE i.name LIKE :pattern";
		
		Query query = em.createQuery(jpql);
		
		List<Ingredient> ingredients = (List<Ingredient>) query.setParameter("pattern", "%" + namePattern + "%").getResultList();
	
		for (Ingredient ingredient : ingredients) {
			user.addIngredient(ingredient);
		}
		return ingredients;
	}

	@Override
	public void removeIngredient(User user, Ingredient ingredient) {
		if (user.getIngredients().contains(ingredient)) {
			user.removeIngredient(ingredient);
		}
	}
}