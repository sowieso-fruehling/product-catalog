package de.br.aff.catalogservice.services;

import de.br.aff.catalogservice.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts(String username) {
        return List.of(
                new Product(1L, "Jacket", username + "'s choice", "A1", 123.34d, "blue"),
                new Product(2L, "Shirt", username + "'s choice", "A1", 13.34d, "yellow")
        );
    }
}
