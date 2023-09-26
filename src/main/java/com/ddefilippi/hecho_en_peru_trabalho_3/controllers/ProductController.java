package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;


import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/update")
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }
}