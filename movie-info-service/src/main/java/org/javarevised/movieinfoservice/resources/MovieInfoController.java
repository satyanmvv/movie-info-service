package org.javarevised.movieinfoservice.resources;

import org.javarevised.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/getMovieInfo")
public class MovieInfoController {

    @Autowired
    RestTemplate restTemplate;
    @Value("${api-key}")
    private String apiKey;
    @RequestMapping("/{movieName}")
    @GetMapping

    public MovieSummary getMovieSummary(@PathVariable String movieName){
        return restTemplate.getForObject("https://www.omdbapi.com/?apikey="+apiKey+"&t="+movieName,MovieSummary.class);


    }

}
