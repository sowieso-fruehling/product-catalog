package de.br.aff.catalogservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;
  private String description;
  private String brand;
  private Double price;
  private String color;

  public Product(String title, String description, String brand, Double price, String color) {
    this.title = title;
    this.description = description;
    this.brand = brand;
    this.price = price;
    this.color = color;
  }
}
