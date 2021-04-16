package com.acazia.betatheater.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TimePlay implements BaseEnum{
    MORNING(1), NOON(2), AFTERNOON(3),EVENING(4);
    private final int code;
}
