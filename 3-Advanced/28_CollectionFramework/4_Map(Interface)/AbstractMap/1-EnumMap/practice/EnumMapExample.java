import java.util.EnumMap;
import java.util.Map;

// 1️⃣ Define an Enum for demonstration
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapExample {
    public static void main(String[] args) {
        // 2️⃣ Creating an EnumMap
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        // 3️⃣ Adding values to EnumMap
        schedule.put(Day.MONDAY, "Go to the gym");
        schedule.put(Day.TUESDAY, "Attend meetings");
        schedule.put(Day.WEDNESDAY, "Work on project");
        schedule.put(Day.THURSDAY, "Team lunch");
        schedule.put(Day.FRIDAY, "Submit reports");
        schedule.put(Day.SATURDAY, "Go for a trip");
        schedule.put(Day.SUNDAY, "Relax at home");

        // 4️⃣ Printing the EnumMap
        System.out.println("Weekly Schedule: " + schedule);

        // 5️⃣ Accessing a specific value
        System.out.println("Activity on Wednesday: " + schedule.get(Day.WEDNESDAY));

        // 6️⃣ Checking if a key exists
        System.out.println("Does the schedule have Sunday? " + schedule.containsKey(Day.SUNDAY));

        // 7️⃣ Iterating over the EnumMap
        System.out.println("\nIterating over EnumMap:");
        for (Map.Entry<Day, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 8️⃣ Removing an entry
        schedule.remove(Day.SATURDAY);
        System.out.println("\nAfter removing Saturday: " + schedule);

        // 9️⃣ Clearing the EnumMap
        schedule.clear();
        System.out.println("\nAfter clearing, is EnumMap empty? " + schedule.isEmpty());
    }
}
