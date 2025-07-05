# **Java Properties Class - Complete Guide 🚀**

## **Introduction**

### **What is Properties Class?**
The `Properties` class in Java is a specialized `Hashtable` designed to store **key-value pairs**, where **both keys and values are Strings**. It is commonly used for handling **configuration settings**, such as application properties, database settings, and localization.

### **Why is Properties Class Important?**
✔ **Manages application configuration easily** 📄  
✔ **Supports loading from files** (e.g., `.properties` files) 📂  
✔ **Built-in methods for reading & writing settings** 🔄  
✔ **Lightweight and easy to use** 🎯  

### **Real-life Analogy** 📌
Think of the `Properties` class as a **settings notebook** 📖 for an application:
- Each setting is stored as a **key-value** pair (e.g., `theme=dark`).
- You can **load** settings from a **file** and **modify** them at runtime.
- Instead of hardcoding configurations, you can change them without modifying code!

---

## **Hierarchy of Properties Class**
```
Object (Superclass)
│
├── Hashtable<Object, Object> (Superclass)
│   ├── Properties (Final Class) ✅ (Our Focus!)
```

### **Key Points:**
- `Properties` **inherits** from `Hashtable`, but it enforces **String-based keys and values**.
- Provides **default properties** that can be used when a key is missing.
- Supports **file-based input and output operations**.

---

## **Key Features of Properties Class 🚀**
✅ **Key-Value Storage** – Both **keys and values** must be `String`.
✅ **Load & Store from Files** – Reads from `.properties` files & writes back.
✅ **Retrieve Default Values** – If a key is missing, fallback to defaults.
✅ **Lightweight & Easy to Use** – No external dependencies needed.
✅ **Useful for Internationalization** – Helps manage locale-specific settings.

---

## **How Properties Class Works Internally? 🛠️**
### **1. Storing Properties in Memory**
- The `Properties` object stores key-value pairs in **memory**.
- Since it extends `Hashtable`, it provides **fast lookups**.

### **2. Loading from a File**
- Properties can be loaded from a **text file** with `.properties` extension.
- Example file format:
  ```properties
  db.user=root
  db.password=1234
  theme=dark
  ```

### **3. Fetching Values**
- Retrieve values using `getProperty(String key)`, optionally providing a **default value**.

### **4. Writing to a File**
- Changes made to the `Properties` object can be **stored back into a file**.

---

## **Creating and Using Properties in Java**

### **Example 1: Creating & Fetching Properties**  
```java
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties config = new Properties();
        
        // Adding properties
        config.setProperty("username", "admin");
        config.setProperty("password", "secure123");
        
        // Fetching properties
        String user = config.getProperty("username");
        String password = config.getProperty("password", "defaultPass");
        
        System.out.println("Username: " + user);
        System.out.println("Password: " + password);
    }
}
```

### **Output:**
```
Username: admin
Password: secure123
```

📌 **Notice:** If the key is missing, the default value (`defaultPass`) is returned.

---

### **Example 2: Loading Properties from a File**  
```java
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFromFile {
    public static void main(String[] args) {
        Properties config = new Properties();
        
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
            
            String user = config.getProperty("db.user");
            String pass = config.getProperty("db.password");
            
            System.out.println("Database User: " + user);
            System.out.println("Database Password: " + pass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### **Example config.properties File:**
```properties
db.user=admin
db.password=secure123
theme=light
```

📌 **Notice:** The `Properties` class reads the file and loads its key-value pairs.

---

## **Common Methods in Properties Class**  

| Method | Description |
|--------|------------|
| `setProperty(String key, String value)` | Adds a key-value pair to the properties. |
| `getProperty(String key)` | Retrieves the value associated with a key. |
| `getProperty(String key, String defaultValue)` | Retrieves the value or returns a default. |
| `load(InputStream inStream)` | Loads properties from an input stream. |
| `store(OutputStream out, String comments)` | Writes properties to an output stream. |
| `list(PrintStream out)` | Prints all key-value pairs. |
| `stringPropertyNames()` | Returns a set of property keys. |

---

## **When to Use Properties Class?** ✅
✔ **Application Configuration** – Managing settings in a file-based manner.
✔ **Database Configuration** – Storing DB credentials and connection settings.
✔ **Internationalization (i18n)** – Managing localized messages.
✔ **Environment Variables** – Storing system-wide settings.
✔ **Custom Settings** – Any key-value pair storage requirement.

## **When NOT to Use Properties Class?** ❌
✘ When you need **complex structured data** (use JSON or XML instead).  
✘ If **type safety is required**, as `Properties` stores everything as `String`.  
✘ If you require **real-time updates** – `Properties` files do not auto-refresh.

---

## **Properties vs Other Storage Options**

| Feature | Properties Class | JSON | XML | Database |
|---------|-----------------|------|-----|----------|
| Human-readable | ✅ Yes | ✅ Yes | ❌ Less readable | ❌ No |
| Supports hierarchy | ❌ No | ✅ Yes | ✅ Yes | ✅ Yes |
| Easy to edit | ✅ Yes | ✅ Yes | ❌ No | ❌ No |
| Parsing performance | ✅ Fast | ✅ Fast | ❌ Slower | ❌ Slower |

---

## **Summary** 🎯
- `Properties` is a **lightweight key-value store** for application settings.
- It allows **loading from files** and **saving settings easily**.
- Used for **configuration files, environment settings, and localization**.
- Best suited for **simple text-based key-value storage**.

---

## **FAQ - Frequently Asked Questions** ❓

### **1. Can I use non-String keys or values in Properties?**
No, `Properties` only supports `String` keys and values. If you need other types, use a `Map`.

### **2. What happens if I try to get a missing key?**
It returns `null`, or a **default value** if provided using `getProperty(key, defaultValue)`.

### **3. Is Properties thread-safe?**
Yes, since it extends `Hashtable`, it is **synchronized**. However, for concurrent modifications, prefer `ConcurrentHashMap`.

🔥 **With this guide, you now have complete clarity on Java Properties Class!** 🚀

