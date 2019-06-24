package de.br.aff.catalogservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;
  private String description;
  private String brand;
  private double price;
  private String color;

  public Product(String title, String description, String brand, double price, String color) {
    this.title = title;
    this.description = description;
    this.brand = brand;
    this.price = price;
    this.color = color;
  }
}
