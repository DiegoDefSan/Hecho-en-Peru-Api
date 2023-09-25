package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="handcraft")
public class Handcraft {

    @Id
    @GeneratedValue(generator = "handcraft_generator")
    private String idHandcraft;
    private String name;
    private String history;
}
