package com.example.therealcookbook.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("asd")
    public List<Users> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @PostMapping
    public  void  registerNewUser(@RequestBody Users user)
    {
        userService.addUser(user);
    }

}
