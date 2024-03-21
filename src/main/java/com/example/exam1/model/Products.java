package com.example.exam1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int amount;

    @ManyToOne
    private Category category;

}
