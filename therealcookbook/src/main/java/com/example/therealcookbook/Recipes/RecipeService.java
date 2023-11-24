package com.example.therealcookbook.Recipes;

import com.example.therealcookbook.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public  void saveRecipe(Recipe rec)
    {
        recipeRepository.save(rec);
    }

    public void deleteRecipe(Integer id)
    {
        boolean ex = recipeRepository.existsById(id);
        if(!ex)
        {
            throw new IllegalStateException("No such recipe");
        }
        recipeRepository.deleteById(id);
    }

    public Optional<Recipe> getRecipeById(Integer id)
    {
        return recipeRepository.findById(id);
    }

}



