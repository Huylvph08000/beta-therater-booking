package com.acazia.betatheater.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FilmCategoryEnum implements BaseEnum{
    ACTION(1), COMEDY(2),
    DRAMA(3),FANTASY(4),
    MYSTERY(5), HORROR(6),
    ROMANCE(7), THRILLER(8),
    WESTERN(9);
    private final int code;
}
