import java.io.*;
import java.util.*;

public class PropertiesExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a Properties object
        Properties properties = new Properties();

        // 2️⃣ Adding key-value pairs
        properties.setProperty("username", "admin");
        properties.setProperty("password", "12345");
        properties.setProperty("url", "https://example.com");

        // Displaying properties
        System.out.println("Properties: " + properties);

        // 3️⃣ Fetching a property
        System.out.println("Username: " + properties.getProperty("username"));
        System.out.println("URL: " + properties.getProperty("url"));

        // 4️⃣ Saving properties to a file
        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            properties.store(fos, "Application Configurations");
            System.out.println("Properties saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5️⃣ Loading properties from a file
        Properties loadedProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            loadedProperties.load(fis);
            System.out.println("Loaded Properties: " + loadedProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 6️⃣ Iterating over properties
        System.out.println("Iterating over properties:");
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + " = " + properties.getProperty(key));
        }

        // 7️⃣ Using default values
        System.out.println("Database: " + properties.getProperty("database", "Not Defined"));
    }
}
