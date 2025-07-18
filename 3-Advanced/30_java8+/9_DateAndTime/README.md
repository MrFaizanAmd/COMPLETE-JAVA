# **Java Date and Time API (Java 8+) - A Complete Guide** 🚀  

## **Introduction**  

Before Java 8, working with dates and times in Java was challenging due to issues with **mutability, thread-safety, and lack of built-in support for time zones**. The old `java.util.Date` and `java.util.Calendar` classes were cumbersome and error-prone.  

To solve these problems, Java 8 introduced the **java.time** package, which provides an immutable, thread-safe, and more intuitive way to work with dates, times, and durations.  

---

## **1. Why Use the Java 8 Date and Time API?**  

✅ **Immutable and Thread-Safe** – Unlike `java.util.Date`, all classes in `java.time` are immutable and safe to use in multi-threaded environments.  
✅ **Clearer API** – Provides intuitive class names and methods (e.g., `LocalDate.now()`, `LocalTime.of()`).  
✅ **Better Time Zone Support** – Includes `ZonedDateTime` for handling different time zones.  
✅ **Fluent API for Date Manipulation** – Easily add/subtract dates (`plusDays()`, `minusWeeks()`).  
✅ **ISO 8601 Compliance** – Follows industry-standard date formats.  

---

## **2. Key Classes in Java Date and Time API**  

| **Class**              | **Description** |
|------------------------|----------------------------------------------------|
| `LocalDate`           | Represents a **date (YYYY-MM-DD)** without time or time zone. |
| `LocalTime`           | Represents **time (HH:MM:SS)** without a date or time zone. |
| `LocalDateTime`       | Combines `LocalDate` and `LocalTime` (without time zone). |
| `ZonedDateTime`       | Represents date and time with a **time zone**. |
| `Instant`             | Represents a **timestamp** (seconds/nanoseconds from 1970-01-01T00:00:00Z). |
| `Duration`            | Represents a time-based amount (e.g., "2 hours, 30 minutes"). |
| `Period`              | Represents a date-based amount (e.g., "5 days, 2 months, 1 year"). |
| `DateTimeFormatter`   | Used for **formatting and parsing** date/time objects. |

---

## **3. Working with Dates - `LocalDate`**  

### **3.1 Creating a `LocalDate` Instance**  

```java
import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2025, 3, 1);

        System.out.println("Today's Date: " + today);
        System.out.println("Specific Date: " + specificDate);
    }
}
```

📌 **Output:**  
```
Today's Date: 2025-03-01
Specific Date: 2025-03-01
```

---

### **3.2 Adding and Subtracting Days, Months, and Years**  

```java
LocalDate today = LocalDate.now();

LocalDate nextWeek = today.plusWeeks(1);
LocalDate lastMonth = today.minusMonths(1);
LocalDate nextYear = today.plusYears(1);

System.out.println("Next Week: " + nextWeek);
System.out.println("Last Month: " + lastMonth);
System.out.println("Next Year: " + nextYear);
```

---

### **3.3 Comparing Dates**  

```java
LocalDate date1 = LocalDate.of(2025, 3, 1);
LocalDate date2 = LocalDate.of(2025, 3, 5);

System.out.println(date1.isBefore(date2)); // true
System.out.println(date1.isAfter(date2));  // false
System.out.println(date1.isEqual(date2));  // false
```

---

## **4. Working with Time - `LocalTime`**  

### **4.1 Creating a `LocalTime` Instance**  

```java
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30);

        System.out.println("Current Time: " + now);
        System.out.println("Specific Time: " + specificTime);
    }
}
```

---

### **4.2 Adding and Subtracting Time**  

```java
LocalTime time = LocalTime.of(10, 30);

LocalTime plusTwoHours = time.plusHours(2);
LocalTime minusThirtyMinutes = time.minusMinutes(30);

System.out.println("Time + 2 Hours: " + plusTwoHours);
System.out.println("Time - 30 Minutes: " + minusThirtyMinutes);
```

---

## **5. Combining Date and Time - `LocalDateTime`**  

```java
import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 1, 10, 30);

        System.out.println("Current Date & Time: " + now);
        System.out.println("Specific Date & Time: " + dateTime);
    }
}
```

---

## **6. Working with Time Zones - `ZonedDateTime`**  

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime nowInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("UTC Time: " + nowInUTC);
        System.out.println("New York Time: " + nowInNewYork);
    }
}
```

---

## **7. Formatting and Parsing Dates - `DateTimeFormatter`**  

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);

        System.out.println("Formatted Date: " + formattedDate);
    }
}
```

---

## **8. Calculating Time Differences - `Period` and `Duration`**  

### **8.1 Difference Between Dates (`Period`)**  

```java
import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 1);

        Period period = Period.between(startDate, endDate);
        System.out.println("Years: " + period.getYears() + ", Months: " + period.getMonths() + ", Days: " + period.getDays());
    }
}
```

---

### **8.2 Difference Between Time (`Duration`)**  

```java
import java.time.Duration;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 30);

        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Hours: " + duration.toHours() + ", Minutes: " + duration.toMinutes());
    }
}
```

---

## **9. Additional Resources**  

- 📖 [Official Java Time API Docs](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)  
- 📚 [Java 8 Date and Time Tutorial](https://www.baeldung.com/java-8-date-time-intro)  

---

## **10. Hands-On Practice**  

📂 **[Click here](./java-time-practice)** to access hands-on coding exercises on Java Date and Time API.  

---

### **Conclusion**  

Java 8’s Date and Time API provides **an intuitive, thread-safe, and efficient way** to handle dates, times, and time zones. By mastering these classes, you can write **more reliable and maintainable** date-time code in Java! 🚀