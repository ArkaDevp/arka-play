package com.arka.play.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String title;
    @Column(nullable = false, precision = 3)
    private Integer duration;
    @Column(nullable = false, length = 40)
    private String genre;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(precision = 3, scale = 2)
    private BigDecimal calification;
    @Column(nullable = false)
    private Boolean state;

}
