package com.challenge.movies.controller;

import com.challenge.movies.dto.response.Director;
import com.challenge.movies.service.DirectorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public ResponseEntity<Director> getDirectors(@RequestParam int threshold) throws JsonProcessingException {
        return ResponseEntity.ok(directorService.getDirectors(threshold));
    }
}
