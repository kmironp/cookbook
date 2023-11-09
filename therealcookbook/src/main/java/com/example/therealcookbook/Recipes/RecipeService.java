package com.example.therealcookbook.Recipes;

import com.example.therealcookbook.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final UserRepository userRepository;

    @Autowired
    public RecipeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
