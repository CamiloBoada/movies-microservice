package com.challenge.movies.service;

import com.challenge.movies.client.MoviesFeignClient;
import com.challenge.movies.dto.response.Movie;
import com.challenge.movies.dto.response.PageMovie;
import com.challenge.movies.service.impl.MovieApiServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class MovieApiServiceTest {

    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private MoviesFeignClient moviesFeignClient;
    @InjectMocks
    private MovieApiServiceImpl movieApiService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMoviesSuccess() throws JsonProcessingException {
        int page = 1;
        String jsonResponse = "{\"totalPages\":1,\"data\":[{\"title\":\"Inception\",\"director\":\"Christopher Nolan\"}]}";

        List<Movie> data = new ArrayList<>();
        data.add(new Movie("Inception", "Christopher Nolan"));
        PageMovie expectedPageMovie = new PageMovie(1,1,1,1,data);

        when(moviesFeignClient.getDirectors(1)).thenReturn(jsonResponse);
        when(objectMapper.readValue(jsonResponse, PageMovie.class)).thenReturn(expectedPageMovie);

        PageMovie result = movieApiService.getMovies(page);

        assertNotNull(result);
    }
}
