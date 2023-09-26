package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(generator = "product_generator")
    @GenericGenerator(
            name = "product_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "PROD"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.id_generator.IdGenerator"
    )
    private String idProduct;
    private String name;
    private double price;
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
}
