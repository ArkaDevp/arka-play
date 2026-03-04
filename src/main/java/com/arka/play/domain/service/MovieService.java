package com.arka.play.domain.service;

import com.arka.play.domain.dto.MovieDTO;
import com.arka.play.domain.exception.MovieAlreadyExistsException;
import com.arka.play.domain.exception.MovieNotFoundException;
import com.arka.play.persistence.entity.Movie;
import com.arka.play.persistence.mapper.MovieMapper;
import com.arka.play.persistence.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDTO> findAll(){
        return movieMapper.toMoviesDTO(movieRepository.findAll());
    }

    public Optional<MovieDTO> findById(Long id){
        return movieRepository.findById(id).map(movieMapper::toMovieDTO);
    }

    public MovieDTO save(MovieDTO movieDTO){
        if(movieRepository.findFirstByTitle(movieDTO.title()) != null){
            throw new MovieAlreadyExistsException(movieDTO.title());
        }
        Movie movie = movieMapper.toMovie(movieDTO);
        Movie ms = movieRepository.save(movie);
        return movieMapper.toMovieDTO(ms);
    }

    public Optional<MovieDTO> update(MovieDTO movieDTO){
        return movieRepository.findById(movieDTO.id()).map(existingMovie -> {
            if (movieDTO.title() != null) {
                existingMovie.setTitle(movieDTO.title());
            }
            if (movieDTO.genre() != null) {
                existingMovie.setGenre(movieDTO.genre());
            }
            if (movieDTO.releaseDate() != null) {
                existingMovie.setReleaseDate(LocalDate.parse(movieDTO.releaseDate()));
            }
            if (movieDTO.rating() != null) {
                existingMovie.setCalification(BigDecimal.valueOf(movieDTO.rating()));
            }
            Movie updatedMovie = movieRepository.save(existingMovie);
            return movieMapper.toMovieDTO(updatedMovie);
        });
    }

    public boolean delete(Long id){
        if (movieRepository.findById(id).isEmpty()){
            throw new MovieNotFoundException(id.toString());
        }
        return movieRepository.findById(id).map(movie -> {
            movieRepository.delete(movie);
            return true;
        }).orElse(false);
    }

}
