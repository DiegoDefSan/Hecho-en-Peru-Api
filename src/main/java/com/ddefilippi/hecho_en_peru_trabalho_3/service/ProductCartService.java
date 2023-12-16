package com.ddefilippi.hecho_en_peru_trabalho_3.service;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.ProductCart;
import com.ddefilippi.hecho_en_peru_trabalho_3.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCartService {
    @Autowired
    private ProductCartRepository productCartRepository;

    public List<ProductCart> getProductCarts() {
        return productCartRepository.findAll();
    }

    public ProductCart saveProductCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }
}
