package com.arka.play.persistence.mapper;

import com.arka.play.domain.dto.MovieDTO;
import com.arka.play.persistence.entity.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    // Entity to DTO
    @Mapping(source = "releaseDate", target = "releaseDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "calification", target = "rating")
    //@Mapping(target = "id", ignore = true)
    MovieDTO toMovieDTO(Movie movie);

    // Entities to DTOs
    List<MovieDTO> toMoviesDTO(List<Movie> movies);


    // DTO to Entity

    @InheritInverseConfiguration
    @Mapping(target = "state", constant = "true")
    Movie toMovie(MovieDTO movieDTO);

    List<Movie> toMovies(List<MovieDTO> movieDTOS);
}
