package com.acazia.betatheater.dto.consume;

import com.acazia.betatheater.enums.FilmCategoryEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmConsumeDto {

    private String name;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    private String description;

//    @JsonProperty("age_limit")
    @Min(0)
    private Integer ageLimit;

    private String information;

    private String type;

    @JsonProperty("category")
    private FilmCategoryEnum category;

    @JsonProperty("auditing_status")
    private Integer auditingStatus;

    private String imageUrl;
}
