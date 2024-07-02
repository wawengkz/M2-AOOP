/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Frames.MainFrame;
import com.mycompany.OOP.EmployeeVerification.Employees;
import com.mycompany.OOP.PayrollCalculation.PayslipFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class PayslipFrameTest {

    private PayslipFrame payslipFrame;
    private Employees testEmployee;
    private MainFrame mainFrame;

    @BeforeEach
    public void setUp() throws IOException, SQLException, FileNotFoundException {
        testEmployee = new Employees();
        testEmployee.setemployeenum("1");
        testEmployee.setlastname("Doe");
        testEmployee.setfirstname("John");
        testEmployee.setbirthday("1990-01-01");
        testEmployee.setaddress("123 Main St");
        testEmployee.setphonenum("555-5555");
        testEmployee.setsssnum("SSS123456");
        testEmployee.setphnum("PH123456");
        testEmployee.settin("TIN123456");
        testEmployee.setpgbnum("PGB123456");
        testEmployee.setstatus("Single");
        testEmployee.setposition("Developer");
        testEmployee.setsupervisor("Jane Smith");
        testEmployee.setbasic("50000");
        testEmployee.setriceall("2000");
        testEmployee.setphoneall("1000");
        testEmployee.setclotheall("1500");
        testEmployee.setsmrate("25000");
        testEmployee.sethourlyrate("200");

       
        payslipFrame = new PayslipFrame(testEmployee, mainFrame);
    }

    @Test
    public void testLoadEmployeeData() throws Exception {
        Method loadEmployeeDataMethod = PayslipFrame.class.getDeclaredMethod("loadEmployeeData", Employees.class);
        loadEmployeeDataMethod.setAccessible(true);
        loadEmployeeDataMethod.invoke(payslipFrame, testEmployee);

        assertEquals("1", getTextFieldValue(payslipFrame, "employeeNumberTF"));
        assertEquals("John", getTextFieldValue(payslipFrame, "firstNameTF"));
        assertEquals("Doe", getTextFieldValue(payslipFrame, "lastNameTF"));
        assertEquals("1990-01-01", getTextFieldValue(payslipFrame, "birthdayTF"));
        assertEquals("123 Main St", getTextFieldValue(payslipFrame, "adressTF"));
        assertEquals("555-5555", getTextFieldValue(payslipFrame, "phoneNumberTF"));
        assertEquals("SSS123456", getTextFieldValue(payslipFrame, "sssTF"));
        assertEquals("PH123456", getTextFieldValue(payslipFrame, "phNumTF"));
        assertEquals("TIN123456", getTextFieldValue(payslipFrame, "tinNumTF"));
        assertEquals("PGB123456", getTextFieldValue(payslipFrame, "pagibigTF"));
        assertEquals("Single", getTextFieldValue(payslipFrame, "statusTF"));
        assertEquals("Developer", getTextFieldValue(payslipFrame, "positionTF"));
        assertEquals("Jane Smith", getTextFieldValue(payslipFrame, "supervisorTF"));
        assertEquals("50000", getTextFieldValue(payslipFrame, "basicSalaryTF"));
        assertEquals("2000", getTextFieldValue(payslipFrame, "riceTF"));
        assertEquals("1000", getTextFieldValue(payslipFrame, "phoneTF"));
        assertEquals("1500", getTextFieldValue(payslipFrame, "clothingTF"));
        assertEquals("25000", getTextFieldValue(payslipFrame, "semRateTF"));
        assertEquals("200", getTextFieldValue(payslipFrame, "hourlyRateTF"));
    }

    @Test
    public void testCalculatePayslip() throws Exception {
        Method showpaybtnMouseClickedMethod = PayslipFrame.class.getDeclaredMethod("showpaybtnMouseClicked", java.awt.event.MouseEvent.class);
        showpaybtnMouseClickedMethod.setAccessible(true);

        // Set the date range
        setComboBoxValue(payslipFrame, "y1cb", "2024");
        setComboBoxValue(payslipFrame, "m1cb", "1");
        setComboBoxValue(payslipFrame, "d1cb", "1");
        setComboBoxValue(payslipFrame, "y2cb", "2024");
        setComboBoxValue(payslipFrame, "m2cb", "1");
        setComboBoxValue(payslipFrame, "d2cb", "31");

        showpaybtnMouseClickedMethod.invoke(payslipFrame, (java.awt.event.MouseEvent) null);

        assertNotNull(getTextFieldValue(payslipFrame, "salperiodtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "salearnedtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "riceallowtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "phoneallowtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "clothingallowtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "grosstf"));
        assertNotNull(getTextFieldValue(payslipFrame, "ssstf"));
        assertNotNull(getTextFieldValue(payslipFrame, "phtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "pgbtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "taxtf"));
        assertNotNull(getTextFieldValue(payslipFrame, "tdeducttf"));
        assertNotNull(getTextFieldValue(payslipFrame, "nettf"));
    }

    private String getTextFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(obj);
        return textField.getText();
    }

    private void setComboBoxValue(Object obj, String fieldName, String value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        JComboBox<String> comboBox = (JComboBox<String>) field.get(obj);
        comboBox.setSelectedItem(value);
    }
}
