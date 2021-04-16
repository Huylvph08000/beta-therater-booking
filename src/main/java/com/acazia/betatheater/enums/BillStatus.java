package com.acazia.betatheater.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  BillStatus implements BaseEnum{
    NEW(1), PENDING(2), PAID(3);

    private final int code;
}
