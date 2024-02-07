
package com.skilldistillery.reciperecommender.entities;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class CommentTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;

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

	    @Test
	    public void testFindCommentByRecipeAndUser() {
	        int recipeId = 1;
	        int userId = 1;

	        Comment comment = findCommentByRecipeAndUser(recipeId, userId);

	        assertNotNull(comment);
	        assertEquals("This stuff sucks!", comment.getComment());
	    }

	    private Comment findCommentByRecipeAndUser(int recipeId, int userId) {
	    	String jpql = "SELECT c FROM Comment c WHERE c.recipe.id = :recipeId AND c.user.id = :userId";
	    	EntityManager em = emf.createEntityManager();
	    	
	    	
	    	TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
	    	
	    	query.setParameter("recipeId", recipeId);
	    	query.setParameter("userId", userId);
	    	
	    	Comment comment = query.getSingleResult();

	        return comment;
	    }
	}