package com.ddefilippi.hecho_en_peru_trabalho_3.util;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;

import java.util.List;

public record PagedProducts(
        long totalProducts,
        int totalPages,
        int currentPage,
        List<Product> products) {
}
