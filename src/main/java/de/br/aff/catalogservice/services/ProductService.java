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

  public List<Product> getProducts(Pageable pageable) {
    Slice<Product> productPage = productRepository.findAll(pageable);
    return productPage.getContent();
  }

  public List<Product> getProductsByTitleAndDescription(String title, String description,
      Pageable pageable) {
    return productRepository.findByTitleAndDescription(title, description, pageable);

  }

  public List<Product> getProductsByTitle(String title, Pageable pageable) {
    return productRepository.findByTitle(title, pageable);

  }

  public List<Product> getProductsByDescription(String description, Pageable pageable) {
    return productRepository.findByDescription(description, pageable);

  }
}
