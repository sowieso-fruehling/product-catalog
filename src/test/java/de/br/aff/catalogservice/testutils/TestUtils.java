package de.br.aff.catalogservice.testutils;

import static de.br.aff.catalogservice.testutils.Constants.TOKEN_VALID_UNTIL_2119;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public final class TestUtils {

  public static ResultActions getResultActions(MockMvc mockMvc, String path, String requestParameters)
      throws Exception {
    return mockMvc.perform(MockMvcRequestBuilders
        .get(path + "?" + requestParameters)
        .header(HttpHeaders.AUTHORIZATION, TOKEN_VALID_UNTIL_2119)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  public static String toJson(Object object) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(object);
  }
}
