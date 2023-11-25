package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "api/v1/Users")
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

    @GetMapping("{username}/ownrecipes")
    public List<Recipe> getOwnRecipes(@PathVariable("username") String username) {
        return userService.getOwnRecipes(username);
    }

    @PostMapping("{username}/addownrecipe")
    public ResponseEntity<String> addOwnRecipe(
            @PathVariable("username") String username,
            @RequestBody Recipe recipe) {
        userService.addOwnRecipe(username, recipe);
        return ResponseEntity.ok("Recipe added successfully");
    }

    @PutMapping("{username}/updateownrecipe")
    public ResponseEntity<String> updateOwnRecipe(
            @PathVariable("username") String username,
            @RequestBody Recipe updatedRecipe) {
        userService.updateOwnRecipe(username, updatedRecipe);
        return ResponseEntity.ok("Recipe updated successfully");
    }

    @DeleteMapping("{username}/deleteownrecipe/{recipeId}")
    public ResponseEntity<String> deleteOwnRecipe(
            @PathVariable("username") String username,
            @PathVariable("recipeId") Integer recipeId) {
        userService.deleteOwnRecipe(username, recipeId);
        return ResponseEntity.ok("Recipe deleted successfully");
    }

    @GetMapping("{username}/favouriterecipes")
    public ResponseEntity<List<Recipe>> getFavouriteRecipes(@PathVariable("username") String username) {
        List<Recipe> favouriteRecipes = userService.getFavouriteRecipes(username);
        return ResponseEntity.ok(favouriteRecipes);
    }

    @PostMapping("{username}/addtofavouriterecipes/{recipeId}")
    public ResponseEntity<String> addToMyFavouriteRecipes(
            @PathVariable("username") String username,
            @PathVariable("recipeId") Integer recipeId) {
        userService.addToMyFavouriteRecipes(username, recipeId);
        return ResponseEntity.ok("Recipe added to favorite recipes successfully");
    }

    @DeleteMapping("{username}/removefromfavourites/{recipeId}")
    public ResponseEntity<String> removeFromFavouriteRecipes(
            @PathVariable("username") String username,
            @PathVariable("recipeId") Integer recipeId) {
        userService.removeFromFavouriteRecipes(username, recipeId);
        return ResponseEntity.ok("Recipe removed from favorites successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.login(email, password);

        if (user != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

}
