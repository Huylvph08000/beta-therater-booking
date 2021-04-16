package com.acazia.betatheater.dto.produce;

import com.acazia.betatheater.models.FilmCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@Builder
public class FilmProduceDto {

    private String name;

//    @JsonProperty("release_date")
    private LocalDate releaseDate;

    private String description;

    @JsonProperty("age_limit")
    @Min(0)
    private Integer ageLimit;

    private String information;

    private String type;

    private String categoryName;

}
