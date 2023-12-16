package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products_carts")
public class ProductCart {
    @Id
    @GeneratedValue(generator = "product_cart_generator")
    @GenericGenerator(
            name = "product_cart_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "PC"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.util.IdGenerator"
    )
    private String idProductCart;
    private int quantity;
}
