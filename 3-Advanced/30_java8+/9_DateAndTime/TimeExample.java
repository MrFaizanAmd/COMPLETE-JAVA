import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();

        // Define a formatter for 12-hour format with AM/PM, minutes, seconds, and milliseconds
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss.SSS a");

        // Format and print the current time
        String formattedTime = now.format(formatter);
        System.out.println("Current Time (12-hour format): " + formattedTime);
    }
}
