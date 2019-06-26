package de.br.aff.catalogservice.controller;

import static de.br.aff.catalogservice.testutils.Constants.PRODUCTS_PATH;
import static de.br.aff.catalogservice.testutils.Constants.TOKEN_VALID_UNTIL_2119;
import static de.br.aff.catalogservice.testutils.TestUtils.addOneProductIntoEmptyDb;
import static de.br.aff.catalogservice.testutils.TestUtils.toJson;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.repository.ProductRepository;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTestWithEmptyRepository {

  private static boolean cleanDb = true;

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ProductRepository productRepository;

  @Before
  public void initDb() {
    if (cleanDb) {
      productRepository.deleteAll();
      cleanDb = false;
    }
  }

  @Test
  public void thatFetchingNonExistingProductReturnsNonFound() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .get("/catalog-api/v1/product/1")
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }


  @Test
  public void thatPartialUpdatingNonExistingProductReturnsNonFound() throws Exception {

    Product newProductValues = new Product("t1", "d1", "b1", 11.1d, "c1");

    mockMvc.perform(MockMvcRequestBuilders
        .patch("/catalog-api/v1/product/1")
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .content(toJson(newProductValues))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  public void thatDeletingNonExistingProductReturnsNonFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
        .delete("/catalog-api/v1/product/1")
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  public void thatDeletingWorks() throws Exception {

    Product existingProduct = addOneProductIntoEmptyDb(productRepository);

    mockMvc.perform(MockMvcRequestBuilders
        .delete("/catalog-api/v1/product/" + existingProduct.getId())
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Assert.assertEquals(productRepository.findAll().size(), 0);
  }

  @Test
  public void thatCreatingProductWorks() throws Exception {

    Product productToCreate = new Product("t1", "d1", "b1", 11.1d, "c1");

    mockMvc.perform(MockMvcRequestBuilders
        .post("/catalog-api/v1/product")
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .content(toJson(productToCreate))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(header().exists(HttpHeaders.LOCATION));

    Assert.assertEquals(productRepository.findAll().size(), 1);

    cleanDb = true;
  }

  @Test
  public void thatOverwritingProductWorks() throws Exception {

    Product existingProduct = addOneProductIntoEmptyDb(productRepository);

    Product newProductValue = new Product("t1", "d1", "b1", 11.1d, "c1");

    mockMvc.perform(MockMvcRequestBuilders
        .put("/catalog-api/v1/product/" + existingProduct.getId())
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .content(toJson(newProductValue))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Assert.assertEquals(productRepository.findById(existingProduct.getId()).get(), newProductValue);

    cleanDb = true;
  }

  @Test
  public void thatPutRequestWillCreateNewProductIfItsRepresentationDoesntExist() throws Exception {

    Product newProductValue = new Product("t1", "d1", "b1", 11.1, "c1");

    mockMvc.perform(MockMvcRequestBuilders
        .put("/catalog-api/v1/product/1")
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .content(toJson(newProductValue))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(header().exists(HttpHeaders.LOCATION));

    Assert.assertEquals(productRepository.findAll().size(), 1);

    cleanDb = true;
  }

  @Test
  public void thatPartialUpdatingProductWorks() throws Exception {

    Product newProductValue = new Product(null, "d1", "b1", 11.1, null);

    Product existingProduct = addOneProductIntoEmptyDb(productRepository);

    mockMvc.perform(MockMvcRequestBuilders
        .patch("/catalog-api/v1/product/" + existingProduct.getId())
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .content(toJson(newProductValue))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Product partiallyUpdatedProduct = productRepository.findById(existingProduct.getId()).get();

    Assert.assertEquals(partiallyUpdatedProduct.getTitle(), existingProduct.getTitle());
    Assert.assertEquals(partiallyUpdatedProduct.getDescription(), newProductValue.getDescription());
    Assert.assertEquals(partiallyUpdatedProduct.getBrand(), newProductValue.getBrand());
    Assert.assertEquals(partiallyUpdatedProduct.getPrice(), newProductValue.getPrice());
    Assert.assertEquals(partiallyUpdatedProduct.getColor(), existingProduct.getColor());

    cleanDb = true;
  }

  @Test
  public void thatBatchCreateWorks() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .post(PRODUCTS_PATH)
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .content(toJson(List.of(
            new Product("t1", "d1", "b1", 11.1, "c1"),
            new Product("t2", "d2", "b2", 11.2, "c2"),
            new Product("t3", "d3", "b3", 11.3, "c3"))))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

    Assert.assertEquals(productRepository.findAll().size(), 3);

    cleanDb = true;
  }
}