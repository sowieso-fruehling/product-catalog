package de.br.aff.catalogservice.services;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.br.aff.catalogservice.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public class ProductServiceUnitTests {

  private final Pageable RANDOM_PAGEABLE = PageRequest.of(0, 2);
  private final String RANDOM_TITLE = "random title";
  private final String RANDOM_DESCRIPTION = "random description";
  private ProductService productService;

  @Mock
  private ProductRepository productRepository;

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
    productService = new ProductService(productRepository);
  }

  @Test
  public void thatGettingProductByTitleWorks() {

    productService.getProducts(RANDOM_TITLE, null, RANDOM_PAGEABLE);

    verify(productRepository, times(1)).findByTitle(RANDOM_TITLE, RANDOM_PAGEABLE);

  }

  @Test
  public void thatGettingProductByDescriptionWorks() {

    productService.getProducts(null, RANDOM_DESCRIPTION, RANDOM_PAGEABLE);

    verify(productRepository, times(1)).findByDescription(RANDOM_DESCRIPTION, RANDOM_PAGEABLE);

  }

  @Test
  public void thatGettingProductByTitleAndDescriptionWorks() {

    productService.getProducts(RANDOM_TITLE, RANDOM_DESCRIPTION, RANDOM_PAGEABLE);

    verify(productRepository, times(1))
        .findByTitleAndDescription(RANDOM_TITLE, RANDOM_DESCRIPTION, RANDOM_PAGEABLE);

  }

  @Test
  public void thatGettingAllProductWorks() {

    productService.getProducts(RANDOM_TITLE, RANDOM_DESCRIPTION, RANDOM_PAGEABLE);

    verify(productRepository, times(1))
        .findByTitleAndDescription(RANDOM_TITLE, RANDOM_DESCRIPTION, RANDOM_PAGEABLE);

  }
}
