package de.br.aff.catalogservice.controllers;

import static de.br.aff.catalogservice.utils.Utils.getResourceLocation;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.services.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PostMapping("/v1/product")
  public ResponseEntity createProduct(@RequestBody Product product) {
    Product createdProduct = productService.createProduct(product);
    return ResponseEntity.status(CREATED)
        .header(HttpHeaders.LOCATION, getResourceLocation(createdProduct)).build();
  }

  @PostMapping("/v1/products")
  public ResponseEntity createProducts(@RequestBody List<Product> products) {
    List<Product> createdProducts = productService.createProducts(products);
    return ResponseEntity.status(CREATED).body(createdProducts);
  }

  @PutMapping("/v1/product/{id}")
  public ResponseEntity overwriteOrCreateProduct(@PathVariable Long id,
      @RequestBody Product productSent) {
    Optional<Product> productFetched = productService.getProductById(id);

    if (!productFetched.isPresent()) {
      return createProduct(productSent);
    }

    Product existingProduct = productFetched.get();

    if (existingProduct.equals(productSent)) {
      return ResponseEntity.status(NO_CONTENT).build();
    }

    productSent.setId(existingProduct.getId());
    Product updatedProduct = productService.updateProduct(productSent);
    return ResponseEntity.status(OK).body(updatedProduct);
  }

  @PatchMapping("/v1/product/{id}")
  public ResponseEntity updateProduct(@PathVariable Long id,
      @RequestBody Product newValues) {
    Optional<Product> productFetched = productService.getProductById(id);

    if (!productFetched.isPresent()) {
      return ResponseEntity.status(NOT_FOUND).build();
    }

    Product existingProduct = productFetched.get();

    if (existingProduct.equals(newValues)) {
      return ResponseEntity.status(NO_CONTENT).build();
    }

    productService.patchProductObject(existingProduct, newValues);

    productService.updateProduct(existingProduct);
    return ResponseEntity.status(NO_CONTENT).build();
  }

  @DeleteMapping("/v1/product/{id}")
  public ResponseEntity updateProduct(@PathVariable Long id) {
    Optional<Product> productFetched = productService.getProductById(id);

    if (!productFetched.isPresent()) {
      return ResponseEntity.status(NOT_FOUND).build();
    }

    productService.delete(id);

    return ResponseEntity.status(NO_CONTENT).build();
  }

  @GetMapping("/v1/product/{id}")
  public ResponseEntity getProduct(@PathVariable Long id) {
    Optional<Product> productFetched = productService.getProductById(id);

    if (!productFetched.isPresent()) {
      return ResponseEntity.status(NOT_FOUND).build();
    }

    return ResponseEntity.status(OK).body(productFetched.get());
  }
}
