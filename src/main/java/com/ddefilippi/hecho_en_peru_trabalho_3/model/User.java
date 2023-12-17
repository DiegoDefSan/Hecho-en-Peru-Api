package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(value = {"carts"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(generator = "user_generator")
    @GenericGenerator(
            name = "user_generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "USER"),
            strategy = "com.ddefilippi.hecho_en_peru_trabalho_3.util.IdGenerator"
    )
    private String idUser;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}
