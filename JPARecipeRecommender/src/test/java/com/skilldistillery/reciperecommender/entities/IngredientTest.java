package com.skilldistillery.reciperecommender.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class IngredientTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Ingredient ingredient;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPARecipeRecommender");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		ingredient = em.find(Ingredient.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ingredient = null;
	}

	@Test
	public void test_Ingredient_Has_Name() {
		assertNotNull(ingredient);
		assertNotNull(ingredient.getName());
		assertEquals("test ingredient", ingredient.getName());
	}

	@Test
	public void test_Ingredient_Has_Recipes() {
		assertNotNull(ingredient);
		assertNotNull(ingredient.getRecipes());
		assertTrue(ingredient.getRecipes().size() > 0);
	}

	@Test
	public void test_Ingredient_Has_Users() {
		assertNotNull(ingredient);
		assertNotNull(ingredient.getUsers());
		assertTrue(ingredient.getUsers().size() > 0);
	}
}