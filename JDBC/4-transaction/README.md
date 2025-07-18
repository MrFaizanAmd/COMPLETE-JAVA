# Transaction Handling in JDBC

## Overview
Transaction handling in JDBC allows executing multiple SQL operations as a single unit. Transactions ensure that either all the operations succeed or none of them are applied, maintaining data integrity and consistency.

## Key Concepts of Transactions
- **Atomicity:** Ensures that a transaction is either fully completed or fully rolled back.
- **Consistency:** Maintains the correctness of the database before and after the transaction.
- **Isolation:** Ensures that concurrent transactions do not interfere with each other.
- **Durability:** Guarantees that committed transactions persist even after a system failure.

## Steps to Handle Transactions in JDBC

### 1. Load and Register Driver
Ensure that the JDBC driver is loaded.
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### 2. Establish a Database Connection
```java
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
```

### 3. Disable Auto-Commit Mode
By default, JDBC runs in auto-commit mode. Disable it to manage transactions manually.
```java
connection.setAutoCommit(false);
```

### 4. Execute SQL Statements
Perform multiple SQL operations within the transaction.
```java
Statement statement = connection.createStatement();

statement.executeUpdate("INSERT INTO accounts (id, name, balance) VALUES (1, 'Alice', 1000)");
statement.executeUpdate("INSERT INTO accounts (id, name, balance) VALUES (2, 'Bob', 2000)");
```

### 5. Commit the Transaction
If all statements execute successfully, commit the transaction.
```java
connection.commit();
```

### 6. Rollback in Case of Failure
If any error occurs, roll back all changes.
```java
try {
    connection.setAutoCommit(false);
    
    statement.executeUpdate("UPDATE accounts SET balance = balance - 500 WHERE id = 1");
    statement.executeUpdate("UPDATE accounts SET balance = balance + 500 WHERE id = 2");
    
    connection.commit(); // Commit if successful
} catch (SQLException e) {
    connection.rollback(); // Rollback if an error occurs
    e.printStackTrace();
} finally {
    statement.close();
    connection.close();
}
```

## Using PreparedStatement for Transactions
Using `PreparedStatement` enhances performance and security.
```java
String sql = "UPDATE accounts SET balance = ? WHERE id = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);

try {
    connection.setAutoCommit(false);
    
    preparedStatement.setDouble(1, 1500);
    preparedStatement.setInt(2, 1);
    preparedStatement.executeUpdate();
    
    preparedStatement.setDouble(1, 2500);
    preparedStatement.setInt(2, 2);
    preparedStatement.executeUpdate();
    
    connection.commit();
} catch (SQLException e) {
    connection.rollback();
    e.printStackTrace();
} finally {
    preparedStatement.close();
    connection.close();
}
```

## Conclusion
Transaction handling in JDBC ensures data integrity and consistency when performing multiple operations. Always disable auto-commit, use `commit()` for successful transactions, and `rollback()` to revert changes in case of failure.

