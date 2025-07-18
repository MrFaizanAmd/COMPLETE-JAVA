# CRUD Operations Using PreparedStatement in JDBC

## Introduction
Performing **CRUD (Create, Read, Update, Delete)** operations efficiently and securely is crucial when interacting with a database. The `PreparedStatement` interface in JDBC is an enhanced alternative to `Statement`, offering **better performance** and **protection against SQL injection**. This guide covers CRUD operations using `PreparedStatement` with proper **exception handling**.

---
## Prerequisites
Before proceeding, ensure you have:
- Java installed (`JDK 8+` recommended)
- A relational database (e.g., MySQL, PostgreSQL, Oracle)
- JDBC driver for your database
- Basic knowledge of SQL queries

---
## Setting Up Database and Table
Before we begin, let's create a simple database and table for demonstration purposes.

### Step 1: Create Database (MySQL Example)
```sql
CREATE DATABASE EmployeeDB;
USE EmployeeDB;
```

### Step 2: Create Table
```sql
CREATE TABLE Employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    department VARCHAR(50)
);
```

---
## Understanding the `PreparedStatement` Interface
### What is `PreparedStatement`?
`PreparedStatement` is a JDBC interface that allows **precompiled** SQL statements to be executed efficiently. It provides better performance and prevents SQL injection by **binding parameters securely**.

### Key Methods of `PreparedStatement`
- `setInt(int parameterIndex, int value)`: Sets an integer value in the SQL statement.
- `setString(int parameterIndex, String value)`: Sets a string value.
- `executeQuery()`: Used for retrieving data (`SELECT` statements), returning a `ResultSet`.
- `executeUpdate()`: Used for modifying data (`INSERT`, `UPDATE`, `DELETE`), returning the number of affected rows.
- `close()`: Closes the statement and releases resources.

### Advantages Over `Statement`
- **Prevents SQL Injection**: Uses placeholders (`?`) to bind user input safely.
- **Performance Improvement**: Queries are precompiled, reducing execution time.
- **Code Maintainability**: Easier to handle dynamic queries.

---
## Establishing JDBC Connection
### Step 3: Create a Database Connection Class

#### 🔹 Code for Establishing Connection
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
```

---
## CRUD Operations Using PreparedStatement

### Step 4: Insert Data (CREATE Operation)

#### 🔹 Code for Inserting Data
```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            String sql = "INSERT INTO Employees (name, age, department) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "John Doe");
            pstmt.setInt(2, 30);
            pstmt.setString(3, "IT");
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
### **Complete Flow Summary in Simple Terms**  

1️⃣ **Import necessary JDBC packages**  
   - These help Java interact with the database.  

2️⃣ **Connect to the database**  
   - Calls `DBConnection.getConnection()` to establish a connection.  

3️⃣ **Prepare an SQL `INSERT` statement**  
   - Uses placeholders (`?`) instead of direct values for security.  

4️⃣ **Create a `PreparedStatement` object**  
   - Prepares the SQL query for execution.  

5️⃣ **Set actual values for placeholders**  
   - Replaces `?` with real data (e.g., `"John Doe"`, `30`, `"IT"`).  

6️⃣ **Execute the query**  
   - Runs `executeUpdate()`, which inserts data into the database.  

7️⃣ **Check if the data was inserted**  
   - If `rowsInserted > 0`, prints a success message.  

8️⃣ **Handle exceptions**  
   - If an error occurs, `catch (SQLException e)` prints the error.  

This method ensures **security, efficiency, and easy maintenance** for inserting data into the database. 🚀

---
### Step 5: Retrieve Data (READ Operation)

#### 🔹 Code for Retrieving Data
```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM Employees";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") + ", Department: " + rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
### **Step-by-Step Breakdown of the Code (READ Operation)**  

1️⃣ **Import necessary JDBC packages**  
   - `Connection`, `PreparedStatement`, `ResultSet`, and `SQLException` are imported to work with the database.  

2️⃣ **Establish a database connection**  
   - Calls `DBConnection.getConnection()` to get a connection object.  

3️⃣ **Define an SQL `SELECT` statement**  
   - The query `"SELECT * FROM Employees"` retrieves all rows from the `Employees` table.  

4️⃣ **Create a `PreparedStatement` object**  
   - Prepares the SQL query for execution, avoiding SQL injection risks.  

5️⃣ **Execute the query**  
   - Calls `executeQuery()`, which returns a `ResultSet` containing the retrieved records.  

6️⃣ **Process the results**  
   - Uses a `while (rs.next())` loop to iterate through the `ResultSet`.  
   - Extracts data using `rs.getInt("id")`, `rs.getString("name")`, etc.  
   - Prints each employee's details in a structured format.  

7️⃣ **Handle exceptions**  
   - If an error occurs, `catch (SQLException e)` captures and prints the exception.  

### **Complete Flow Summary**  
This code **retrieves** all employee records from the database, processes them row by row, and prints the details in the console. It ensures **security, efficiency, and maintainability** while fetching data. 🚀
---
### Step 6: Update Data (UPDATE Operation)

#### 🔹 Code for Updating Data
```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            String sql = "UPDATE Employees SET age = ? WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 35);
            pstmt.setString(2, "John Doe");
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing employee record was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
### **Step-by-Step Breakdown of the Code (UPDATE Operation)**  

