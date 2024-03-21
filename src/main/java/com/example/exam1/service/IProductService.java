package com.example.exam1.service;

import com.example.exam1.model.Products;

import java.util.List;

public interface IProductService {
    List<Products> findAll();

    void save(Products products);



    void delete(int id);

    List<Products> findByPrice(double first, double second);

    List<Products> findTop();

    List<Products> sort();

    List<Products> findByCategory(int id);
}
