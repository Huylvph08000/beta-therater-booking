package com.acazia.betatheater.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FilmEnum implements BaseEnum{
    AVAILABLE(1), PLAYING(2), END(3);
    private final int code;
}
