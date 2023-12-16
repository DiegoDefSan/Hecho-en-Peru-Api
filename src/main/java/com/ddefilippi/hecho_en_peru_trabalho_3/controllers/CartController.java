package com.ddefilippi.hecho_en_peru_trabalho_3.controllers;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Cart;
import com.ddefilippi.hecho_en_peru_trabalho_3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }

    @PostMapping("/addCart")
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }
}
