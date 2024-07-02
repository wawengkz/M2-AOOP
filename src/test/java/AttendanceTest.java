import com.mycompany.OOP.AttendanceTracking.Attendance;
import com.mycompany.oopmotorph.DatabaseUtility;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class AttendanceTest {
    private Attendance attendanceFrame;

    @BeforeEach
    public void setUp() {
        attendanceFrame = new Attendance();
    }

    @Test
    public void testFetchAttendanceRecords() throws SQLException {
        // Verify the table model has the correct data
        DefaultTableModel model = attendanceFrame.fetchDataFromDatabase();
        assertNotNull(model);
        assertEquals("Attendance ID", model.getColumnName(0));
        assertEquals("Employee ID", model.getColumnName(1));
        assertEquals("Employee Name", model.getColumnName(2));
        assertEquals("Date", model.getColumnName(3));
        assertEquals("Time In", model.getColumnName(4));
        assertEquals("Time Out", model.getColumnName(5));
        assertEquals("Hours Worked", model.getColumnName(6));
        assertEquals("Overtime Hours", model.getColumnName(7));
        
        // You can add more assertions to verify the fetched data if necessary
    }

    }

