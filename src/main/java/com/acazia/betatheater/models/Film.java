package com.acazia.betatheater.models;

import com.acazia.betatheater.enums.FilmCategoryEnum;
import com.acazia.betatheater.enums.TimePlay;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "film")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Film extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "release_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate releaseDate;

    @Column(name = "start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    @Column(length = 3000)
    private String description;

    @Column(length = 500)
    private String shortDescription;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @Column(name = "information")
    private String information;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("film")
    private Collection<Airtime> time_frames;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("film")
    private Collection<Comment> comments;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "category")
    private Integer category;



}
