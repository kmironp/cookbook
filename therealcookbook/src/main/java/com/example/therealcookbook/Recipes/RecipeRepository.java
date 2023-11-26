package com.example.therealcookbook.Recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByNameContainingIgnoreCase(String name);

    List<Recipe> findByIngredientNamesContainingIgnoreCase(String ingredientName);

    List<Recipe> findByVeganIsTrueAndVegetarianIsTrueAndLactoseIsTrueAndGlutenIsTrue();

    List<Recipe> findByVeganIsFalseAndVegetarianIsFalseAndLactoseIsFalseAndGlutenIsFalse();
}
