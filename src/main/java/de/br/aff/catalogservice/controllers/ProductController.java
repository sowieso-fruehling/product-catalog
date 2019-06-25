package de.br.aff.catalogservice.controllers;

import static org.springframework.http.HttpStatus.CREATED;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/catalog-api")
@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/v1/products")
  public List<Product> getProducts(@RequestParam(required = false) String title,
      @RequestParam(required = false) String description, Pageable pageable) {
    return productService.getProducts(title, description, pageable);
  }

  @PostMapping("/v1/products")
  public ResponseEntity createProducts(@RequestBody List<Product> products) {
    List<Product> createdProducts = productService.createProducts(products);
    return ResponseEntity.status(CREATED).body(createdProducts);
  }
}
