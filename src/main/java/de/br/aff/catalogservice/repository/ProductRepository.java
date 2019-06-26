package de.br.aff.catalogservice.repository;

import de.br.aff.catalogservice.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findByDescription(String description, Pageable pageable);

  Page<Product> findByTitle(String title, Pageable pageable);

  Page<Product> findByTitleAndDescription(String title, String description, Pageable pageable);
}
