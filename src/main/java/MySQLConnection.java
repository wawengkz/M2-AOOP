import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payrollsystem_db";
        String username = "root";
        String password = "Tr1n1d4D10#";
        
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute a query
            String sql = "SELECT * FROM Employees;";
            ResultSet resultSet = statement.executeQuery(sql);
            
            // Process the result set
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("employee_id"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Birth Date: " + resultSet.getDate("birth_date"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("Contact Number: " + resultSet.getString("contact_number"));
                System.out.println("SSS Number: " + resultSet.getString("sss_number"));
                System.out.println("Philhealth Number: " + resultSet.getString("philhealth_number"));
                System.out.println("TIN Number: " + resultSet.getString("tin_number"));
                System.out.println("Pagibig Number: " + resultSet.getString("pagibig_number"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println("Position: " + resultSet.getString("position"));
                System.out.println("Supervisor: " + resultSet.getString("supervisor"));
                System.out.println("---------------------------------------");
            }
            
            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

