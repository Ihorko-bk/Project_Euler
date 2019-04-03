package name.ihorko.problems.problem_019__Counting_Sundays;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * You are given the following information, but you may prefer to do some research for yourself:
 * 1 Jan 1900 was a Monday.
 * Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * Answer: 171
 */

public class Problem_019 {
    public static void main(String[] args) {
        LocalDate date;
        int sundaysCounter = 0;
        for (int i = 1901; i <= 2000; i++) {
            date = LocalDate.of(i, 1, 1);
            for (int j = 0; j <= 11; j++) {
                if (date.plusMonths(j).getDayOfWeek() == DayOfWeek.SUNDAY) sundaysCounter++;
            }
        }
        System.out.println(sundaysCounter);


    }

}
