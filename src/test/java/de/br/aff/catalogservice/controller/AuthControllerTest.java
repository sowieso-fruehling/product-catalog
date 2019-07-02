package de.br.aff.catalogservice.controller;


import static de.br.aff.catalogservice.testutils.TestUtils.toJson;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.br.aff.security.UserAuthCredentials;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void thatUserIsAuthenticatedSuccessfully() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .post("/authenticate")
        .content(toJson(new UserAuthCredentials("username", "password")))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.jwttoken", Matchers.notNullValue()));

  }

  @Test
  public void thatUserAuthenticationFailsWhenWrongPasswordIsSubmitted() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .post("/authenticate")
        .content(toJson(new UserAuthCredentials("username", "incorect_password")))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
  }

  @Test
  public void thatUserAuthenticationFailsWhenNonExistingUsernameIsSubmitted() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .post("/authenticate")
        .content(toJson(new UserAuthCredentials("non_existing_username", "password")))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
  }
}
