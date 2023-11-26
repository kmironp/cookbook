package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import com.example.therealcookbook.Recipes.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public UserService(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        userRepository.deleteByUsername(username);
    }

    public void saveUser(User user)
    {
        Optional<User> u = userRepository.findUserByEmail(user.getEmail());
        if(u.isPresent())
        {
            throw new IllegalStateException("email already exists");
        }
        if(user.getEmail().contains("@") && user.getEmail().contains(".")) {
            userRepository.save(user);
        }
        else
        {
            throw new IllegalStateException("Bad email format.");
        }
    }

    public Optional<User> GetUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public void updateEmail(String username, String newEmail) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        User userWithNewEmail = userRepository.findByEmail(newEmail);

        if (userWithNewEmail != null && !userWithNewEmail.getUsername().equals(username)) {
            throw new IllegalArgumentException("Email " + newEmail + " is already in use");
        }

        user.setEmail(newEmail);
        userRepository.save(user);
    }

    public void updatePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        // Check if the old password matches the stored password
        if (!user.getPassword().equals(oldPassword)) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        // Update the password
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public String getUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        return user.getUsername();
    }

    public String getEmail(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        return user.getEmail();
    }

    public User login(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email);

        // Check if the user exists and the password matches
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null; // Return null if login fails
    }

    public List<Recipe> getAllOwnRecipes(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        return user.getOwnRecipes();
    }

    public void updateOwnRecipe(String username, Integer recipeId, Recipe updatedRecipe) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> ownRecipes = user.getOwnRecipes();

        if (ownRecipes == null || ownRecipes.isEmpty()) {
            throw new IllegalArgumentException("User has no own recipes");
        }

        Optional<Recipe> recipeToUpdate = ownRecipes.stream()
                .filter(recipe -> recipe.getId().equals(recipeId))
                .findFirst();

        if (recipeToUpdate.isPresent()) {
            Recipe existingRecipe = recipeToUpdate.get();

            // Update the fields of the existing recipe with the new values
            existingRecipe.setName(updatedRecipe.getName());
            existingRecipe.setDescription(updatedRecipe.getDescription());
            existingRecipe.setServings(updatedRecipe.getServings());
            existingRecipe.setVegan(updatedRecipe.isVegan());
            existingRecipe.setVegetarian(updatedRecipe.isVegetarian());
            existingRecipe.setLactose(updatedRecipe.isLactose());
            existingRecipe.setGluten(updatedRecipe.isGluten());
            existingRecipe.setIngredientNames(updatedRecipe.getIngredientNames());
            existingRecipe.setIngredientAmounts(updatedRecipe.getIngredientAmounts());
            existingRecipe.setIngredientMeasures(updatedRecipe.getIngredientMeasures());

            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Recipe with ID " + recipeId + " not found in user's own recipes");
        }
    }

    public void deleteOwnRecipe(String username, Integer recipeId) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> ownRecipes = user.getOwnRecipes();

        if (ownRecipes == null) {
            throw new IllegalArgumentException("User does not have any own recipes");
        }

        // Find the recipe with the specified ID
        Optional<Recipe> recipeToDelete = ownRecipes.stream()
                .filter(recipe -> recipe.getId().equals(recipeId))
                .findFirst();

        if (recipeToDelete.isPresent()) {
            ownRecipes.remove(recipeToDelete.get());
        } else {
            throw new IllegalArgumentException("Recipe with ID " + recipeId + " does not exist for the user");
        }

        userRepository.save(user);
    }

    public void uploadOwnRecipe(String username, Recipe newRecipe) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> ownRecipes = user.getOwnRecipes();

        if (ownRecipes == null) {
            ownRecipes = new ArrayList<>();
            user.setOwnRecipes(ownRecipes);
        }

        // Assign the user to the new recipe
        newRecipe.setUser(user);

        ownRecipes.add(newRecipe);

        userRepository.save(user);
    }

    public List<Recipe> getAllFavouriteRecipes(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        return user.getFavouriteRecipes();
    }

    public void removeOneFromMyFavoriteRecipes(String username, Integer recipeId) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> favoriteRecipes = user.getFavouriteRecipes();

        if (favoriteRecipes != null) {
            Recipe recipeToRemove = favoriteRecipes.stream()
                    .filter(recipe -> recipe.getId().equals(recipeId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Recipe with id " + recipeId + " not found in user's favorite recipes"));

            user.removeFromFavoriteRecipes(recipeToRemove);
            userRepository.save(user);
        }
    }

    public void addToMyFavouriteRecipes(String username, Recipe recipe) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> favouriteRecipes = user.getFavouriteRecipes();
        if (favouriteRecipes == null) {
            favouriteRecipes = new ArrayList<>();
            user.setFavouriteRecipes(favouriteRecipes);
        }

        favouriteRecipes.add(recipe);
        userRepository.save(user);
    }

    public List<Recipe> getAllRecipesAllUserAvailable() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipesByName(String name) {
        return recipeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Recipe> getRecipeByIncludeIngredient(String ingredientName) {
        return recipeRepository.findByIngredientNamesContainingIgnoreCase(ingredientName);
    }

    public List<Recipe> getRecipeIfIncludeSpecialDemand() {
        return recipeRepository.findByVeganIsTrueAndVegetarianIsTrueAndLactoseIsTrueAndGlutenIsTrue();
    }

    public List<Recipe> getRecipeIfNotIncludeSpecialDemand() {
        return recipeRepository.findByVeganIsFalseAndVegetarianIsFalseAndLactoseIsFalseAndGlutenIsFalse();
    }

    @Transactional
    public void updateRecipeServings(Integer recipeId, Integer newServings) {
        Recipe recipe = getRecipeById(recipeId);
        recipe.updateServings(newServings);
        recipeRepository.save(recipe);
    }

    @Transactional
    public void updateRecipeIngredientAmounts(Integer recipeId, List<Integer> newIngredientAmounts) {
        Recipe recipe = getRecipeById(recipeId);
        recipe.updateIngredientAmounts(newIngredientAmounts);
        recipeRepository.save(recipe);
    }

    private Recipe getRecipeById(Integer recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Recipe with ID " + recipeId + " not found"));
    }

}
