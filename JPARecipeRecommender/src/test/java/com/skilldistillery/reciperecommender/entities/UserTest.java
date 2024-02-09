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

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void test_User_has_username() {
		assertNotNull(user);
		assertNotNull(user.getUsername());
		assertEquals("admin", user.getUsername());
	}

	@Test
	public void test_User_Has_Recipe() {
		assertNotNull(user);
		assertNotNull(user.getFavoriteRecipes());
	}

	@Test
	public void test_User_Has_Ingredients() {
		assertNotNull(user);
		assertNotNull(user.getIngredientsInPantry());
	}

	@Test
	public void test_User_Has_Comments() {
		assertNotNull(user);
		assertNotNull(user.getComments());
	}
}
