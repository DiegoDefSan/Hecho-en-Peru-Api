package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Category;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories") // http://localhost:8080/categories
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/addCategories")
    public List<Category> addCategories(List<Category> categories) {
        return categoryService.saveCategories(categories);
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
}
