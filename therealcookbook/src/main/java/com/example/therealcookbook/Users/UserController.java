package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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

    @GetMapping("{id}/username")
    public String getUsername(@PathVariable("id") Integer id)
    {
        return userService.getUsername(id);
    }
    @GetMapping("{id}/email")
    public String getEmail(@PathVariable("id") Integer id)
    {
        return userService.getEmail(id);
    }
    @GetMapping("{id}/OwnRecipes")
    public List<Recipe> getOwnRec(@PathVariable("id") Integer id)
    {
        return userService.getOwnRec(id);
    }
    @GetMapping("{id}/FavRecipes")
    public List<Recipe> getFavRec(@PathVariable("id") Integer id)
    {
        return userService.getFavRec(id);
    }



}
