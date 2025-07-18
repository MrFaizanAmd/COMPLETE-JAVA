import java.util.EnumSet;

public class EnumSetExample {
    public static void main(String[] args) {
        // 1️⃣ Creating an EnumSet with predefined elements
        EnumSet<Day> weekdays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);
        System.out.println("Weekdays: " + weekdays);

        // 2️⃣ Creating an EnumSet with all elements
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);

        // 3️⃣ Creating an empty EnumSet and adding elements
        EnumSet<Day> weekend = EnumSet.noneOf(Day.class);
        weekend.add(Day.SATURDAY);
        weekend.add(Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // 4️⃣ Creating an EnumSet with range (Subset of enums)
        EnumSet<Day> midWeek = EnumSet.range(Day.TUESDAY, Day.THURSDAY);
        System.out.println("Midweek: " + midWeek);

        // 5️⃣ Removing elements
        weekdays.remove(Day.FRIDAY);
        System.out.println("Weekdays after removal: " + weekdays);

        // 6️⃣ Using complementOf() to get the opposite elements
        EnumSet<Day> nonWeekdays = EnumSet.complementOf(weekdays);
        System.out.println("Non-Weekdays (Weekend): " + nonWeekdays);

        // 7️⃣ Iterating through EnumSet
        System.out.println("Iterating over EnumSet:");
        for (Day day : allDays) {
            System.out.println(day);
        }

        System.out.println("----------------------------------------------------");

        // 🔹 Advanced Usage

        // 1️⃣ EnumSet in a switch-case
        EnumSet<Day> busyDays = EnumSet.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY);
        Day today = Day.WEDNESDAY;

        if (busyDays.contains(today)) {
            System.out.println(today + " is a busy day!");
        } else {
            System.out.println(today + " is a free day!");
        }

        // 2️⃣ Using EnumSet in a method
        checkHoliday(Day.SUNDAY);
        checkHoliday(Day.MONDAY);
    }

    // Method using EnumSet to check if a day is a holiday
    public static void checkHoliday(Day day) {
        EnumSet<Day> holidays = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        if (holidays.contains(day)) {
            System.out.println(day + " is a holiday! 🎉");
        } else {
            System.out.println(day + " is a working day. 🏢");
        }
    }
}

// Enum representing days of the week
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
