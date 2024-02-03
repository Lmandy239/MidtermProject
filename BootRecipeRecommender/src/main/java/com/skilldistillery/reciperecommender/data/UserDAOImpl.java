package com.skilldistillery.reciperecommender.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User authenticateUser(String username, String password) {
		String query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
		User u = em.createQuery(query, User.class).setParameter("username", username).setParameter("password", password)
				.getSingleResult();
		return u;
	}

	@Override
	public User registerUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("user");
		// user.setEnabled(true);
		em.persist(user);
		return user;
	}

	@Override
	public Ingredient selectIngredient(String name) {
		String query = "SELECT i FROM Ingredient i WHERE i.name = :name";
		Ingredient ingredient = em.createQuery(query, Ingredient.class).setParameter("name", name).getSingleResult();
		return ingredient;
	}

//	@Override
//	public Ingredient selectIngredient(String name) {
//		Ingredient ingredient = em.find(Ingredient.class, name);
//		return ingredient;
//	}

//	@Override
//	public List<Ingredient> displayCart() {
//		String jpql = "SELECT i FROM Ingredient i JOIN User u WHERE u.user_id = i.ingredient_id";
//		List<Ingredient> ingredients = em.createQuery(jpql, Ingredient.class).getResultList();
//		return ingredients;
//	}
}
