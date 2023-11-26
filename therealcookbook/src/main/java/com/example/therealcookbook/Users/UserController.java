package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Users")

@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("alluserslist")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("userregister")
    public void registerNewUser(@RequestBody User user)
    {
        userService.saveUser(user);
    }

    @GetMapping("useremail")
    public Optional<User> getUserByEmail(String email)
    {
        return userService.GetUserByEmail(email);
    }

    @DeleteMapping(path = "deluser")
    public void deleteUser(@RequestParam("username") String username) {
        userService.deleteUser(username);
    }

    @PutMapping(path = "updateemail")
    public void updateEmail(
            @RequestParam("username") String username,
            @RequestParam("newEmail") String newEmail) {
        userService.updateEmail(username, newEmail);
    }

    @PutMapping(path = "{id}/updatepw")
    public void updatePassword(
            @RequestParam("username") String username,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        userService.updatePassword(username, oldPassword, newPassword);
    }

    @GetMapping("{username}/getusername")
    public String getUsername(@PathVariable("username") String username) {
        return userService.getUsername(username);
    }

    @GetMapping("{username}/getemail")
    public String getEmail(@PathVariable("username") String username) {
        return userService.getEmail(username);
    }

    @PostMapping("/login")
    public User login( String email, String password) {

        return userService.login(email, password);
    }

    @GetMapping("{username}/getownrecipes")
    public List<Recipe> getAllOwnRecipes(@PathVariable("username") String username) {
        return userService.getAllOwnRecipes(username);
    }

    @PutMapping("{username}/updateownrecipes/{recipeId}")
    public void updateOwnRecipe(
            @PathVariable("username") String username,
            @PathVariable("recipeId") Integer recipeId,
            @RequestBody Recipe updatedRecipe) {
        userService.updateOwnRecipe(username, recipeId, updatedRecipe);
    }

    @DeleteMapping("{username}/deleteownrecipe/{recipeId}")
    public void deleteOwnRecipe(
            @PathVariable("username") String username,
            @PathVariable("recipeId") Integer recipeId) {
        userService.deleteOwnRecipe(username, recipeId);
    }

    @PostMapping("{username}/uploadownrecipes")
    public void uploadOwnRecipe(
            @PathVariable("username") String username,
            @RequestBody Recipe newRecipe) {
        userService.uploadOwnRecipe(username, newRecipe);
    }

    @GetMapping("{username}/getfavouriterecipes")
    public List<Recipe> getAllFavouriteRecipes(@PathVariable("username") String username) {
        return userService.getAllFavouriteRecipes(username);
    }

    @DeleteMapping("{username}/removefromfavorites/{recipeId}")
    public void removeOneFromMyFavoriteRecipes(
            @PathVariable("username") String username,
            @PathVariable("recipeId") Integer recipeId) {
        userService.removeOneFromMyFavoriteRecipes(username, recipeId);
    }

    @PostMapping("{username}/addtofavourites")
    public void addToMyFavouriteRecipes(
            @PathVariable("username") String username,
            @RequestBody Recipe recipe) {
        userService.addToMyFavouriteRecipes(username, recipe);
    }

    @GetMapping("/getallrecipes")
    public List<Recipe> getAllRecipesAllUserAvailable() {
        return userService.getAllRecipesAllUserAvailable();
    }

    @GetMapping("/recipesbyname")
    public List<Recipe> getRecipesByName(@RequestParam("name") String name) {
        return userService.getRecipesByName(name);
    }

    @GetMapping("/recipesbyincludeingredient")
    public List<Recipe> getRecipeByIncludeIngredient(@RequestParam("ingredient") String ingredientName) {
        return userService.getRecipeByIncludeIngredient(ingredientName);
    }

    @GetMapping("/recipesbyspecialdemand")
    public List<Recipe> getRecipeIfIncludeSpecialDemand() {
        return userService.getRecipeIfIncludeSpecialDemand();
    }

    @GetMapping("/recipeswithoutspecialdemand")
    public List<Recipe> getRecipeIfNotIncludeSpecialDemand() {
        return userService.getRecipeIfNotIncludeSpecialDemand();
    }

    @PutMapping("/updateRecipeServings/{recipeId}")
    public ResponseEntity<String> updateRecipeServings(
            @PathVariable Integer recipeId,
            @RequestParam Integer newServings) {
        userService.updateRecipeServings(recipeId, newServings);
        return ResponseEntity.ok("Recipe servings updated successfully");
    }

    @PutMapping("/updateRecipeIngredientAmounts/{recipeId}")
    public ResponseEntity<String> updateRecipeIngredientAmounts(
            @PathVariable Integer recipeId,
            @RequestBody List<Integer> newIngredientAmounts) {
        userService.updateRecipeIngredientAmounts(recipeId, newIngredientAmounts);
        return ResponseEntity.ok("Recipe ingredient amounts updated successfully");
    }

}
