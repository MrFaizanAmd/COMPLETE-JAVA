import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimePractice {
    public static void main(String[] args) {
        // 1. LocalDate Examples
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2025, Month.MARCH, 2);
        LocalDate parsedDate = LocalDate.parse("2025-03-02");
        
        System.out.println("Today's Date: " + today);
        System.out.println("Specific Date: " + specificDate);
        System.out.println("Parsed Date: " + parsedDate);
        
        // 2. LocalTime Examples
        LocalTime nowTime = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30, 15);
        LocalTime parsedTime = LocalTime.parse("14:30:15");
        
        System.out.println("Current Time: " + nowTime);
        System.out.println("Specific Time: " + specificTime);
        System.out.println("Parsed Time: " + parsedTime);
        
        // 3. LocalDateTime Examples
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime specificDateTime = LocalDateTime.of(2025, Month.MARCH, 2, 14, 30);
        LocalDateTime parsedDateTime = LocalDateTime.parse("2025-03-02T14:30:00");
        
        System.out.println("Current DateTime: " + nowDateTime);
        System.out.println("Specific DateTime: " + specificDateTime);
        System.out.println("Parsed DateTime: " + parsedDateTime);
        
        // 4. ZonedDateTime Examples
        ZonedDateTime zonedNow = ZonedDateTime.now();
        ZonedDateTime specificZone = ZonedDateTime.of(specificDateTime, ZoneId.of("America/New_York"));
        
        System.out.println("Current ZonedDateTime: " + zonedNow);
        System.out.println("Specific ZonedDateTime: " + specificZone);
        
        // 5. Period Examples (Difference Between Dates)
        Period period = Period.between(LocalDate.of(2024, 3, 2), today);
        System.out.println("Period Difference: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");
        
        // 6. Duration Examples (Difference Between Times)
        Duration duration = Duration.between(LocalTime.of(10, 0), nowTime);
        System.out.println("Duration Difference: " + duration.toHours() + " hours, " + duration.toMinutes() % 60 + " minutes");
        
        // 7. Formatting Dates and Times
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
        System.out.println("Formatted Date: " + today.format(dateFormatter));
        System.out.println("Formatted Time: " + nowTime.format(timeFormatter));
        System.out.println("Formatted DateTime: " + nowDateTime.format(dateTimeFormatter));
        
        // 8. Adding and Subtracting Time
        System.out.println("Date after 10 days: " + today.plusDays(10));
        System.out.println("Time after 3 hours: " + nowTime.plusHours(3));
        System.out.println("DateTime 1 week ago: " + nowDateTime.minus(1, ChronoUnit.WEEKS));
        
        // 9. Comparing Dates and Times
        boolean isBefore = today.isBefore(specificDate);
        boolean isAfter = nowTime.isAfter(specificTime);
        
        System.out.println("Is today before specific date? " + isBefore);
        System.out.println("Is now time after specific time? " + isAfter);
    }
}
