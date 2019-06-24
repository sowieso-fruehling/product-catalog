package de.br.aff.catalogservice.repository;

import de.br.aff.catalogservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}