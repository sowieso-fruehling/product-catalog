package de.br.aff.catalogservice.repository;

import de.br.aff.catalogservice.domain.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByDescription(String description, Pageable pageable);

  List<Product> findByTitle(String title, Pageable pageable);

  List<Product> findByTitleAndDescription(String title, String description, Pageable pageable);
}
