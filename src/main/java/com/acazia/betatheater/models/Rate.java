package com.acazia.betatheater.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Rate extends BaseEntity{
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "content_review")
    private String contentReview;

    @Column(name = "score")
    private int score;
}
