package com.ddefilippi.hecho_en_peru_trabalho_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="region")
public class Region {

    @Id
    @GeneratedValue(generator = "region_generator")
    private String idRegion;
    private String name;
    private String history;
}
