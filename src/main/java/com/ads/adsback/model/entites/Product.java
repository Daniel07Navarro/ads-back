package com.ads.adsback.model.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProduct;

    @Column(length = 100)
    private String name;

    @Column(length = 150)
    private String description;

    @Column(columnDefinition = "decimal(6,2)")
    private Double price;
}
