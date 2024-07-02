package com.mycompany.OOP.UserManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogIn {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] pw) {
        this.password = new String(pw);
    }

    public String getUsername() {
        return username;
    }

    public boolean isAuthenticated() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payrollsystem_db";
        String dbUsername = "root";
        String dbPassword = "Tr1n1d4D10#";
        boolean isAuthenticated = false;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // Prepare the SQL statement
            String sql = "SELECT password FROM admin_login WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a record was found and if the password matches
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                isAuthenticated = storedPassword.equals(password);
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Authentication failed due to database error.", e);
        }

        return isAuthenticated;
    
    }

    void setusername(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setpassword(char[] password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static class EmployeeLogIn {
        private String username;
        private String password;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(char[] pw) {
            this.password = new String(pw);
        }

        public String getUsername() {
            return username;
        }

        public boolean isAuthenticated() throws SQLException {
            String jdbcUrl = "jdbc:mysql://localhost:3306/payrollsystem_db";
            String dbUsername = "root";
            String dbPassword = "Tr1n1d4D10#";
            boolean isAuthenticated = false;

            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection
                Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

                // Prepare the SQL statement
                String sql = "SELECT password FROM employee_login WHERE username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if a record was found and if the password matches
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    isAuthenticated = storedPassword.equals(password);
                }

                // Close the resources
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new SQLException("Authentication failed due to database error.", e);
            }

            return isAuthenticated;
        }
    }
}
