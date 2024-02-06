
package com.skilldistillery.reciperecommender.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ingredient {

    public Ingredient() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Ingredient(int id, String name, List<User> users) {
        super();
        this.id = id;
        this.name = name;
        this.users = users;
    }

    @ManyToMany(mappedBy = "ingredientsInPantry")
    private List<User> users;

    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;

    public void addUser(User user) {
        if (user == null) {
            users = new ArrayList<>();
        }
        if (!users.contains(user)) {
            user.addIngredient(this);
        }
    }

    public void removeUser(User user) {
        if (users != null && users.contains(user)) {
            users.remove(user);
            user.removeIngredient(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

    @Override
    public String toString() {
        return "Ingredient [id=" + id + ", name=" + name + ", users=" + users + "]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		return id == other.id;
	}

}