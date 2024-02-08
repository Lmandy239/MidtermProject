
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

public class RecipeTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Recipe recipe;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPARecipeRecommender");
		em = emf.createEntityManager();
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		em.close();
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		recipe = em.find(Recipe.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		recipe = null;
	}

	@Test
	public void test_Recipe_By_Id() {
		assertNotNull(recipe);
		assertEquals("test recipe name", recipe.getName());
		assertEquals("description 1", recipe.getDescription());
	}

	@Test
	public void test_Recipe_Has_User() {
		assertNotNull(recipe);
		assertNotNull(recipe.getUser());
		assertEquals("admin", recipe.getUser().getUsername());
	}

	@Test
	public void test_Recipe_Has_Ingredient() {
		assertNotNull(recipe);
		assertNotNull(recipe.getIngredients());
		assertTrue(recipe.getIngredients().size() > 0);
	}
}