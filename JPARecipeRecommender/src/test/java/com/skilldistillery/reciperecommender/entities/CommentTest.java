
package com.skilldistillery.reciperecommender.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CommentTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Comment comment;
	
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
		comment = em.find(Comment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		comment = null;
		em.close();
	}

	@Test
	public void testFindCommentByRecipeAndUser() {
		assertNotNull(comment);
		assertEquals(5, comment.getRecipe().getId());
	}
}
