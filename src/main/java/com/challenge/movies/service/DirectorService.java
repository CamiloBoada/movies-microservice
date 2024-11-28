package com.challenge.movies.service;

import com.challenge.movies.dto.response.Director;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface DirectorService {
    Director getDirectors(int threshold) throws JsonProcessingException;
}
