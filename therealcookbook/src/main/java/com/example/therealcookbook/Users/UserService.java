package com.example.therealcookbook.Users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id)
    {
        return userRepository.findById(id);
    }


    public void deleteUser(User user)
    {
        userRepository.delete(user);
    }

    public  void saveUser(User user)
    {
        userRepository.save(user);
    }

    /*public User GetUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }*/
}
