package com.challenge.movies.controller;

import com.challenge.movies.MainApplication;
import com.challenge.movies.client.MoviesFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MainApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "api.base-url=https://www.movies.com",
        "api.endpoint=/api/movies/search"
})
class DirectorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoviesFeignClient moviesFeignClient;


    @Test
    void getDirectorsSuccess() throws Exception {
        String mockResponse = "{\"totalPages\":1,\"data\":[{\"title\":\"Inception\",\"director\":\"Christopher Nolan\"}]}";
        when(moviesFeignClient.getDirectors(1)).thenReturn(mockResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/directors")
                        .param("threshold", "1"))
                .andExpect(status().isOk());
    }
}

