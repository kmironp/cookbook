package com.example.therealcookbook.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.therealcookbook.Users.UserService;

import java.util.List;

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

    /*@GetMapping("useremail")
    public User getUserByEmail(String email)
    {
        return userService.GetUserByEmail(email);
    }*/

}
