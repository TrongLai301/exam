package com.example.exam1.service.impl;

import com.example.exam1.repository.CategoryRepository;
import com.example.exam1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;
}
