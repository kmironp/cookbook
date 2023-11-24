package com.example.therealcookbook.Recipes;

import com.example.therealcookbook.Ingredients.Ingredient;
import com.example.therealcookbook.Users.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "recipes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Integer servings;
    private boolean vegan;
    private boolean vegetarian;
    private boolean lactose;
    private boolean gluten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

}
