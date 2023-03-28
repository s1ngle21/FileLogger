import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {

    public static String date() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
        String formattedDateTime = time.format(formatter);
        return formattedDateTime;
    }
}
