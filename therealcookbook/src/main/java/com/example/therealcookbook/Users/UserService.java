package com.example.therealcookbook.Users;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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


    public void deleteUser(Integer id)
    {
        boolean ex = userRepository.existsById(id);
        if(!ex)
        {
            throw new IllegalStateException("No such user");
        }
        userRepository.deleteById(id);
    }

    public  void saveUser(User user, String pwagain)
    {
        Optional<User> u = userRepository.findUserByEmail(user.getEmail());
        if(u.isPresent())
        {
            throw new IllegalStateException("email already exists");
        }
        if(user.getEmail().contains("@") && user.getEmail().contains(".")) {

            if(user.getPassword().equals(pwagain))
            {
                userRepository.save(user);
            }
            else
            {
                throw new IllegalStateException("The 2 passwords don't match.");

            }

        }
        else
        {
            throw new IllegalStateException("Bad email format.");
        }
    }

    public Optional<User> GetUserByEmail(String email)
    {

        return userRepository.findUserByEmail(email);
    }


    @Transactional
    public void updateUser(Integer id, String username, String email) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No such user!"));

        if(username != null && !username.isEmpty() && !Objects.equals(u.getUsername(),username))
        {
            u.setUsername(username);
        }
        if(email != null && !email.isEmpty() && !Objects.equals(u.getEmail(),email))
        {
            Optional<User> optionalUser = userRepository.findUserByEmail(email);
            if(optionalUser.isPresent())
            {
                throw new IllegalStateException("Email already in use");
            }
            u.setEmail(email);
        }
    }
}
