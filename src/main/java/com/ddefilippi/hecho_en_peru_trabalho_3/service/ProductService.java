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
        return productRepository.getAllProducts();
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

    // Get products by category id
    public List<Product> getProductsByCategoryId(String idCategory) {
        return productRepository.getProductsByCategoryId(idCategory);
    }

    // Get products by handcraft id
    public List<Product> getProductsByHandcraftId(String idHandcraft) {
        return productRepository.getProductsByHandcraftId(idHandcraft);
    }

    // Get products by region id
    public List<Product> getProductsByRegionId(String idRegion) {
        return productRepository.getProductsByRegionId(idRegion);
    }

    // Get products which prices are between minPrice and maxPrice
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.getProductsByPriceRange(minPrice, maxPrice);
    }

    // Get products by name
    public List<Product> getProductsByName(String name) {
        return productRepository.getProductsByName(name);
    }

    // Get products order by price asc
    public List<Product> getProductsOrderByPriceAsc() {
        return productRepository.getProductsOrderByPriceAsc();
    }

    // Get products order by price desc
    public List<Product> getProductsOrderByPriceDesc() {
        return productRepository.getProductsOrderByPriceDesc();
    }

    // Get products by category and region ids
    public List<Product> getProductsByCategoryIdAndRegionId(String idCategory, String idRegion) {
        return productRepository.getProductsByCategoryIdAndRegionId(idCategory, idRegion);
    }
}
