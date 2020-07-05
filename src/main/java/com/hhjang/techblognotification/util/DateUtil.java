package com.hhjang.techblognotification.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static boolean isToday(LocalDate targetDate) {
        return LocalDate.now(ZoneId.of("Asia/Seoul")).equals(targetDate);
    }
}
