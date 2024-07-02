package com.mycompany.OOP.EmployeeVerification;

import com.mycompany.oopmotorph.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Employee1 {
    private String employeenum;
    private String lastname;
    private String firstname;
    private String birthday;
    private String address;
    private String phonenum;
    private String sssnum;
    private String phnum;
    private String tin;
    private String pgbnum;
    private String status;
    private String position;
    private String supervisor;
    private String basicsalary; // This is the monthly rate
    private String riceall;
    private String phoneall;
    private String clotheall;
    private String smrate; // This is the gross income
    private String hourlyrate;
      
    public String getEmployeeNum() {
        return employeenum;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    // Setters for each field...

    public void addEmployee() throws SQLException {
        String employeeInsertQuery = "INSERT INTO employees (employee_id, last_name, first_name, birth_date, address, contact_number, sss_number, philhealth_number, tin_number, pagibig_number, status, position, supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String payslipInsertQuery = "INSERT INTO Payslip (Employee_ID, MonthlyRate, GrossIncome, RiceSubsidy, PhoneAllowance, ClothingAllowance, hourlyRate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtility.getConnection()) {
            // Check if employee number already exists
            String checkEmployeeQuery = "SELECT COUNT(*) FROM employees WHERE employee_id = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkEmployeeQuery)) {
                checkStmt.setInt(1, Integer.parseInt(employeenum));
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        throw new SQLException("Employee number already exists.");
                    }
                }
            }

            // Insert into employees table
            try (PreparedStatement employeeStmt = connection.prepareStatement(employeeInsertQuery)) {
                employeeStmt.setInt(1, Integer.parseInt(employeenum));
                employeeStmt.setString(2, lastname);
                employeeStmt.setString(3, firstname);
                employeeStmt.setString(4, birthday);
                employeeStmt.setString(5, address);
                employeeStmt.setString(6, phonenum);
                employeeStmt.setString(7, sssnum);
                employeeStmt.setString(8, phnum);
                employeeStmt.setString(9, tin);
                employeeStmt.setString(10, pgbnum);
                employeeStmt.setString(11, status);
                employeeStmt.setString(12, position);
                employeeStmt.setString(13, supervisor);
                employeeStmt.executeUpdate();
            }

            // Insert into payslip table
            try (PreparedStatement payslipStmt = connection.prepareStatement(payslipInsertQuery)) {
                payslipStmt.setInt(1, Integer.parseInt(employeenum));
                payslipStmt.setBigDecimal(2, new java.math.BigDecimal(basicsalary));
                payslipStmt.setBigDecimal(3, new java.math.BigDecimal(smrate));
                payslipStmt.setBigDecimal(4, new java.math.BigDecimal(riceall));
                payslipStmt.setBigDecimal(5, new java.math.BigDecimal(phoneall));
                payslipStmt.setBigDecimal(6, new java.math.BigDecimal(clotheall));
                payslipStmt.setBigDecimal(7, new java.math.BigDecimal(hourlyrate));
                payslipStmt.executeUpdate();
            }
        }
    }

    public DefaultTableModel getEmployeePayslipData() throws SQLException {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Employee No.", "Last Name", "First Name", "SSS", "Philhealth", "TIN", "PAGIBIG", "Monthly Rate", "Gross Income", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Hourly Rate"}, 0);

        String query = "SELECT * FROM employee_payslip_view";

        try (var connection = DatabaseUtility.getConnection();
             var stmt = connection.createStatement();
             var rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("employee_id"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("sss_number"),
                    rs.getString("philhealth_number"),
                    rs.getString("tin_number"),
                    rs.getString("pagibig_number"),
                    rs.getBigDecimal("MonthlyRate"),
                    rs.getBigDecimal("GrossIncome"),
                    rs.getBigDecimal("RiceSubsidy"),
                    rs.getBigDecimal("PhoneAllowance"),
                    rs.getBigDecimal("ClothingAllowance"),
                    rs.getBigDecimal("hourlyRate")
                });
            }
        }
        return model;
    }

    // Setters for each field...

    public void setemployeenum(String employeenum) {
        this.employeenum = employeenum;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setphonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public void setsssnum(String sssnum) {
        this.sssnum = sssnum;
    }

    public void setphnum(String phnum) {
        this.phnum = phnum;
    }

    public void settin(String tin) {
        this.tin = tin;
    }

    public void setpgbnum(String pgbnum) {
        this.pgbnum = pgbnum;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public void setsupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setbasic(String basicsalary) {
        this.basicsalary = basicsalary;
    }

    public void setriceall(String riceall) {
        this.riceall = riceall;
    }

    public void setphoneall(String phoneall) {
        this.phoneall = phoneall;
    }

    public void setclotheall(String clotheall) {
        this.clotheall = clotheall;
    }

    public void setsmrate(String smrate) {
        this.smrate = smrate;
    }

    public void sethourlyrate(String hourlyrate) {
        this.hourlyrate = hourlyrate;
    }
    
  
    // Setters
 public boolean fetchEmployeeDetails() throws SQLException {
        String query = "SELECT * FROM employee_leave WHERE employee_id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(employeenum));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.lastname = rs.getString("last_name");
                    this.firstname = rs.getString("first_name");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean LeaveIsAllowed(String leaveType, int days) throws SQLException {
        String query = "SELECT `" + leaveType.toLowerCase().replace(" ", "_") + "` FROM employee_leave WHERE employee_id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(employeenum));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int availableDays = rs.getInt(leaveType.toLowerCase().replace(" ", "_"));
                    return availableDays >= days;
                }
            }
        }
        return false;
    }

    public void ApplyLeave(String leaveType, int days) throws SQLException {
        String query = "UPDATE employee_leave SET `" + leaveType.toLowerCase().replace(" ", "_") + "` = `" + leaveType.toLowerCase().replace(" ", "_") + "` - ? WHERE employee_id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, days);
            stmt.setInt(2, Integer.parseInt(employeenum));
            stmt.executeUpdate();
        }
    }

  public void createLeaveApplication(String dateFiled, String leaveType, String days, String start, String end) throws SQLException {
    String query = "INSERT INTO leave_applications (employee_id, date_filed, leave_type, days, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection connection = DatabaseUtility.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, Integer.parseInt(employeenum));
        stmt.setDate(2, java.sql.Date.valueOf(dateFiled));
        stmt.setString(3, leaveType);
        stmt.setInt(4, Integer.parseInt(days));
        stmt.setDate(5, java.sql.Date.valueOf(start));
        stmt.setDate(6, java.sql.Date.valueOf(end));
        stmt.executeUpdate();
    }
}
}
