package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    private static final SimpleDateFormat ISO_8601_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private DateUtil() {
    }
    public static synchronized Date fromString(String date) {
        try {
            return ISO_8601_DATE_FORMAT.parse(date);
        } catch (Exception e) {
            System.err.println("Exception with parsing Date");
            throw new RuntimeException(e);
        }
    }

    public static synchronized String toString(Date startDate) {
        return ISO_8601_DATE_FORMAT.format(startDate);
    }
}
