package com.example.exam1.service.impl;

import com.example.exam1.model.Products;
import com.example.exam1.repository.ProductRepository;
import com.example.exam1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Products> findAll(){
        return productRepository.findAll();
    }
    @Override
    public void save(Products products){
        productRepository.save(products);
    }

    @Override
    public void delete(int id){
        productRepository.deleteById(id);
    }
@Override
    public List<Products> findByPrice(double first, double second){
        return productRepository.findByPriceBetween(first,second);
    }

    @Override
    public List<Products> findTop(){
        return productRepository.findTop3New();
    }
    @Override
    public List<Products> sort(){
        return productRepository.sort();
    }
    @Override
    public List<Products> findByCategory(int id){
        return productRepository.findByIdCategory(id);
    }


}
