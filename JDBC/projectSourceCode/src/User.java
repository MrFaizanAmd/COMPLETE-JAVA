

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    Scanner sc;
    Connection con;
    User(Connection con,Scanner sc){
        this.con=con;
        this.sc=sc;
    }
    public void register(){
        sc.nextLine();
        System.out.print("Full Name: ");
        String full_name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        if(user_exists(email)){
            System.out.println("user already exists");
            return;
        }
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        String register_query = "INSERT INTO User(full_name, email, password) VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(register_query);
            preparedStatement.setString(1, full_name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registration Successfull!");
            } else {
                System.out.println("Registration Failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean user_exists(String email){
        String login_query="SELECT email FROM User WHERE email =?" ;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(login_query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
           return resultSet.next();
         } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
         }

         return false;
    
    }
     public String login() {
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        String login_query="SELECT * FROM user WHERE email =? AND password =?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(login_query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return email;
            }else{
                return null;
            }
         } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
         }

         return null;

     }
}
