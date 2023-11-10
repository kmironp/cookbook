package com.example.therealcookbook.Users;

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
    @PostMapping
    public  void  registerNewUser(@RequestBody User user)
    {
        userService.saveUser(user);
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
        userService.updateUser(id,name,email);
    }

}
