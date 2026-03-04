package com.arka.play.persistence.repository;

import com.arka.play.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();

    Movie findFirstByTitle(String title);
}
