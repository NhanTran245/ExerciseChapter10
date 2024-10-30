package helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String getCurrentDateTimeString (String patter) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(patter);
        LocalDateTime currentDateTime = LocalDateTime.now();

        return currentDateTime.format(format);
    }
}
