package com.ciamb.vcode.utility.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Sunday {

    public LocalDate getLastSundayOf(int year, Month month) {
        var date = LocalDate.of(year, month, Month.MARCH.maxLength());
        var lastDay = date.getDayOfWeek();
        if (lastDay == DayOfWeek.SUNDAY) return date;
        var lastSunday = date.minusDays(Long.valueOf(lastDay.getValue()));
        return lastSunday;
    }

}