1️⃣ **Import necessary JDBC packages**  
   - `Connection`, `PreparedStatement`, and `SQLException` are imported to handle the database update operation.  

2️⃣ **Establish a database connection**  
   - Calls `DBConnection.getConnection()` to obtain a connection object for interacting with the database.  

3️⃣ **Define an SQL `UPDATE` statement**  
   - The SQL query `"UPDATE Employees SET age = ? WHERE name = ?"` is used to update the `age` field for a specific employee based on their `name`.  

4️⃣ **Create a `PreparedStatement` object**  
   - `con.prepareStatement(sql)` prepares the SQL query to avoid SQL injection and improve efficiency.  

5️⃣ **Set values for placeholders (`?`)**  
   - `pstmt.setInt(1, 35);` → Sets the new age value to `35`.  
   - `pstmt.setString(2, "John Doe");` → Specifies that the update should be applied to the employee whose name is `"John Doe"`.  

6️⃣ **Execute the update query**  
   - Calls `pstmt.executeUpdate()`, which returns the number of affected rows.  

7️⃣ **Check if the update was successful**  
   - If `rowsUpdated > 0`, it means at least one row was updated, so a success message is printed.  

8️⃣ **Handle exceptions**  
   - If an SQL error occurs, `catch (SQLException e)` captures and prints the exception.  

### **Complete Flow Summary**  
This code **updates** an employee's age in the database where the name matches `"John Doe"`. It ensures **secure and efficient** modification of records. 🚀
---
### Step 7: Delete Data (DELETE Operation)

#### 🔹 Code for Deleting Data
```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            String sql = "DELETE FROM Employees WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "John Doe");
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An employee record was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
### **Step-by-Step Breakdown of the Code (DELETE Operation)**  

1️⃣ **Import necessary JDBC packages**  
   - `Connection`, `PreparedStatement`, and `SQLException` are imported to handle the database deletion operation.  

2️⃣ **Establish a database connection**  
   - Calls `DBConnection.getConnection()` to obtain a connection object for interacting with the database.  

3️⃣ **Define an SQL `DELETE` statement**  
   - The SQL query `"DELETE FROM Employees WHERE name = ?"` is used to delete a specific employee record based on the `name`.  

4️⃣ **Create a `PreparedStatement` object**  
   - `con.prepareStatement(sql)` prepares the SQL query to avoid SQL injection and improve efficiency.  

5️⃣ **Set the placeholder (`?`) value**  
   - `pstmt.setString(1, "John Doe");` → Specifies that the deletion should apply to the employee whose name is `"John Doe"`.  

6️⃣ **Execute the delete query**  
   - Calls `pstmt.executeUpdate()`, which returns the number of affected rows.  

7️⃣ **Check if the deletion was successful**  
   - If `rowsDeleted > 0`, it means at least one row was deleted, so a success message is printed.  

8️⃣ **Handle exceptions**  
   - If an SQL error occurs, `catch (SQLException e)` captures and prints the exception.  

### **Complete Flow Summary**  
This code **deletes** an employee's record from the database where the name matches `"John Doe"`. It ensures **secure and efficient** removal of records. 🚀
---
## Exception Handling in JDBC
### Common Exceptions & Solutions
- **SQLException**: Ensure SQL syntax is correct and database connectivity is stable.
- **ClassNotFoundException**: Ensure the JDBC driver is added to the classpath.
- **Connection Issues**: Verify database credentials and check if the database service is running.

---
## Frequently Asked Questions (FAQs)
### ❓ Why use `PreparedStatement` instead of `Statement`?
`PreparedStatement` prevents SQL injection and improves performance by precompiling SQL queries.

### ❓ When should I use `executeUpdate()` vs. `executeQuery()`?
- Use `executeUpdate()` for **INSERT, UPDATE, DELETE**.
- Use `executeQuery()` for **SELECT**.

### ❓ How does `PreparedStatement` prevent SQL injection?
It binds parameters safely instead of concatenating strings, preventing malicious SQL execution.

---
## Additional Resources
- [Official JDBC Documentation](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
- [MySQL JDBC Connector](https://dev.mysql.com/downloads/connector/j/)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/)

---
This guide covers **secure and efficient CRUD operations** using `PreparedStatement` in JDBC. Happy coding! 🚀

