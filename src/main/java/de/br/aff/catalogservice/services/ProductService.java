package de.br.aff.catalogservice.services;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> getProducts(String title, String description, Pageable pageable) {

    if (title != null && description != null) {
      return productRepository.findByTitleAndDescription(title, description, pageable);
    }

    if (title != null) {
      return productRepository.findByTitle(title, pageable);
    }

    if (description != null) {
      return productRepository.findByDescription(description, pageable);
    }

    Slice<Product> productPage = productRepository.findAll(pageable);
    return productPage.getContent();
  }

  public List<Product> createProducts(List<Product> products) {
    return productRepository.saveAll(products);
  }
}
