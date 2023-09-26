package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.exception.HighlightedEntityException;
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

        // If all categories have id = null, save all
        boolean isAllCategoryWithIdNull = categories.stream()
                .allMatch(category -> category.getIdCategory() == null);


        if (isAllCategoryWithIdNull) {
            return categoryRepository.saveAll(categories);
        }

        // If any category has id != null, throw exception
        throw new HighlightedEntityException("Trying to save a highlighted object");
    }
}
