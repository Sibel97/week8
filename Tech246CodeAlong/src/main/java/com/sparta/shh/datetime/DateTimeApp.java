package com.sparta.shh.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeApp {
    public static void main(String[] args) {
        var now = LocalDate.now();
        var nextWeek = now.plusWeeks(1);
        var anotherDate = now.withDayOfMonth(5).withDayOfYear(2025);
        if(anotherDate.getMonth().equals(nextWeek.getMonth()))
        {
            System.out.println("Same month");
        }
        else {

            System.out.println("Different month");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var myDate = LocalDate.parse("09-11-2001", formatter);
        System.out.println(myDate.toString());
    }
}
