package com.example.therealcookbook.User;

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

    public List<Users> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long id)
    {
        return userRepository.findById(id);
    }
    
    public void addUser(Users user) {
        System.out.println(user);
    }

    public void deleteUser(Users user)
    {
        userRepository.delete(user);
    }

    public  void saveUser(Users user)
    {
        userRepository.save(user);
    }
}
