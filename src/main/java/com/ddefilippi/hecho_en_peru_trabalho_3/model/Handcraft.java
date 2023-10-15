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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="handcraft")
public class Handcraft {

    @Id
    @GeneratedValue(generator = "handcraft_generator")
    @GenericGenerator(
            name = "handcraft_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HAND"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.util.IdGenerator"
    )
    private String idHandcraft;
    private String name;
    private String history;

    @OneToMany(mappedBy = "handcraft")
    private List<Product> products = new ArrayList<>();

    public Handcraft(String name, String history) {
        this.name = name;
        this.history = history;
    }
}
