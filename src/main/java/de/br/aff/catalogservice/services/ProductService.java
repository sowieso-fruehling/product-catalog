package de.br.aff.catalogservice.services;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> getProducts() {
    return productRepository.findAll();
  }
}
