package de.br.aff.catalogservice;

import static de.br.aff.catalogservice.utils.Constants.DETAULT_PRODUCT_TITLE;
import static de.br.aff.catalogservice.utils.Constants.INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.repository.ProductRepository;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@RequiredArgsConstructor
@EnableSpringDataWebSupport
public class ProductServiceApplication implements InitializingBean {

  private final ProductRepository productRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProductServiceApplication.class, args);
  }

  @Override
  public void afterPropertiesSet() {
    populateDatabase();
  }

  private void populateDatabase() {
    IntStream.range(0, INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY).forEach(i ->
        productRepository.save(
            new Product(DETAULT_PRODUCT_TITLE + " " + i, "Description " + i, "Brand " + i,
                123.34 + i,
                "Colour " + i))
    );
  }
}
