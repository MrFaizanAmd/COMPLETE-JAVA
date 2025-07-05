# JDBC Program Flow - Step by Step Guide

JDBC (Java Database Connectivity) follows a structured process to connect a Java application to a relational database, execute queries, and retrieve data. Below is a step-by-step breakdown of the JDBC program flow.

---

## **1. Load the JDBC Driver**
Before establishing a connection, the appropriate JDBC driver must be loaded into memory.

### **Example:**
```java
// Load MySQL JDBC Driver
Class.forName("com.mysql.cj.jdbc.Driver");
```
This step ensures that Java recognizes and registers the JDBC driver required for database communication.

💡 **Note:** For modern JDBC versions (Java 6+), explicit loading is not required if the driver is included in the classpath.

---

## **2. Establish a Connection**
A connection to the database is required to send SQL queries.

### **Example:**
```java
// Database URL
String url = "jdbc:mysql://localhost:3306/mydatabase";
String username = "root";
String password = "password";

// Establish connection
Connection con = DriverManager.getConnection(url, username, password);
```

💡 **Tip:** Always check if the database URL and credentials are correct.

---

## **3. Create a Statement**
A `Statement` or `PreparedStatement` is used to execute SQL queries.

### **Example using Statement:**
```java
Statement stmt = con.createStatement();
```

### **Example using PreparedStatement (Preferred for Security):**
```java
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ?");
pstmt.setInt(1, 101); // Set value for parameter
```

💡 **Why use PreparedStatement?** It prevents SQL injection and improves query performance.

---

## **4. Execute the Query**
After preparing the statement, execute the query to retrieve or manipulate data.

### **For SELECT Queries (Retrieving Data):**
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

### **For INSERT/UPDATE/DELETE Queries (Modifying Data):**
```java
int rowsAffected = stmt.executeUpdate("INSERT INTO users (name, age) VALUES ('John Doe', 30)");
System.out.println("Rows inserted: " + rowsAffected);
```

💡 **Tip:** Use `executeQuery()` for SELECT statements and `executeUpdate()` for INSERT, UPDATE, DELETE operations.

---

## **5. Process the Results**
If a SELECT query is executed, results are returned as a `ResultSet`.

### **Example:**
```java
while (rs.next()) {
    System.out.println("User ID: " + rs.getInt("id"));
    System.out.println("Name: " + rs.getString("name"));
}
```

💡 **Key Methods in ResultSet:**
- `next()` – Moves the cursor to the next row.
- `getInt(columnName)` – Retrieves an integer value.
- `getString(columnName)` – Retrieves a string value.

---

## **6. Close Resources**
To prevent memory leaks, always close database connections and statements after use.

### **Example:**
```java
rs.close();
stmt.close();
con.close();
```

💡 **Tip:** Use try-with-resources to automatically close resources.
```java
try (Connection con = DriverManager.getConnection(url, username, password);
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
    
    while (rs.next()) {
        System.out.println("User: " + rs.getString("name"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
```

---

## **Complete JDBC Program Example**
```java
import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load JDBC Driver (Optional for Java 6+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Step 5: Process Results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }

            // Step 6: Close Resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## **Summary of JDBC Steps**
| Step | Action |
|------|--------|
| 1 | Load JDBC Driver |
| 2 | Establish a Connection |
| 3 | Create a Statement |
| 4 | Execute the Query |
| 5 | Process the Results |
| 6 | Close the Resources |

This step-by-step guide provides a clear understanding of how JDBC works in Java applications. Keep practicing, and happy coding! 🚀

---

### **Frequently Asked Questions (FAQs)**

#### 1. Do I always need to load the JDBC driver manually?
For JDBC 4.0 and later (Java 6+), the driver is auto-loaded when included in the classpath.

#### 2. What happens if I forget to close the connection?
Forgetting to close the connection can cause memory leaks and connection exhaustion.

#### 3. Can JDBC work with NoSQL databases?
No, JDBC is designed for relational databases. For NoSQL databases, use their respective Java drivers.

#### 4. What is the difference between executeQuery and executeUpdate?
- `executeQuery()` is used for SELECT statements.
- `executeUpdate()` is used for INSERT, UPDATE, DELETE operations.

---

## **Hands-on Practice**
For hands-on practice, check out the example programs in the [JDBC Practice Files](./practice/) folder of this repository!

Happy Learning! 🎯

