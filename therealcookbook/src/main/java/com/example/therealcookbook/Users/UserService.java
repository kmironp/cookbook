package com.example.therealcookbook.Users;


import com.example.therealcookbook.Recipes.Recipe;
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

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        userRepository.deleteByUsername(username);
    }

    public  void saveUser(User user)
    {
        Optional<User> u = userRepository.findUserByEmail(user.getEmail());
        if(u.isPresent())
        {
            throw new IllegalStateException("email already exists");
        }
        if(user.getEmail().contains("@") && user.getEmail().contains(".")) {
            userRepository.save(user);
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
    public void updateEmail(String username, String newEmail) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        User userWithNewEmail = userRepository.findByEmail(newEmail);

        if (userWithNewEmail != null && !userWithNewEmail.getUsername().equals(username)) {
            throw new IllegalArgumentException("Email " + newEmail + " is already in use");
        }

        user.setEmail(newEmail);
        userRepository.save(user);
    }

    public void updatePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with username " + username + " does not exist");
        }

        // Check if the old password matches the stored password
        if (!user.getPassword().equals(oldPassword)) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        // Update the password
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public String getUsername(Integer id)
    {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent())
        {
            User us = u.get();
            return us.getUsername();
        }
        throw new IllegalStateException("User doesn't exist!");
    }
    public String getEmail(Integer id)
    {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent())
        {
            User us = u.get();
            return us.getEmail();
        }
        throw new IllegalStateException("User doesn't exist!");
    }
    public List<Recipe> getOwnRec(Integer id)
    {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent())
        {
            User us = u.get();
            return us.getOwnRecipes();
        }
        throw new IllegalStateException("User doesn't exist!");
    }

    public List<Recipe> getFavRec(Integer id)
    {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent())
        {
            User us = u.get();
            return us.getFavouriteRecipes();
        }
        throw new IllegalStateException("User doesn't exist!");
    }

    public void login (String email, String pw)
    {
        Optional<User> u = userRepository.findUserByEmail(email);
        if(u.isPresent())
        {
            User us = u.get();
            if(us.getPassword().equals(pw))
            {
                //DOSTUFF pl: return "nyitólap.html"
            }
            else
            {
                throw new IllegalStateException("Wrong Credentials!");
            }
        }
        else
        {
            throw new IllegalStateException("Wrong Credentials!");
        }
    }
}
