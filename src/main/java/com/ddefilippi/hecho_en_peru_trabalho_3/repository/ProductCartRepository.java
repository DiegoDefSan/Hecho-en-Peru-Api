package com.ddefilippi.hecho_en_peru_trabalho_3.repository;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart, String> {
}
