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
    public void updateEmail(Integer id, String username, String email) {
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

    public void updatePw(Integer id,String email,String oldPw, String pw, String tempPw)
    {
        Optional<User> u = userRepository.findUserByEmail(email);

        if(u.isPresent())
        {
            User us = u.get();
            if(Objects.equals(us.getPassword(), pw))
            {
                throw new IllegalStateException(
                        "New password can't be the same as the old password");
            }
            else if(pw.length() < 8)
            {
                throw new IllegalStateException(
                        "Password must be have least 8 characters!");

            }
            else if(Objects.equals(pw,tempPw) && Objects.equals(oldPw,us.getPassword()))
            {
                us.setPassword(pw);
            }
            else
            {
                throw new IllegalStateException(
                        "The 2 passwords must match!");

            }
        }
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
