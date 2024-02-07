package com.skilldistillery.reciperecommender.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.Recipe;

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

}
