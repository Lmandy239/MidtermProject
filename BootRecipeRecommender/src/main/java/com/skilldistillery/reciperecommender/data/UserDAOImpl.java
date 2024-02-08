package com.skilldistillery.reciperecommender.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;
import com.skilldistillery.reciperecommender.entities.UserIngredient;

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

	// find by id
	@Override
	public User findById(int id) {
		User u = em.find(User.class, id);

		u.getIngredientsInPantry().size();

		return u;
	}

	@Override
	public User registerUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("user");
		user.setEnabled(true);
		em.persist(user);
		return user;
	}

	@Override
	@Transactional
	public void save(User user) {
		if (em.contains(user)) {
			em.persist(user);
		} else {
			em.merge(user);
		}
	}

	@Override
	public void addToCart(User user, Ingredient ingredient, int quantity) {

		UserIngredient userIngredient = new UserIngredient();
		userIngredient.setUser(user);
		userIngredient.setIngredient(ingredient);

		em.persist(userIngredient);

	}

	@Override
	public void removeFromCart(User user, Ingredient ingredient) {
		UserIngredient userIngredient = em
				.createQuery("SELECT ui FROM UserIngredient ui WHERE ui.user = :user AND ui.ingredient = :ingredient",
						UserIngredient.class)
				.setParameter("user", user).setParameter("ingredient", ingredient).getSingleResult();

		em.remove(userIngredient);

	}

	// test cahnges
}