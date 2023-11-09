package com.example.therealcookbook.Ingredients;

import com.example.therealcookbook.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private final UserRepository userRepository;

    @Autowired
    public IngredientService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
