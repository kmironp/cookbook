package com.example.therealcookbook.Ingredients;

import com.example.therealcookbook.Recipes.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private Integer id;
    private String category;
    private String name;
    private Integer amount;
    private String measure;
    private boolean vegan;
    private boolean vegetarian;
    private boolean lactose;
    private boolean gluten;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}

