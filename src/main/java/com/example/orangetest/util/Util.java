package com.example.orangetest.util;

import com.example.orangetest.exception.InsufficientBalance;

import javax.validation.ConstraintViolation;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Util {

    public static long calculateRemainingBalance(long currentBalance, long duration){
        return currentBalance - duration;
    }

    public static boolean validateVacation(long currentBalance, long duration){
        if(currentBalance<duration){
            throw new InsufficientBalance("insufficient Balance");
        }else {
            return true;
        }
    }

    public  static long calculateDuration(LocalDate date1, LocalDate date2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return ChronoUnit.DAYS.between(date1, date2);
    }

    public  static LocalDate convertStringToLcalDate(String dateStr ) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateStr, dtf);    }
}
