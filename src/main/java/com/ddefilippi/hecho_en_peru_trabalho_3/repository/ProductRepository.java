package com.ddefilippi.hecho_en_peru_trabalho_3.repository;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

