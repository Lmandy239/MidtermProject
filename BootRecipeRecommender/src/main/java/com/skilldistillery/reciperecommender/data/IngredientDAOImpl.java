package com.skilldistillery.reciperecommender.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IngredientDAOImpl implements IngredientDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Ingredient findIngredientByName(User user, String namePattern) {
		String jpql = "SELECT i FROM Ingredient i WHERE i.name LIKE :pattern";
		Query query = em.createQuery(jpql);
		Ingredient ingredient = (Ingredient) query.setParameter("pattern", "%" + namePattern + "%").getSingleResult();
		user.addIngredient(ingredient);
		return ingredient;
	}

	@Override
	public void removeIngredient(User user, Ingredient ingredient) {
		if (user.getIngredients().contains(ingredient)) {
			user.removeIngredient(ingredient);
		}

	}
}