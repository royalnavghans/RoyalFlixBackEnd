package com.example.royalflixbackend.Controller;

import com.example.royalflixbackend.MoviesEntities.Movies;
import com.example.royalflixbackend.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("http://localhost:3000/")
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping

    public ResponseEntity<List<Movies>> allMovies(){
        return new ResponseEntity<List<Movies>>(movieService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>>getMoviesById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movies>>(movieService.getById(id),HttpStatus.OK);
    }

    @GetMapping("imdb/{imdbid}")
    public ResponseEntity<Optional<Movies>>getMoviesByimdbId(@PathVariable String imdbid){
        return new ResponseEntity<Optional<Movies>>(movieService.getByimdbId(imdbid),HttpStatus.OK);
    }
@PostMapping("/create")
    public ResponseEntity<Movies>createMovie(@RequestBody Movies movie){
        return new ResponseEntity<Movies>(movieService.createMovies(movie),HttpStatus.CREATED);
    }
}
