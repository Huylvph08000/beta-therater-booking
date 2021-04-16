package com.acazia.betatheater.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public  final class DateUtils {
    public static LocalDateTime convertToLocalDateTime(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
