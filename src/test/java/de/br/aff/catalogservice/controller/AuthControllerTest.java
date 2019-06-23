package de.br.aff.catalogservice.controller;


import de.br.aff.catalogservice.security.UserCredentials;
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

import static de.br.aff.catalogservice.testutils.TestUtils.toJson;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .content(toJson(new UserCredentials("username", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jwttoken", Matchers.notNullValue()));

    }

    @Test
    public void thatUserAuthenticationFailsWhenWrongPasswordIsSubmitted() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/authenticate")
                .content(toJson(new UserCredentials("username", "incorect_password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void thatUserAuthenticationFailsWhenNonExistingUsernameIsSubmitted() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/authenticate")
                .content(toJson(new UserCredentials("non_existing_username", "password")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}
