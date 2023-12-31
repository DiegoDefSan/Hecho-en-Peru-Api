package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"productCarts"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(generator = "cart_generator")
    @GenericGenerator(
            name = "cart_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "CART"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.util.IdGenerator"
    )
    private String idCart;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<ProductCart> productCarts = new ArrayList<>();
}
