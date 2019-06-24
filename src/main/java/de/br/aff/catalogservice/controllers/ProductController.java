package de.br.aff.catalogservice.controllers;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/catalog-api")
@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/v1/products")
  public List<Product> getCatalogItems() {
    return productService.getProducts();
  }

}
