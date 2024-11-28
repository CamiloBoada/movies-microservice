package com.challenge.movies.service.impl;

import com.challenge.movies.dto.response.Director;
import com.challenge.movies.dto.response.PageMovie;
import com.challenge.movies.exception.NotFoundMoviesException;
import com.challenge.movies.service.DirectorService;
import com.challenge.movies.service.MovieApiService;
import com.challenge.movies.util.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


@Service
public class DirectorServiceImpl implements DirectorService {

    private final MovieApiService movieApiService;

    public DirectorServiceImpl(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    @Override
    public Director getDirectors(int threshold) throws JsonProcessingException {
        int page = Constant.ONE;
        int totalPages = Constant.ONE;
        Map<String, Integer> directors = new HashMap<>();

        while (page <= totalPages) {
            PageMovie pageMovie = movieApiService.getMovies(page);
            if (nonNull(pageMovie)) {
                totalPages = pageMovie.getTotalPages();
                pageMovie.getData().forEach(movie ->
                        directors.merge(movie.getDirector(), Constant.ONE, Integer::sum));
            } else {
                throw new NotFoundMoviesException("No movies were found when consuming the external service.");
            }
            page++;
        }
        return new Director(filterAndSortDirectors(directors, threshold));
    }

    private List<String> filterAndSortDirectors(Map<String, Integer> directors, int threshold) {
        return directors.entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }
}
