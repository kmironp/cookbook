package com.example.therealcookbook.Recipes;

import com.example.therealcookbook.Users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "recipes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue
    @NonNull
    private Integer id;
    private String name;
    private String description;
    private Integer servings;
    private boolean vegan;
    private boolean vegetarian;
    private boolean lactose;
    private boolean gluten;

    @ElementCollection
    private List<String> ingredientNames;

    @ElementCollection
    private List<Integer> ingredientAmounts;

    @ElementCollection
    private List<String> ingredientMeasures;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    @PreUpdate
    private void prepareData() {
        this.name = this.name.toLowerCase();
        this.description = this.description.toLowerCase();

        if (this.ingredientNames != null) {
            this.ingredientNames = this.ingredientNames.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        }

        if (this.ingredientMeasures != null) {
            this.ingredientMeasures = this.ingredientMeasures.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        }
    }

    public void updateServings(Integer newServings) {
        this.servings = newServings;
        // Update ingredient amounts accordingly based on the new servings
        updateIngredientAmounts(newServings);
    }

    private void updateIngredientAmounts(Integer newServings) {
        // Calculate new ingredient amounts based on the ratio of new servings to original servings
        // Update ingredient amounts accordingly
    }

    public void updateIngredientAmounts(List<Integer> newIngredientAmounts) {
        // Update ingredient amounts with the provided list
        this.ingredientAmounts = newIngredientAmounts;
    }



}
