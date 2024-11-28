package com.challenge.movies.service;

import com.challenge.movies.dto.response.Director;
import com.challenge.movies.dto.response.Movie;
import com.challenge.movies.dto.response.PageMovie;
import com.challenge.movies.exception.NotFoundMoviesException;
import com.challenge.movies.service.impl.DirectorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


public class DirectorServiceTest {

    @Mock
    private MovieApiService movieApiService;

    @InjectMocks
    private DirectorServiceImpl directorService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDirectorsSuccess() throws JsonProcessingException {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Christopher Nolan"));
        PageMovie pageMovie = new PageMovie(1,1,1,1,movies);

        when(movieApiService.getMovies(1)).thenReturn(pageMovie);

        Director directorResponse = directorService.getDirectors(0);

        Assertions.assertEquals(1, directorResponse.getDirectors().size());
    }

    @Test
    void getDirectorsException() throws JsonProcessingException {

        when(movieApiService.getMovies(1)).thenReturn(null);

        assertThrows(NotFoundMoviesException.class, () -> directorService.getDirectors(0));
    }
}
