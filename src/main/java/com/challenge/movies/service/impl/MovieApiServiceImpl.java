package com.challenge.movies.service.impl;

import com.challenge.movies.Constant;
import com.challenge.movies.dto.response.Page;
import com.challenge.movies.service.MovieApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;


@Service
public class MovieApiServiceImpl implements MovieApiService {

    private final WebClient.Builder webClientBuilder;
    private final ObjectMapper objectMapper;
    private WebClient webClient;

    @Value("${api.base-url}")
    private String baseUrl;

    @Value("${api.endpoint}")
    private String endpoint;

    public MovieApiServiceImpl(WebClient.Builder webClientBuilder,
                               ObjectMapper objectMapper) {
        this.webClientBuilder = webClientBuilder;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        this.webClient = webClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public Page getMovies(int page) throws JsonProcessingException {
        return objectMapper.readValue(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(endpoint)
                        .queryParam(Constant.PAGE_PARAM, page)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block(), Page.class);
    }
}
