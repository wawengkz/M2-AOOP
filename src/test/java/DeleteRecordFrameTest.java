/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.OOP.EmployeeVerification.DeleteRecordFrame;
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
public class DeleteRecordFrameTest {

    private DeleteRecordFrame deleteRecordFrame;

    @BeforeEach
    public void setUp() {
        deleteRecordFrame = new DeleteRecordFrame("12345");
    }


    @Test
    public void testDeleteRecord() throws Exception {
        // Populate fields with test data
        setInputText(deleteRecordFrame, "employeenumbertf", "12345");
        setInputText(deleteRecordFrame, "firstnametf", "John");
        setInputText(deleteRecordFrame, "lastnametf", "Doe");

        // Simulate button click using reflection
        Method deleteRecordMethod = DeleteRecordFrame.class.getDeclaredMethod("DeleteRecord", java.awt.event.MouseEvent.class);
        deleteRecordMethod.setAccessible(true);
        deleteRecordMethod.invoke(deleteRecordFrame, (java.awt.event.MouseEvent) null);

        // Verify that the fields are cleared after deletion
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "employeenumbertf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "firstnametf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "lastnametf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "bdaytf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "addresstf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "phonenumtf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "sssnumtf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "phnumtf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "tinnumtf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "pagibigtf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "statustf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "positiontf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "supervisortf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "basicsalarytf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "ricetf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "phonetf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "clothingtf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "smratetf"));
        assertTrue(isTextFieldEmpty(deleteRecordFrame, "hourlyratetf"));
    }

    private void setInputText(DeleteRecordFrame frame, String fieldName, String text) throws Exception {
        Field field = DeleteRecordFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        textField.setText(text);
    }

    private boolean isTextFieldEmpty(DeleteRecordFrame frame, String fieldName) throws Exception {
        Field field = DeleteRecordFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        return textField.getText().isEmpty();
    }

    private boolean isTextFieldNotEmpty(DeleteRecordFrame frame, String fieldName) throws Exception {
        Field field = DeleteRecordFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        return !textField.getText().isEmpty();
    }

    private String getTextFieldValue(DeleteRecordFrame frame, String fieldName) throws Exception {
        Field field = DeleteRecordFrame.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(frame);
        return textField.getText();
    }
}
