package com.example.therealcookbook.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue
    private Long Id;
    private String UserName;
    private String Password;
    private String Email;
    private String Region;
    private Integer Own_Recipes;
    private Integer Fav_Recipes;

    public Users(Long id,
                 String userName,
                 String password,
                 String email,
                 String region,
                 Integer own_Recipes,
                 Integer fav_Recipes) {
        Id = id;
        UserName = userName;
        Password = password;
        Email = email;
        Region = region;
        Own_Recipes = own_Recipes;
        Fav_Recipes = fav_Recipes;
    }

    public Users() {
    }

    public Users(
                String userName,
                String password,
                String email,
                String region,
                Integer own_Recipes,
                Integer fav_Recipes) {
        UserName = userName;
        Password = password;
        Email = email;
        Region = region;
        Own_Recipes = own_Recipes;
        Fav_Recipes = fav_Recipes;
    }
}
