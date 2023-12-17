package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;


import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import com.ddefilippi.hecho_en_peru_trabalho_3.model.ProductCart;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/product_cart") // http://localhost:8080/product_cart
public class ProductCartController {
    @Autowired
    private ProductCartService productCartService;

    @GetMapping
    public List<ProductCart> getProductCarts() {
        return productCartService.getProductCarts();
    }

    @PostMapping("/addProductCart")
    public ProductCart addProductCart(@RequestBody ProductCart productCart) {
        return productCartService.saveProductCart(productCart);
    }

    @PostMapping("/addProductsCarts")
    public List<ProductCart> addProductsCarts(@RequestBody List<ProductCart> productsCarts) {
        return productCartService.saveProductsCarts(productsCarts);
    }
}
