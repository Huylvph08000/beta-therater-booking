package com.acazia.betatheater.models;

import com.acazia.betatheater.enums.TimePlay;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airtime")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Airtime extends BaseEntity{
   private TimePlay timePlay;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("film")
    Film film;
}
