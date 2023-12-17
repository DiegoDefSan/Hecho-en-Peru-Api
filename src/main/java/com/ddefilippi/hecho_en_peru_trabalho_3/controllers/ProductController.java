package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;


import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.ProductService;
import com.ddefilippi.hecho_en_peru_trabalho_3.util.PagedProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
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
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/category/{idCategory}")
    public List<Product> getProductsByCategoryId(@PathVariable String idCategory) {
        return productService.getProductsByCategoryId(idCategory);
    }

    @GetMapping("/handcraft/{idHandcraft}")
    public List<Product> getProductsByHandicraftId(@PathVariable String idHandcraft) {
        return productService.getProductsByHandcraftId(idHandcraft);
    }

    @GetMapping("/region/{idRegion}")
    public List<Product> getProductsByRegionId(@PathVariable String idRegion) {
        return productService.getProductsByRegionId(idRegion);
    }

    // http://localhost:8080/products/price_range?min_price=50&max_price=200
    @GetMapping("/price_range")
    public List<Product> getProductsByPriceRange(
            @RequestParam(name="min_price", defaultValue = "50") Double minPrice,
            @RequestParam(name="max_price", defaultValue = "200") Double maxPrice
    ) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/order_by_price/asc")
    public List<Product> getProductsOrderByPriceAsc() {
        return productService.getProductsOrderByPriceAsc();
    }

    @GetMapping("/order_by_price/desc")
    public List<Product> getProductsOrderByPriceDesc() {
        return productService.getProductsOrderByPriceDesc();
    }

    @GetMapping("/category/{idCategory}/region/{idRegion}")
    public List<Product> getProductsByCategoryIdAndRegionId(@PathVariable String idCategory, @PathVariable String idRegion) {
        return productService.getProductsByCategoryIdAndRegionId(idCategory, idRegion);
    }

    @GetMapping("/paged")
    public PagedProducts getPagedProducts(
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.getProductsByPage(pageable);
        return new PagedProducts(
                products.getTotalElements(),
                products.getTotalPages(),
                products.getNumber(),
                products.getContent()
        );
    }
}
