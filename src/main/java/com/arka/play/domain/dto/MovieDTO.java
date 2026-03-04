package com.arka.play.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

public record MovieDTO(
        Long id,
        String title,
        Integer duration,
        String genre,
        @PastOrPresent
        String releaseDate,
        @Min(value = 0, message = "The rating dont could be less than 0")
        @Max(value = 5, message = "The rating dont could be greater than 5")
        Double rating
 ) {
}
