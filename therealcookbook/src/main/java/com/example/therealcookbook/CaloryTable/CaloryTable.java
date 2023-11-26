package com.example.therealcookbook.CaloryTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Double energy;
    private Double protein;
    private Double fat;
    private Double carbohydrate;
    private Double gi;
}

