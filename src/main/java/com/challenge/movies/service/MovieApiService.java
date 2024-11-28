package com.challenge.movies.service;

import com.challenge.movies.dto.response.PageMovie;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MovieApiService {
    PageMovie getMovies(int page) throws JsonProcessingException;
}
