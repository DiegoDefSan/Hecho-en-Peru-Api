package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.exception.EntityNotFoundException;
import com.ddefilippi.hecho_en_peru_trabalho_3.exception.HighlightedEntityException;
import com.ddefilippi.hecho_en_peru_trabalho_3.exception.TransientEntityException;
import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        if (product.getIdProduct() == null) {
            return productRepository.save(product);
        }

        throw new HighlightedEntityException("Trying to save a highlighted object");
    }

    public List<Product> saveProducts(List<Product> products) {

        // If all products have id = null, save all
        boolean isAllProductWithIdNull = products.stream()
                .allMatch(product -> product.getIdProduct() == null);

        if (isAllProductWithIdNull) {
            return productRepository.saveAll(products);
        }

        // If any product has id != null, throw exception
        throw new HighlightedEntityException("Trying to save a highlighted object");
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Product " + id + " not found")
                );
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public String deleteProduct(String id) {
        Product existingProduct = productRepository.findById(id)
                .orElse(null);

        if (existingProduct == null) {
            throw new EntityNotFoundException("Product " + id + " not found");
        }

        productRepository.deleteById(id);
        return "Product " + id + " removed";
    }

    @Transactional
    public Product updateProduct(Product product) {
        if (product.getIdProduct() == null) {
            throw new TransientEntityException("Trying to update a transient object");
        }

        productRepository.findById(product.getIdProduct())
                .orElseThrow(
                        () -> new EntityNotFoundException("Product " + product.getIdProduct() + " not found")
                );

        return productRepository.save(product);
    }
}
