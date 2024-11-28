package com.challenge.movies.client;

import com.challenge.movies.util.Constant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movie-service", url = "${api.base-url}")
public interface MoviesFeignClient {

    @GetMapping("${api.endpoint}")
    String getDirectors(@RequestParam(Constant.PAGE_PARAM) int page);
}
