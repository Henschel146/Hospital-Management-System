package org.group3.hospitalmanagementsystem.Utils;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {
    public static int calculateAge(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(date, currentDate).getYears();
    }
}
