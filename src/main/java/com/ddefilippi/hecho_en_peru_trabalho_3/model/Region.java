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
            name = "region_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "REG"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.util.IdGenerator"
    )
    private String idRegion;
    private String name;

    @OneToMany(mappedBy = "region")
    private List<Product> products = new ArrayList<>();

    public Region(String name) {
        this.name = name;
    }
}
