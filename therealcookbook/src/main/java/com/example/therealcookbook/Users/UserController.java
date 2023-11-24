package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.therealcookbook.Users.UserService;

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

    @PostMapping("save")
    public  void  registerNewUser(@RequestBody User user, @RequestBody String pwagain)
    {
        userService.saveUser(user,pwagain);
    }

    @GetMapping("useremail")
    public Optional<User> getUserByEmail(String email)
    {
        return userService.GetUserByEmail(email);
    }

    @DeleteMapping(path = "{id}")
    public void DeleteUser(@PathVariable("id") Integer id)
    {
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Integer id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email)
    {
        userService.updateEmail(id,name,email);
    }
    @PutMapping(path = "{id}/updatepw")
    public void updatePw(@PathVariable("id") Integer id,
                           @RequestParam(required = true) String email,
                           @RequestParam(required = true) String oldPw,
                         @RequestParam(required = true) String pw,
                         @RequestParam(required = true) String tempPw)
    {
        userService.updatePw(id,email,oldPw,pw,tempPw);
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
