package com.example.therealcookbook.CaloryTable;

import com.example.therealcookbook.Recipes.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caloryTable")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaloryTable {
    @Id
    @GeneratedValue
    private Integer id;
    private String category;
    private String name;
    private String amount = "100 egység";   // ??!
    private Double energy;
    private Double protein;
    private Double fat;
    private Double carbohydrate;
    private Double gi;
    private boolean vegan;
    private boolean vegetarian;
    private boolean lactose;
    private boolean glucose;
}

