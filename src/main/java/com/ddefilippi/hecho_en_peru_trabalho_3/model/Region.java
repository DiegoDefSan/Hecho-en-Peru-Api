package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"products"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="region")
public class Region {

    @Id
    @GeneratedValue(generator = "region_generator")
    @GenericGenerator(
            name = "product_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "REG"),
            strategy = "com.ddefilippi.hecho_en_peru.id_generator.IdGenerator"
    )
    private String idRegion;
    private String name;
    private String history;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
