package com.challenge.movies.controller;

import com.challenge.movies.dto.response.Director;
import com.challenge.movies.service.DirectorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

public class DirectorControllerTest {

    @Mock
    private DirectorService directorService;

    @InjectMocks
    private DirectorController directorController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDirectorsSuccess() throws JsonProcessingException {
        List<String> directors = new ArrayList<>();
        directors.add("Christopher Nolan");
        Director director = new Director(directors);

        when(directorService.getDirectors(1)).thenReturn(director);

        ResponseEntity<Director> directorResponse = directorController.getDirectors(1);

        Assertions.assertEquals("200 OK", directorResponse.getStatusCode().toString());
        Assertions.assertEquals(1, Objects.requireNonNull(directorResponse.getBody()).getDirectors().size());
    }
}
