package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;



public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/spring";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            // Afisare meniu pentru CRUD
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.print("Selectati CRUD ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Create
                    System.out.print("Introduceți email: ");
                    String email = scanner.next();
                    System.out.print("Introduceți parola: ");
                    String passwordInput = scanner.next();
                    createRecord(connection, email, passwordInput);
                    break;
                case 2: // Read
                    readRecords(connection);
                    break;
                case 3: // Update
                    System.out.print("Introduceți email-ul pentru actualizare: ");
                    String emailToUpdate = scanner.next();
                    System.out.print("Introduceți noua parolă: ");
                    String newPassword = scanner.next();
                    updateRecord(connection, emailToUpdate, newPassword);
                    break;
                case 4: // Delete
                    System.out.print("Introduceți email-ul pentru ștergere: ");
                    String emailToDelete = scanner.next();
                    deleteRecord(connection, emailToDelete);
                    break;
                default:
                    System.out.println("Opțiune nevalidă!");
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createRecord(Connection connection, String email, String password) {
        try {
            String insertQuery = "INSERT INTO test (email, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Înregistrarea a fost creată cu succes!");
            } else {
                System.out.println("Crearea înregistrării a eșuat.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void readRecords(Connection connection) {
        try {
            String selectQuery = "SELECT email, password FROM test";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                System.out.println("Email: " + email + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateRecord(Connection connection, String email, String newPassword) {
        try {
            String updateQuery = "UPDATE test SET password = '" + newPassword + "' WHERE email = '" + email + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateQuery);
            System.out.println("Înregistrarea a fost actualizată cu succes!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecord(Connection connection, String email) {
        try {
            String deleteQuery = "DELETE FROM test WHERE email = '" + email + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteQuery);
            System.out.println("Înregistrarea a fost ștearsă cu succes!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}