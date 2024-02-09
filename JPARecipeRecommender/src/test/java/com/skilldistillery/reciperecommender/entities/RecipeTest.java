
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
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		recipe = em.find(Recipe.class, 5);
	}

	@AfterEach
	void tearDown() throws Exception {
		recipe = null;
		em.close();
	}

	@Test
	public void test_Recipe_By_Id() {
		assertNotNull(recipe);
		assertEquals("Miso-Butter Roast Chicken With Acorn Squash Panzanella", recipe.getName());
	}

	@Test
	public void test_Recipe_Has_User() {
		assertNotNull(recipe);
		assertEquals("admin", recipe.getUser().getUsername());
	}

	@Test
	public void test_Recipe_Has_Ingredient() {
		assertNotNull(recipe);
		assertNotNull(recipe.getIngredients());
		assertTrue(recipe.getIngredients().size() > 0);
	}
}