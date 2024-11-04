package helper;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String getCurrentDateTimeString (String patter) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(patter);
        LocalDateTime currentDateTime = LocalDateTime.now();

        return currentDateTime.format(format);
    }

    public static String getDateFromTodayString (int daysFromToday, String patter) {
        LocalDate currentDate = LocalDate.now().plusDays(daysFromToday);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(patter);

        return  currentDate.format(format);
    }
}
