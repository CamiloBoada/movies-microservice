package com.challenge.movies.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageMovie {
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<Movie> data;
}
