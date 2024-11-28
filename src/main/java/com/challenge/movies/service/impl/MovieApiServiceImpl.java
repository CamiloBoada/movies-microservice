package com.challenge.movies.service.impl;

import com.challenge.movies.client.MoviesFeignClient;
import com.challenge.movies.dto.response.PageMovie;
import com.challenge.movies.service.MovieApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MovieApiServiceImpl implements MovieApiService {

    private final ObjectMapper objectMapper;
    private final MoviesFeignClient moviesFeignClient;


    @Override
    public PageMovie getMovies(int page) throws JsonProcessingException {
        return objectMapper.readValue(moviesFeignClient.getDirectors(page), PageMovie.class);
    }
}
