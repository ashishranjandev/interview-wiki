package javalang.java9.features.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class TimeFeatures {

    public static void main(String...args) {
        LocalDate birthDay = LocalDate.of(1991, 12, 6);

        System.out.println(birthDay.
                                datesUntil(LocalDate.now(), Period.ofYears(1)).
                                map(date -> Year.of(date.getYear())).
                                filter(Year::isLeap).
                                count());
    }
}
