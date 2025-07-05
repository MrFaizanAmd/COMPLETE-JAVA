# Batch Processing in JDBC

## Overview
Batch processing in JDBC allows executing multiple SQL statements in a batch to improve performance. Instead of executing queries one by one, we can group multiple SQL operations and send them to the database in a single request. This reduces network round trips and enhances efficiency.

## Benefits of Batch Processing
- **Performance Improvement:** Reduces the number of database calls, making execution faster.
- **Efficient Resource Usage:** Minimizes overhead by reducing network latency.
- **Atomicity:** Helps execute multiple statements as a single unit, ensuring consistency.

## Steps to Perform Batch Processing in JDBC

### 1. Load and Register Driver
Ensure that the JDBC driver is loaded.
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### 2. Establish a Database Connection
```java
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
```

### 3. Disable Auto-Commit Mode (Optional)
```java
connection.setAutoCommit(false);
```

### 4. Create a Statement Object
```java
Statement statement = connection.createStatement();
```

### 5. Add Queries to the Batch
```java
statement.addBatch("INSERT INTO employees (id, name, salary) VALUES (1, 'John Doe', 50000)");
statement.addBatch("INSERT INTO employees (id, name, salary) VALUES (2, 'Jane Smith', 60000)");
statement.addBatch("UPDATE employees SET salary = 70000 WHERE id = 1");
```

### 6. Execute the Batch
```java
int[] result = statement.executeBatch();
```

### 7. Commit the Transaction (If Auto-Commit is Disabled)
```java
connection.commit();
```

### 8. Close the Resources
```java
statement.close();
connection.close();
```

## Using PreparedStatement for Batch Processing
Using `PreparedStatement` is recommended as it enhances performance and security by preventing SQL injection.

```java
String sql = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
PreparedStatement preparedStatement = connection.prepareStatement(sql);

preparedStatement.setInt(1, 3);
preparedStatement.setString(2, "Alice Brown");
preparedStatement.setDouble(3, 55000);
preparedStatement.addBatch();

preparedStatement.setInt(1, 4);
preparedStatement.setString(2, "Bob White");
preparedStatement.setDouble(3, 65000);
preparedStatement.addBatch();

int[] result = preparedStatement.executeBatch();
connection.commit();

preparedStatement.close();
connection.close();
```

## Error Handling in Batch Processing
- Use `try-catch` to handle exceptions.
- Rollback in case of failures:
```java
try {
    connection.setAutoCommit(false);
    
    // Add batch statements
    statement.addBatch("SQL_QUERY");
    
    statement.executeBatch();
    connection.commit();
} catch (SQLException e) {
    connection.rollback(); // Rollback changes in case of failure
    e.printStackTrace();
} finally {
    statement.close();
    connection.close();
}
```

## Conclusion
Batch processing in JDBC significantly improves performance when dealing with multiple SQL statements. Using `PreparedStatement` for batch processing is recommended for security and efficiency. Always handle exceptions and rollback transactions to maintain data integrity.

