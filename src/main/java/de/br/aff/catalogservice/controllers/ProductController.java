package de.br.aff.catalogservice.controllers;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/catalog-api")
@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/v1/products")
  public List<Product> getCatalogItems(@RequestParam(required = false) String title,
      @RequestParam(required = false) String description, Pageable pageable) {

    if (title != null && description != null) {
      return productService.getProductsByTitleAndDescription(title, description, pageable);
    }

    if (title != null) {
      return productService.getProductsByTitle(title, pageable);
    }

    if (description != null) {
      return productService.getProductsByDescription(description, pageable);
    }

    return productService.getProducts(pageable);

  }
}
