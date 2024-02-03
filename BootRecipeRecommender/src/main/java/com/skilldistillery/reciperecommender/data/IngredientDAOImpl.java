package com.skilldistillery.reciperecommender.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;

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
	public List<Ingredient> findIngredientsByName(String namePattern) {
		String jpql = "SELECT i FROM Ingredient i WHERE i.name LIKE :pattern";
		Query query = em.createQuery(jpql);
		query.setParameter("pattern", "%" + namePattern + "%");
		return query.getResultList();

	}

}