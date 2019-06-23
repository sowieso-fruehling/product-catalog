package de.br.aff.catalogservice.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void thatEndpointIsUnavailableWithoutJwtToken() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/catalog-api/v1/products")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void thatEndpointIsUnavailableWithoutValidJwtToken() throws Exception {

        String invalidToken="Bearer 111111111111111.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6MTU2MjE3NDcxMCwiaWF0IjoxNTYxMzEwNzEwfQ.0ictAa4m41JBdUQ3bx0divbv_UzfRzjjopbfY9fFhgcBX2gUmbSZwlWMjRBhP030mUm7FmbmP5PNPD-1nBUm8Q";

        mockMvc.perform(MockMvcRequestBuilders
                .get("/catalog-api/v1/products")
                .header(HttpHeaders.AUTHORIZATION,invalidToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void thatEndpointIsUnavailableWithExpiredJwtToken() throws Exception {

        String invalidToken="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6MTU2MTMxNzgyMywiaWF0IjoxNTYxMzE3NzYzfQ.5YcklS-z9rPWA0Lsf6VX8D6TazeZvVCp249QLKwuEU0iqq_j78GnV3MQ0z18fGztXnQ5Fi2EKUXD-37MJIcc5w";

        mockMvc.perform(MockMvcRequestBuilders
                .get("/catalog-api/v1/products")
                .header(HttpHeaders.AUTHORIZATION,invalidToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void thatEndpointIsAccessibleWithValidJwtToken() throws Exception {

        //this token will be valid until 23.06.2119
        String validToken="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6NDcxNDkxNzY1OSwiaWF0IjoxNTYxMzE3NjU5fQ.ww525pk_LeH0wsp86oY7VH7LZlWuh4s0BKSdodl_DbsN3s-Wp0-dA4aK9uQhmMV4QHof9BYQd6nNAUfTvVUyqg";

        mockMvc.perform(MockMvcRequestBuilders
                .get("/catalog-api/v1/products")
                .header(HttpHeaders.AUTHORIZATION,validToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}