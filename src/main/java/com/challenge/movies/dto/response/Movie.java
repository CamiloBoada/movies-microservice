package com.challenge.movies.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Movie {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Director")
    private String director;
}
