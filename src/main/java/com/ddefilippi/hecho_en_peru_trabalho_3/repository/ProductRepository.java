package com.ddefilippi.hecho_en_peru_trabalho_3.repository;

import com.ddefilippi.hecho_en_peru_trabalho_3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    // Get all products
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "ORDER BY p.idProduct")
    List<Product> getAllProducts();

    // Get products by category id
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "WHERE p.category.idCategory = :idCategory " +
            "ORDER BY p.idProduct")
    List<Product> getProductsByCategoryId(String idCategory);

    // Get products by handcraft id
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "WHERE p.handcraft.idHandcraft = :idHandcraft " +
            "ORDER BY p.idProduct")
    List<Product> getProductsByHandcraftId(String idHandcraft);

    // Get products by region id
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "WHERE p.region.idRegion = :idRegion " +
            "ORDER BY p.idProduct")
    List<Product> getProductsByRegionId(String idRegion);

    // Get products which prices are between minPrice and maxPrice (inclusive)
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "WHERE p.price >= :minPrice AND p.price <= :maxPrice " +
            "ORDER BY p.idProduct")
    List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);

    // Get products by name
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "WHERE p.name LIKE %:name% " +
            "ORDER BY p.idProduct")
    List<Product> getProductsByName(String name);

    // Get products order by price asc
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "ORDER BY p.price ASC")
    List<Product> getProductsOrderByPriceAsc();

    // Get products order by price desc
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "ORDER BY p.price DESC")
    List<Product> getProductsOrderByPriceDesc();

    // Get products by category and region ids
    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT OUTER JOIN FETCH p.category " +
            "LEFT OUTER JOIN FETCH p.handcraft " +
            "LEFT OUTER JOIN FETCH p.region " +
            "WHERE p.category.idCategory = :idCategory AND p.region.idRegion = :idRegion " +
            "ORDER BY p.idProduct")
    List<Product> getProductsByCategoryIdAndRegionId(String idCategory, String idRegion);
}

