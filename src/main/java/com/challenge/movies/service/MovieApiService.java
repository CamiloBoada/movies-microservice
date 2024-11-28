package com.challenge.movies.service;

import com.challenge.movies.dto.response.Page;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MovieApiService {
    Page getMovies(int page) throws JsonProcessingException;
}
