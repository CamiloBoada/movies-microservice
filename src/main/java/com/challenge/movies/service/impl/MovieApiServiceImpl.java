package com.challenge.movies.service.impl;

import com.challenge.movies.Constant;
import com.challenge.movies.service.MovieApiService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;


@Service
public class MovieApiServiceImpl implements MovieApiService {

    private final WebClient.Builder webClientBuilder;
    private WebClient webClient;

    @Value("${api.base-url}")
    private String baseUrl;

    @Value("${api.endpoint}")
    private String endpoint;

    public MovieApiServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @PostConstruct
    public void init() {
        this.webClient = webClientBuilder
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public String getMovies(int page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(endpoint)
                        .queryParam(Constant.PAGE_PARAM, page)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
