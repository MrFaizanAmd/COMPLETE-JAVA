# 📌 **Java `Properties` Class – A Complete Reference Guide**  

## 🔥 **Introduction**  
The `Properties` class in Java is a subclass of `Hashtable<Object, Object>`, designed specifically for managing **configuration settings**.  
It stores **key-value pairs**, where both the key and value are `String`.  
Commonly used for **reading and writing configuration files** (`.properties` files).  

This guide covers **all methods**, **time complexity analysis**, and **examples**.

---

## 🏗 **Class Hierarchy**
```plaintext
Object
│
├── Dictionary<K, V>
│   ├── Hashtable<Object, Object>
│   │   ├── Properties
```
- Implements **Serializable & Cloneable**.
- Supports **default properties** (fallback settings).
- Used for **storing, retrieving, and modifying** key-value pairs.

---

## 📌 **Method Table (With Time Complexity)**  

| Method | Description | Time Complexity |
|--------|------------|-----------------|
| `String getProperty(String key)` | Retrieves value for a key | **O(1)** |
| `String getProperty(String key, String defaultValue)` | Retrieves value, returns default if not found | **O(1)** |
| `Object setProperty(String key, String value)` | Adds or updates a property | **O(1)** |
| `void load(InputStream inStream)` | Loads properties from a file | **O(n)** |
| `void load(Reader reader)` | Loads properties from a character stream | **O(n)** |
| `void store(OutputStream out, String comments)` | Saves properties to a file | **O(n)** |
| `void store(Writer writer, String comments)` | Saves properties to a character stream | **O(n)** |
| `void list(PrintStream out)` | Prints all key-value pairs | **O(n)** |
| `void list(PrintWriter out)` | Prints key-value pairs in a readable format | **O(n)** |
| `Set<String> stringPropertyNames()` | Returns a set of all keys | **O(n)** |
| `Enumeration<?> propertyNames()` | Returns an enumeration of all keys | **O(n)** |
| `void loadFromXML(InputStream inStream)` | Loads properties from an XML file | **O(n)** |
| `void storeToXML(OutputStream os, String comment)` | Saves properties to an XML file | **O(n)** |

---

## Methods and Examples

### 1. `String getProperty(String key)`
Retrieves the value for the specified key.

- **Time Complexity**: `O(1)`

```java
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("username", "admin");
        
        String user = props.getProperty("username");
        System.out.println("Username: " + user); // Output: Username: admin
    }
}
```

---

### 2. `String getProperty(String key, String defaultValue)`
Retrieves the value for a key, returns `defaultValue` if key is not found.

- **Time Complexity**: `O(1)`

```java
String password = props.getProperty("password", "defaultPass");
System.out.println("Password: " + password); // Output: Password: defaultPass
```

---

### 3. `Object setProperty(String key, String value)`
Adds or updates a property.

- **Time Complexity**: `O(1)`

```java
props.setProperty("email", "admin@example.com");
System.out.println(props.getProperty("email")); // Output: admin@example.com
```

---

### 4. `void load(InputStream inStream)`
Loads properties from a file.

- **Time Complexity**: `O(n)`

```java
import java.io.FileInputStream;
import java.io.IOException;

try (FileInputStream fis = new FileInputStream("config.properties")) {
    props.load(fis);
    System.out.println(props.getProperty("database"));
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### 5. `void load(Reader reader)`
Loads properties from a character stream.

- **Time Complexity**: `O(n)`

```java
import java.io.FileReader;
try (FileReader reader = new FileReader("config.properties")) {
    props.load(reader);
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### 6. `void store(OutputStream out, String comments)`
Saves properties to a file.

- **Time Complexity**: `O(n)`

```java
import java.io.FileOutputStream;
try (FileOutputStream fos = new FileOutputStream("config.properties")) {
    props.store(fos, "Configuration Settings");
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### 7. `void store(Writer writer, String comments)`
Saves properties to a character stream.

- **Time Complexity**: `O(n)`

```java
import java.io.FileWriter;
try (FileWriter writer = new FileWriter("config.properties")) {
    props.store(writer, "App Settings");
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### 8. `void list(PrintStream out)`
Prints all key-value pairs.

- **Time Complexity**: `O(n)`

```java
props.list(System.out);
```

---

### 9. `void list(PrintWriter out)`
Prints key-value pairs in a readable format.

- **Time Complexity**: `O(n)`

```java
import java.io.PrintWriter;
props.list(new PrintWriter(System.out));
```

---

### 10. `Set<String> stringPropertyNames()`
Returns a set of all keys.

- **Time Complexity**: `O(n)`

```java
for (String key : props.stringPropertyNames()) {
    System.out.println(key + " = " + props.getProperty(key));
}
```

---

### 11. `Enumeration<?> propertyNames()`
Returns an enumeration of all keys.

- **Time Complexity**: `O(n)`

```java
import java.util.Enumeration;
Enumeration<?> keys = props.propertyNames();
while (keys.hasMoreElements()) {
    String key = (String) keys.nextElement();
    System.out.println(key + " = " + props.getProperty(key));
}
```

---

### 12. `void loadFromXML(InputStream inStream)`
Loads properties from an XML file.

- **Time Complexity**: `O(n)`

```java
import java.io.FileInputStream;
try (FileInputStream fis = new FileInputStream("config.xml")) {
    props.loadFromXML(fis);
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### 13. `void storeToXML(OutputStream os, String comment)`
Saves properties to an XML file.

- **Time Complexity**: `O(n)`

```java
import java.io.FileOutputStream;
try (FileOutputStream fos = new FileOutputStream("config.xml")) {
    props.storeToXML(fos, "App Config");
} catch (IOException e) {
    e.printStackTrace();
}
```
---

## 🔥 **Key Differences: Properties vs. HashMap vs. Hashtable**  

| Feature | `Properties` | `HashMap` | `Hashtable` |
|---------|------------|-----------|------------|
| Thread-Safe | ✅ Yes | ❌ No | ✅ Yes |
| Allows Null Key? | ❌ No | ✅ Yes | ❌ No |
| Allows Null Value? | ❌ No | ✅ Yes | ❌ No |
| Synchronization | ✅ Yes | ❌ No | ✅ Yes |
| Key & Value Type | `String` only | Any Object | Any Object |
| Supports Default Values? | ✅ Yes | ❌ No | ❌ No |
| Used For? | Config files | General-purpose mapping | Legacy apps |

---


## 📌 **Summary**
1. `Properties` is **thread-safe** and extends `Hashtable`.
2. Stores **String key-value pairs**, ideal for **configuration files**.
3. **Common methods:** `setProperty()`, `getProperty()`, `load()`, `store()`, `list()`.
4. Supports **loading and saving in `.properties` and `.xml` formats**.
5. **Does not allow `null` keys or `null` values**.
6. **Better suited for application settings than `HashMap` or `Hashtable`**.

---

## ❓ **FAQs**
1️⃣ **Why use Properties instead of HashMap?**  
   - Properties are **thread-safe** and **optimized for configuration settings**.

2️⃣ **Can Properties store integers or other data types?**  
   - No, but you can **convert them manually** using `Integer.parseInt(props.getProperty("key"))`.

3️⃣ **Can Properties store multiple sections like INI files?**  
   - No, but you can use **different property files** for different sections.

---

🚀 **Happy Coding!** 🎯