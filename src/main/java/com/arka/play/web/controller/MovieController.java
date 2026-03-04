package com.arka.play.web.controller;

import com.arka.play.domain.dto.MovieDTO;
import com.arka.play.domain.service.MovieService;
import com.arka.play.persistence.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> findAll(){
        List<MovieDTO> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable Long id){
        return movieService.findById(id).map(movieDTO -> ResponseEntity.ok(movieDTO)).orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/save")
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.save(movieDTO), HttpStatus.CREATED);
    }



    @PutMapping("/update")
    public ResponseEntity<MovieDTO> update(@RequestBody @Valid MovieDTO movieDTO){
        return movieService.update(movieDTO)
                .map(movie -> new ResponseEntity<>(movie, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (movieService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
