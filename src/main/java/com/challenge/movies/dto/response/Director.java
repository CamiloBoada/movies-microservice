package com.challenge.movies.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Director {
    private List<String> directors;
}
