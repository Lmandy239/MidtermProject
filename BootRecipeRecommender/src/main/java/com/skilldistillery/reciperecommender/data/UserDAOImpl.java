package com.skilldistillery.reciperecommender.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.reciperecommender.entities.Ingredient;
import com.skilldistillery.reciperecommender.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		user.setEnabled(true);
		em.persist(user);
		return user;
	}

//	@Override
//	public Ingredient selectIngredient(User user, String name) {
//		String query = "SELECT i FROM Ingredient i WHERE i.name = :name";
//		Ingredient ingredient = em.createQuery(query, Ingredient.class).setParameter("name", name).getSingleResult();
//		user.addIngredient(ingredient);
//		return ingredient;
//	}
//
//	@Override
//	public void removeIngredient(String input) {
//		List <Ingredient> ingredients = displayCart(input);
//		user.removeIngredient(ingredient);
//	}

	@Override
	public List<Ingredient> displayCart(String input) {
		// user.getIngredients();
		String jpql = "SELECT i FROM Ingredient i WHERE i.name LIKE :pattern";
		Query query = em.createQuery(jpql);
		query.setParameter("pattern", "%" + input + "%");
		return query.getResultList();
	}

	@Override
	public void removeIngredient(String input) {
		// TODO Auto-generated method stub
		
	}

}

//		List<Ingredient> ingredients = em.createQuery(jpql, Ingredient.class)
//				.getResultList();