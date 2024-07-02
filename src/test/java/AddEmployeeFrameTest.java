import com.mycompany.OOP.EmployeeVerification.AddEmployeeFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Method;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AddEmployeeFrameTest {

    private AddEmployeeFrame addEmployeeFrame;

    @BeforeEach
    public void setUp() {
        addEmployeeFrame = new MockAddEmployeeFrame();
    }

    @Test
    public void testAddEmployeeWithValidInput() throws Exception {
        // Set valid input using reflection
        setInputText(addEmployeeFrame, "employeenumbertf", "123456");
        setInputText(addEmployeeFrame, "lastnametf", "Doe");
        setInputText(addEmployeeFrame, "firstnametf", "John");
        setInputText(addEmployeeFrame, "birthdaytf", "1990-01-01");
        setInputText(addEmployeeFrame, "addresstf", "123 Main St");
        setInputText(addEmployeeFrame, "phonenumtf", "5551234567");
        setInputText(addEmployeeFrame, "sssnumtf", "SSS123");
        setInputText(addEmployeeFrame, "phnumtf", "PH123");
        setInputText(addEmployeeFrame, "tinnumtf", "TIN123");
        setInputText(addEmployeeFrame, "pagibigtf", "PGB123");
        setInputText(addEmployeeFrame, "statustf", "Single");
        setInputText(addEmployeeFrame, "positiontf", "Developer");
        setInputText(addEmployeeFrame, "supervisortf", "Jane Doe");
        setInputText(addEmployeeFrame, "basicsalarytf", "30000");
        setInputText(addEmployeeFrame, "ricetf", "2000");
        setInputText(addEmployeeFrame, "phonetf", "1000");
        setInputText(addEmployeeFrame, "clothingtf", "500");
        setInputText(addEmployeeFrame, "smratetf", "15000");
        setInputText(addEmployeeFrame, "hourlyratetf", "200");

        // Simulate button click using reflection
        Method addEmployeeMethod = AddEmployeeFrame.class.getDeclaredMethod("AddEmployee", java.awt.event.MouseEvent.class);
        addEmployeeMethod.setAccessible(true);
        addEmployeeMethod.invoke(addEmployeeFrame, (java.awt.event.MouseEvent) null);

        // Verify the form is cleared after successful addition
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "employeenumbertf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "lastnametf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "firstnametf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "birthdaytf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "addresstf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "phonenumtf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "sssnumtf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "phnumtf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "tinnumtf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "pagibigtf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "statustf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "positiontf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "supervisortf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "basicsalarytf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "ricetf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "phonetf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "clothingtf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "smratetf"));
        assertTrue(isTextFieldEmpty(addEmployeeFrame, "hourlyratetf"));
    }

    @Test
    public void testAddEmployeeWithInvalidInput() throws Exception {
        // Set invalid input (name fields contain numbers) using reflection
        setInputText(addEmployeeFrame, "employeenumbertf", "12345");
        setInputText(addEmployeeFrame, "lastnametf", "Doe123");
        setInputText(addEmployeeFrame, "firstnametf", "John456");

        // Simulate button click using reflection
        Method addEmployeeMethod = AddEmployeeFrame.class.getDeclaredMethod("AddEmployee", java.awt.event.MouseEvent.class);
        addEmployeeMethod.setAccessible(true);
        addEmployeeMethod.invoke(addEmployeeFrame, (java.awt.event.MouseEvent) null);

        // Verify that the fields are not cleared
        assertFalse(isTextFieldEmpty(addEmployeeFrame, "employeenumbertf"));
        assertFalse(isTextFieldEmpty(addEmployeeFrame, "lastnametf"));
        assertFalse(isTextFieldEmpty(addEmployeeFrame, "firstnametf"));
    }

    private void setInputText(AddEmployeeFrame frame, String fieldName, String text) throws Exception {
        java.lang.reflect.Field field = AddEmployeeFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        textField.setText(text);
    }

    private boolean isTextFieldEmpty(AddEmployeeFrame frame, String fieldName) throws Exception {
        java.lang.reflect.Field field = AddEmployeeFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        return textField.getText().isEmpty();
    }

    // Mock class to override database interaction methods
    private static class MockAddEmployeeFrame extends AddEmployeeFrame {
        protected void addEmployeeToDatabase(String employeeNumber, String lastName, String firstName, String birthday, String address, String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status, String position, String supervisor, String basicSalary, String riceSubsidy, String phoneAllowance, String clothingAllowance, String semiMonthlyRate, String hourlyRate) throws SQLException {
            // Mock behavior: Do nothing, simulate successful addition
        }

        protected boolean isEmployeeNumberUnique(String employeeNumber) throws SQLException {
            // Mock behavior: Always return true
            return true;
        }
    }
}
