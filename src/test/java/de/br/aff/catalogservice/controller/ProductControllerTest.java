package de.br.aff.catalogservice.controller;

import static de.br.aff.catalogservice.testutils.Constants.DEFAULT_PAGINATION_SIZE;
import static de.br.aff.catalogservice.testutils.Constants.DETAULT_PRODUCT_TITLE;
import static de.br.aff.catalogservice.testutils.Constants.GET_PRODUCTS_PATH;
import static de.br.aff.catalogservice.testutils.Constants.INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY;
import static de.br.aff.catalogservice.testutils.Constants.STARTING_PRICE_OFFSET;
import static de.br.aff.catalogservice.testutils.Constants.TOKEN_VALID_UNTIL_2119;
import static de.br.aff.catalogservice.testutils.TestUtils.getResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.repository.ProductRepository;
import java.util.stream.IntStream;
import org.hamcrest.Matchers;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

  private static boolean dbInitialized = false;
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ProductRepository productRepository;


  @Before
  public void initDb() {
    if (!dbInitialized) {
      IntStream.range(0, INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY).forEach(i ->
          productRepository.save(
              new Product(DETAULT_PRODUCT_TITLE + " " + i,
                  "Description " + i, "Brand " + i,
                  STARTING_PRICE_OFFSET + i,
                  "Color " + i))
      );

      dbInitialized = true;

    }
  }

  @Test
  public void thatEndpointIsUnavailableWithoutJwtToken() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .get(GET_PRODUCTS_PATH)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void thatEndpointIsUnavailableWithoutValidJwtToken() throws Exception {

    String invalidToken = "Bearer 111111111111111.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6MTU2MjE3NDcxMCwiaWF0IjoxNTYxMzEwNzEwfQ.0ictAa4m41JBdUQ3bx0divbv_UzfRzjjopbfY9fFhgcBX2gUmbSZwlWMjRBhP030mUm7FmbmP5PNPD-1nBUm8Q";

    mockMvc.perform(MockMvcRequestBuilders
        .get(GET_PRODUCTS_PATH)
        .header(HttpHeaders.AUTHORIZATION, invalidToken)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void thatEndpointIsUnavailableWithExpiredJwtToken() throws Exception {

    String expiredToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6MTU2MTMxNzgyMywiaWF0IjoxNTYxMzE3NzYzfQ.5YcklS-z9rPWA0Lsf6VX8D6TazeZvVCp249QLKwuEU0iqq_j78GnV3MQ0z18fGztXnQ5Fi2EKUXD-37MJIcc5w";

    mockMvc.perform(MockMvcRequestBuilders
        .get(GET_PRODUCTS_PATH)
        .header(HttpHeaders.AUTHORIZATION, expiredToken)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void thatDefaultPaginationWorks() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
        .get(GET_PRODUCTS_PATH)
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(DEFAULT_PAGINATION_SIZE)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].title",
            Matchers.everyItem(Matchers.startsWith(DETAULT_PRODUCT_TITLE))));
  }

  @Test
  public void thatCustomPaginationWorks() throws Exception {
    getResultActions(mockMvc, GET_PRODUCTS_PATH, "page=1")
        .andExpect(jsonPath("$", Matchers.hasSize(20)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand",
            Matchers.equalTo("Brand " + 20)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[19].brand",
            Matchers.equalTo("Brand " + 39)));
  }

  @Test
  public void thatSpecifyingNumberOfElementsPerPageWorks() throws Exception {
    int numberOfRecordsOnPage = 5;

    getResultActions(mockMvc, GET_PRODUCTS_PATH, "size=" + numberOfRecordsOnPage)
        .andExpect(jsonPath("$", Matchers.hasSize(numberOfRecordsOnPage)));
  }

  @Test
  public void thatDescSortingByPriceWorks() throws Exception {
    getResultActions(mockMvc, GET_PRODUCTS_PATH, "sort=price,desc")
        .andExpect(jsonPath("$", Matchers.hasSize(20)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].price",
            Matchers
                .equalTo(STARTING_PRICE_OFFSET + INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY - 1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[19].price",
            Matchers
                .equalTo(STARTING_PRICE_OFFSET + INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY - 20)));
  }

  @Test
  public void thatDescSortingByColorWorks() throws Exception {
    getResultActions(mockMvc, GET_PRODUCTS_PATH, "sort=color,desc")
        .andExpect(jsonPath("$", Matchers.hasSize(20)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].color",
            Matchers.equalTo("Color " + (INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY - 1))))
        .andExpect(MockMvcResultMatchers.jsonPath("$[19].color",
            Matchers.equalTo("Color " + (INITIAL_NUMBER_OF_PRODUCTS_IN_REPOSITIORY - 19))));
  }

  @Test
  public void thatAscSortingByBrandWithCustomPaginationWorks() throws Exception {
    getResultActions(mockMvc, GET_PRODUCTS_PATH, "page=1&sort=brand,asc")
        .andExpect(jsonPath("$", Matchers.hasSize(20)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand",
            Matchers.equalTo("Brand " + 27)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[19].brand",
            Matchers.equalTo("Brand " + 44)));
  }

  @Test
  public void thatGettingProductsByTitleWorks() throws Exception {

    String titleSearchCriteria = "Jacket 1";

    getResultActions(mockMvc, GET_PRODUCTS_PATH, "title=" + titleSearchCriteria)
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].title",
            Matchers.everyItem(Matchers.startsWith(titleSearchCriteria))));
  }

  @Test
  public void thatGettingProductsByDescriptionWorks() throws Exception {

    String descriptionSearchCriteria = "Description 1";

    getResultActions(mockMvc, GET_PRODUCTS_PATH,
        "description=" + descriptionSearchCriteria)
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].description",
            Matchers.everyItem(Matchers.startsWith(descriptionSearchCriteria))));
  }

  @Test
  public void thatGettingProductsByTitleAndDescriptionWorks() throws Exception {

    String titleSearchCriteria = "Jacket 1";
    String descriptionSearchCriteria = "Description 1";

    getResultActions(mockMvc, GET_PRODUCTS_PATH,
        "title=" + titleSearchCriteria + "&description="
            + descriptionSearchCriteria)
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].title",
            Matchers.everyItem(Matchers.startsWith(titleSearchCriteria))))
        .andExpect(MockMvcResultMatchers.jsonPath("$[*].description",
            Matchers.everyItem(Matchers.startsWith(descriptionSearchCriteria))));
  }
}