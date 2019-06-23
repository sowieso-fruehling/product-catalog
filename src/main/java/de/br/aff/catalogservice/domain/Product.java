package de.br.aff.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private Long productId;
    private String title;
    private String description;
    private String brand;
    private double price;
    private String color;
}
