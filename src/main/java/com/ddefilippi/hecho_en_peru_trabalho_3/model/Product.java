package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"productCarts"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(generator = "product_generator")
    @GenericGenerator(
            name = "product_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "PROD"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.util.IdGenerator"
    )
    private String idProduct;
    private String name;
    private double price;
    private int stock;
    private String imagePath;
    private double rating;
    private String history;
    private String details;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "idRegion")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "idHandcraft")
    private Handcraft handcraft;

    @OneToMany(mappedBy = "product")
    private List<ProductCart> productCarts = new ArrayList<>();

    public Product(String name, double price, int stock, String imagePath, double rating, String history, String details, Category category, Region region, Handcraft handcraft) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.imagePath = imagePath;
        this.rating = rating;
        this.history = history;
        this.details = details;
        this.category = category;
        this.region = region;
        this.handcraft = handcraft;
    }
}
