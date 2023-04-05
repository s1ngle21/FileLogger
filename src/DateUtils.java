import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private static final String pattern = "dd.MM.yyyy - HH:mm:ss";

    private DateUtils() {
    }

    public static String getCurrentDate(String pattern) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return time.format(formatter);
    }
}
