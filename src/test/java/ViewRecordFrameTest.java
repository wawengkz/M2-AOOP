/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.OOP.EmployeeVerification.ViewRecordFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 *
 * @author Admin
 */
public class ViewRecordFrameTest {

    private ViewRecordFrame viewRecordFrame;

    @BeforeEach
    public void setUp() {
        viewRecordFrame = new ViewRecordFrame("12345");
    }


    @Test
    public void testUpdateRecord() throws Exception {
        // Set valid numeric values for fields that require it
        setInputText(viewRecordFrame, "employeenumbertf", "12345");
        setInputText(viewRecordFrame, "firstnametf", "John");
        setInputText(viewRecordFrame, "lastnametf", "Doe");
        setInputText(viewRecordFrame, "bdaytf", "1990-01-01");
        setInputText(viewRecordFrame, "addresstf", "123 Street");
        setInputText(viewRecordFrame, "phonenumtf", "1234567890");
        setInputText(viewRecordFrame, "sssnumtf", "SSS12345");
        setInputText(viewRecordFrame, "phnumtf", "PH12345");
        setInputText(viewRecordFrame, "tinnumtf", "TIN12345");
        setInputText(viewRecordFrame, "pagibigtf", "PAGIBIG12345");
        setInputText(viewRecordFrame, "statustf", "Single");
        setInputText(viewRecordFrame, "positiontf", "Employee");
        setInputText(viewRecordFrame, "supervisortf", "Supervisor");
        setInputText(viewRecordFrame, "basicsalarytf", "30000.00");
        setInputText(viewRecordFrame, "ricetf", "1000.00");
        setInputText(viewRecordFrame, "phonetf", "500.00");
        setInputText(viewRecordFrame, "clothingtf", "200.00");
        setInputText(viewRecordFrame, "semratetf", "15000.00");
        setInputText(viewRecordFrame, "hourlyratetf", "100.00");

        // Simulate button click using reflection
        Method updateRecordMethod = ViewRecordFrame.class.getDeclaredMethod("Update", java.awt.event.MouseEvent.class);
        updateRecordMethod.setAccessible(true);
        updateRecordMethod.invoke(viewRecordFrame, (java.awt.event.MouseEvent) null);

        // Verifications can be more specific depending on what the update method changes
        assertTrue(isTextFieldNotEmpty(viewRecordFrame, "employeenumbertf"));
        assertTrue(isTextFieldNotEmpty(viewRecordFrame, "firstnametf"));
        assertTrue(isTextFieldNotEmpty(viewRecordFrame, "lastnametf"));
    }

    private void setInputText(ViewRecordFrame frame, String fieldName, String text) throws Exception {
        Field field = ViewRecordFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        textField.setText(text);
    }

    private boolean isTextFieldNotEmpty(ViewRecordFrame frame, String fieldName) throws Exception {
        Field field = ViewRecordFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        return !textField.getText().isEmpty();
    }
}
