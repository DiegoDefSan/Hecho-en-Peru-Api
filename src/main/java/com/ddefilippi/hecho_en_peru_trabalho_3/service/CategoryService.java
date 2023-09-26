package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Category;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // List categories
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> saveCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
