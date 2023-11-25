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

    public  void saveUser(User user)
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

    public List<Recipe> getOwnRecipes(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        return user.getOwnRecipes();
    }

    public void addOwnRecipe(String username, Recipe recipe) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        // Set the user for the recipe
        recipe.setUser(user);

        // Add the recipe to the user's own recipes
        if (user.getOwnRecipes() == null) {
            user.setOwnRecipes(new ArrayList<>());
        }
        user.getOwnRecipes().add(recipe);

        userRepository.save(user);
    }

    public void updateOwnRecipe(String username, Recipe updatedRecipe) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> ownRecipes = user.getOwnRecipes();

        if (ownRecipes == null || ownRecipes.isEmpty()) {
            throw new IllegalArgumentException("User with username " + username + " has no own recipes");
        }

        // Find the recipe to update
        Recipe existingRecipe = ownRecipes.stream()
                .filter(recipe -> recipe.getId().equals(updatedRecipe.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Recipe with id " + updatedRecipe.getId() + " not found"));

        // Update the existing recipe with new details
        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        existingRecipe.setServings(updatedRecipe.getServings());
        existingRecipe.setVegan(updatedRecipe.isVegan());
        existingRecipe.setVegetarian(updatedRecipe.isVegetarian());
        existingRecipe.setLactose(updatedRecipe.isLactose());
        existingRecipe.setGluten(updatedRecipe.isGluten());

        userRepository.save(user);
    }

    public void deleteOwnRecipe(String username, Integer recipeId) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> ownRecipes = user.getOwnRecipes();

        if (ownRecipes == null || ownRecipes.isEmpty()) {
            throw new IllegalArgumentException("User with username " + username + " has no own recipes");
        }

        // Find the index of the recipe to delete
        int recipeIndex = -1;
        for (int i = 0; i < ownRecipes.size(); i++) {
            if (ownRecipes.get(i).getId().equals(recipeId)) {
                recipeIndex = i;
                break;
            }
        }

        if (recipeIndex == -1) {
            throw new IllegalArgumentException("Recipe with id " + recipeId + " not found for user " + username);
        }

        // Remove the recipe from the user's own recipes
        ownRecipes.remove(recipeIndex);

        userRepository.save(user);
    }

    public List<Recipe> getFavouriteRecipes(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        return user.getFavouriteRecipes();
    }

    public void addToMyFavouriteRecipes(String username, Integer recipeId) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        Optional<Recipe> recipeToAdd = findRecipeById(recipeId);

        if (recipeToAdd.isEmpty()) {
            throw new IllegalArgumentException("Recipe with id " + recipeId + " does not exist");
        }

        List<Recipe> favouriteRecipes = user.getFavouriteRecipes();

        if (favouriteRecipes == null) {
            favouriteRecipes = new ArrayList<>();
            user.setFavouriteRecipes(favouriteRecipes);
        }

        // Check if the recipe is already in the user's favorite recipes
        if (favouriteRecipes.contains(recipeToAdd.get())) {
            throw new IllegalArgumentException("Recipe is already in the user's favorite recipes");
        }

        boolean added = favouriteRecipes.add(recipeToAdd.get());

        if (added) {
            userRepository.save(user);
        }
    }

    protected Optional<Recipe> findRecipeById(Integer recipeId) {
        return recipeRepository.findById(recipeId);
    }

    public void removeFromFavouriteRecipes(String username, Integer recipeId) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        List<Recipe> favouriteRecipes = user.getFavouriteRecipes();

        if (favouriteRecipes == null || favouriteRecipes.isEmpty()) {
            throw new IllegalArgumentException("User with username " + username + " has no favorite recipes");
        }

        // Find the index of the recipe to remove
        int recipeIndex = -1;
        for (int i = 0; i < favouriteRecipes.size(); i++) {
            if (favouriteRecipes.get(i).getId().equals(recipeId)) {
                recipeIndex = i;
                break;
            }
        }

        if (recipeIndex == -1) {
            throw new IllegalArgumentException("Recipe with id " + recipeId + " not found in favorite recipes for user " + username);
        }

        // Remove the recipe from the user's favorite recipes
        favouriteRecipes.remove(recipeIndex);

        userRepository.save(user);
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

}
