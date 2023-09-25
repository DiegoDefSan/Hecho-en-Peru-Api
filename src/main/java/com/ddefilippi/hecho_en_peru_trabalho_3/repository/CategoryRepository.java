package com.ddefilippi.hecho_en_peru_trabalho_3.repository;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
