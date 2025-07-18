# CRUD Operations Using Statement in JDBC

## Introduction
Performing **CRUD (Create, Read, Update, Delete)** operations is an essential part of interacting with a database. In JDBC, we use the `Statement` interface to execute SQL queries. This guide explains each step of CRUD operations with proper **exception handling**.

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
## Understanding the `Statement` Interface
### What is `Statement`?
The `Statement` interface in JDBC is used to execute static SQL queries. It allows interaction with the database by sending SQL commands and processing results.

### Key Methods of `Statement`
- `executeQuery(String sql)`: Used for retrieving data (`SELECT` statements) and returns a `ResultSet`.
- `executeUpdate(String sql)`: Used for modifying data (`INSERT`, `UPDATE`, `DELETE`), returning the number of affected rows.
- `execute(String sql)`: Used for general SQL execution that returns multiple results.
- `close()`: Closes the statement and releases resources.

### Limitations of `Statement`
- **SQL Injection Risk**: Using plain `Statement` objects with user input can lead to SQL injection vulnerabilities.
- **Performance Issues**: SQL queries are compiled each time, which is inefficient compared to `PreparedStatement`.

For dynamic queries, consider using `PreparedStatement` for security and efficiency.

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

#### 📝 Breakdown of Steps:
1️⃣ **Import necessary JDBC classes** (`Connection`, `DriverManager`, `SQLException`).
2️⃣ **Define database URL, username, and password**.
3️⃣ **Use `DriverManager.getConnection()`** to establish a connection.
4️⃣ **Handle exceptions** using a `try-catch` block to print error details.

---
## CRUD Operations Using Statement

### Step 4: Insert Data (CREATE Operation)

#### 🔹 Code for Inserting Data
```java
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO Employees (name, age, department) VALUES ('John Doe', 30, 'IT')";
            int rowsInserted = stmt.executeUpdate(sql);
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

#### 📝 Breakdown of Steps:
1️⃣ **Establish a connection** using `DBConnection.getConnection()`.
2️⃣ **Create a `Statement` object** using `createStatement()`.
3️⃣ **Define the SQL `INSERT` query**.
4️⃣ **Execute the query** using `executeUpdate()` and check affected rows.
5️⃣ **Handle exceptions** using `try-catch`.

---
### Step 5: Retrieve Data (READ Operation)

#### 🔹 Code for Retrieving Data
```java
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
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

#### 📝 Breakdown of Steps:
1️⃣ **Establish a connection** using `DBConnection.getConnection()`.
2️⃣ **Create a `Statement` object**.
3️⃣ **Execute a `SELECT` query** using `executeQuery()`.
4️⃣ **Iterate through `ResultSet`** to print employee details.
5️⃣ **Handle exceptions** using `try-catch`.

---
### Step 6: Update Data (UPDATE Operation)

#### 🔹 Code for Updating Data
```java
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE Employees SET age = 35 WHERE name = 'John Doe'";
            int rowsUpdated = stmt.executeUpdate(sql);
            if (rowsUpdated > 0) {
                System.out.println("An existing employee record was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

#### 📝 Breakdown of Steps:
1️⃣ **Establish a connection**.
2️⃣ **Create a `Statement` object**.
3️⃣ **Define the SQL `UPDATE` query**.
4️⃣ **Execute the update operation** using `executeUpdate()`.
5️⃣ **Handle exceptions** using `try-catch`.

---
### Step 7: Delete Data (DELETE Operation)

#### 🔹 Code for Deleting Data
```java
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM Employees WHERE name = 'John Doe'";
            int rowsDeleted = stmt.executeUpdate(sql);
            if (rowsDeleted > 0) {
                System.out.println("An employee record was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

#### 📝 Breakdown of Steps:
1️⃣ **Establish a connection**.
2️⃣ **Create a `Statement` object**.
3️⃣ **Define the SQL `DELETE` query**.
4️⃣ **Execute the deletion operation**.
5️⃣ **Handle exceptions** using `try-catch`.

---
## Exception Handling in JDBC
While working with databases, errors can occur. Here are some common exceptions and how to handle them:

### 1️⃣ **SQLException** – Occurs when there is an issue with the SQL syntax or connection.
- **Solution**: Print the error message using `e.getMessage()` and ensure the query is correct.

### 2️⃣ **ClassNotFoundException** – Happens if the JDBC driver is missing.
- **Solution**: Ensure the JDBC driver JAR file is correctly added to the classpath.

### 3️⃣ **Connection Issues** – The database may not be reachable.
- **Solution**: Verify database credentials, URL, and check if the database service is running.

---
## Frequently Asked Questions (FAQs)

### ❓ Can I use `PreparedStatement` instead of `Statement`?
Yes! `PreparedStatement` is preferred for dynamic queries and prevents SQL injection.

### ❓ Why is `executeUpdate()` used for INSERT, UPDATE, DELETE?
`executeUpdate()` returns the number of rows affected, while `executeQuery()` is used for `SELECT` operations.

### ❓ How can I avoid SQL injection with `Statement`?
By using **PreparedStatement**, as it safely binds parameters without allowing malicious SQL code injection.

---
## Additional Resources
- [Official JDBC Documentation](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
- [MySQL JDBC Connector](https://dev.mysql.com/downloads/connector/j/)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/)

---
This guide provides a **step-by-step breakdown** of CRUD operations using `Statement` in JDBC with proper exception handling. Happy coding! 🚀

