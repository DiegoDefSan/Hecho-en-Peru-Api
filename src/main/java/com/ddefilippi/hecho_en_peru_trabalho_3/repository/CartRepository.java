package com.ddefilippi.hecho_en_peru_trabalho_3.repository;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
}
