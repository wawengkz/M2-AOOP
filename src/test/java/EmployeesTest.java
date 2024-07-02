/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.OOP.EmployeeVerification.Employees;
import com.mycompany.oopmotorph.DatabaseUtility;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author Admin
 */
public class EmployeesTest {

    @Mock
    private DatabaseUtility mockDatabaseUtility;

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private Employees employee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employees("1", "John", "Doe", "1990-01-01", "Address",
                "123456789", "SSS123", "PH123", "TIN123", "PGB123", "Single",
                "Position", "Supervisor", "30000", "2000", "1000", "500", "20", "100");
    }




    @Test
    public void testComputeSalEarned() {
        float hoursWorked = 160;
        String salaryEarned = employee.computeSalEarned(hoursWorked);
        assertEquals("16000.00", salaryEarned);
    }

    @Test
    public void testComputeGross() {
        float hoursWorked = 160;
        String grossSalary = employee.computeGross(hoursWorked);
        assertNotNull(grossSalary);
    }

    @Test
    public void testComputeSSS() {
        String sssContribution = employee.computeSSS();
        assertNotNull(sssContribution);
    }

    @Test
    public void testComputePH() {
        String philHealthContribution = employee.computePH();
        assertNotNull(philHealthContribution);
    }

    @Test
    public void testComputePGB() {
        String pagibigContribution = employee.computePGB();
        assertNotNull(pagibigContribution);
    }

    @Test
    public void testComputeTax() {
        String tax = employee.computeTax();
        assertNotNull(tax);
    }

    @Test
    public void testComputeTotalDeduct() {
        String totalDeduction = employee.computeTotalDeduct();
        assertNotNull(totalDeduction);
    }

    @Test
    public void testComputeNet() {
        float hoursWorked = 160;
        String netSalary = employee.computeNet(hoursWorked);
        assertNotNull(netSalary);
    }

    @Test
    public void testApplyLeave() throws IOException, CsvValidationException {
        String filename = "test.csv";
        FileWriter fileWriter = new FileWriter(filename);
        CSVWriter writer = new CSVWriter(fileWriter);
        String[] header = {"Employee No.", "First Name", "Last Name", "Sick Leave", "Vacation Leave", "Emergency Leave"};
        String[] data = {"1", "John", "Doe", "10", "10", "10"};
        writer.writeNext(header);
        writer.writeNext(data);
        writer.close();

        employee.ApplyLeave(filename, "Sick Leave", "2");

        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] updatedData = reader.readNext(); // skip header
        updatedData = reader.readNext(); // read updated data
        assertEquals("8", updatedData[3]); // Sick Leave should be 8 now

        reader.close();
        new File(filename).delete();
    }

}
