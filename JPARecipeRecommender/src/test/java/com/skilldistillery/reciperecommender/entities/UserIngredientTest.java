
package com.skilldistillery.reciperecommender.entities;

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

public class UserIngredientTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private UserIngredient userIngredient;
	private User user;
	private Ingredient ingredient;

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
		user = em.find(User.class, 1);
		ingredient = em.find(Ingredient.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	public void test_User_Ingredient() {
		userIngredient = new UserIngredient(user, ingredient);
		assertNotNull(userIngredient);
		assertTrue(userIngredient.getUser().getId() == 1);
		assertTrue(userIngredient.getIngredient().getId() == 1);
	}
}