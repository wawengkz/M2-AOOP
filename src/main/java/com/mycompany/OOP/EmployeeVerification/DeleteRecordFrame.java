/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.OOP.EmployeeVerification;

import com.mycompany.OOP.EmployeeVerification.Employees;
import com.mycompany.oopmotorph.DatabaseUtility;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yennie
 */
public class DeleteRecordFrame extends javax.swing.JDialog {
    
    public DeleteRecordFrame(String employeeNum) {
        initComponents();
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(null);
        fetchEmployeeDetails(employeeNum);
    }

    /**
     * Creates new form ViewRecordFrame
     */
    
    private void fetchEmployeeDetails(String employeeNum) {
        String query = "SELECT * FROM employee_payslip_view WHERE employee_id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employeeNum);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employeenumbertf.setText(rs.getString("employee_id"));
                    firstnametf.setText(rs.getString("first_name"));
                    lastnametf.setText(rs.getString("last_name"));
                    bdaytf.setText(rs.getString("birth_date"));
                    addresstf.setText(rs.getString("address"));
                    phonenumtf.setText(rs.getString("contact_number"));
                    sssnumtf.setText(rs.getString("sss_number"));
                    phnumtf.setText(rs.getString("philhealth_number"));
                    tinnumtf.setText(rs.getString("tin_number"));
                    pagibigtf.setText(rs.getString("pagibig_number"));
                    statustf.setText(rs.getString("status"));
                    positiontf.setText(rs.getString("position"));
                    supervisortf.setText(rs.getString("supervisor"));
                    basicsalarytf.setText(rs.getString("MonthlyRate"));
                    ricetf.setText(rs.getString("RiceSubsidy"));
                    phonetf.setText(rs.getString("PhoneAllowance"));
                    clothingtf.setText(rs.getString("ClothingAllowance"));
                    smratetf.setText(rs.getString("GrossIncome"));
                    hourlyratetf.setText(rs.getString("hourlyRate"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeleteRecordFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error fetching employee details: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private DeleteRecordFrame() {
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lastnametf = new javax.swing.JTextField();
        firstnametf = new javax.swing.JTextField();
        bdaytf = new javax.swing.JTextField();
        addresstf = new javax.swing.JTextField();
        phonenumtf = new javax.swing.JTextField();
        sssnumtf = new javax.swing.JTextField();
        phnumtf = new javax.swing.JTextField();
        tinnumtf = new javax.swing.JTextField();
        pagibigtf = new javax.swing.JTextField();
        statustf = new javax.swing.JTextField();
        positiontf = new javax.swing.JTextField();
        supervisortf = new javax.swing.JTextField();
        employeenumbertf = new javax.swing.JTextField();
        basicsalarytf = new javax.swing.JTextField();
        ricetf = new javax.swing.JTextField();
        phonetf = new javax.swing.JTextField();
        clothingtf = new javax.swing.JTextField();
        smratetf = new javax.swing.JTextField();
        hourlyratetf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Employee Number:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 25, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Last Name: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 53, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("First Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 81, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Birthday:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 109, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Address:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 137, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Phone Number:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 165, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("SSS Number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 193, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Philhealth Number:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 221, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("TIN Number:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 249, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("PAGIBIG Number:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 277, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Status:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 305, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Position:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 333, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Immediate Supervisor:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 364, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Basic Salary:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 389, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Rice Subsidy:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 417, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Phone Allowance:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 445, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Clothing Allowance:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 473, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("Semi-monthly Rate:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 501, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText("Hourly Rate:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 529, -1, -1));

        lastnametf.setEditable(false);
        lastnametf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lastnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 50, 387, -1));

        firstnametf.setEditable(false);
        firstnametf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(firstnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 78, 387, -1));

        bdaytf.setEditable(false);
        bdaytf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(bdaytf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 106, 387, -1));

        addresstf.setEditable(false);
        addresstf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(addresstf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 134, 387, -1));

        phonenumtf.setEditable(false);
        phonenumtf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(phonenumtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 162, 387, -1));

        sssnumtf.setEditable(false);
        sssnumtf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(sssnumtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 190, 387, -1));

        phnumtf.setEditable(false);
        phnumtf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(phnumtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 218, 387, -1));

        tinnumtf.setEditable(false);
        tinnumtf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tinnumtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 246, 387, -1));

        pagibigtf.setEditable(false);
        pagibigtf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(pagibigtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 274, 387, -1));

        statustf.setEditable(false);
        statustf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(statustf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 302, 387, -1));

        positiontf.setEditable(false);
        positiontf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(positiontf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 330, 387, -1));

        supervisortf.setEditable(false);
        supervisortf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(supervisortf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 358, 387, -1));

        employeenumbertf.setEditable(false);
        employeenumbertf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(employeenumbertf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 22, 387, -1));

        basicsalarytf.setEditable(false);
        basicsalarytf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(basicsalarytf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 386, 387, -1));

        ricetf.setEditable(false);
        ricetf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ricetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 414, 387, -1));

        phonetf.setEditable(false);
        phonetf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(phonetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 442, 387, -1));

        clothingtf.setEditable(false);
        clothingtf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(clothingtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 470, 387, -1));

        smratetf.setEditable(false);
        smratetf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(smratetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 498, 387, -1));

        hourlyratetf.setEditable(false);
        hourlyratetf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hourlyratetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 526, 387, -1));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteRecord(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 90, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 560, 80, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteRecord(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteRecord
        String employeeNum = employeenumbertf.getText();

        String deleteEmployeeQuery = "DELETE FROM employees WHERE employee_id = ?";
        String deletePayslipQuery = "DELETE FROM Payslip WHERE Employee_ID = ?";

        try (Connection connection = DatabaseUtility.getConnection()) {
            // Delete from payslip table first due to foreign key constraint
            try (PreparedStatement payslipStmt = connection.prepareStatement(deletePayslipQuery)) {
                payslipStmt.setString(1, employeeNum);
                payslipStmt.executeUpdate();
            }

            // Delete from employees table
            try (PreparedStatement employeeStmt = connection.prepareStatement(deleteEmployeeQuery)) {
                employeeStmt.setString(1, employeeNum);
                employeeStmt.executeUpdate();
            }

            // Clear fields after deletion
            employeenumbertf.setText("");
            firstnametf.setText("");
            lastnametf.setText("");
            bdaytf.setText("");
            addresstf.setText("");
            phonenumtf.setText("");
            sssnumtf.setText("");
            phnumtf.setText("");
            tinnumtf.setText("");
            pagibigtf.setText("");
            statustf.setText("");
            positiontf.setText("");
            supervisortf.setText("");
            basicsalarytf.setText("");
            ricetf.setText("");
            phonetf.setText("");
            clothingtf.setText("");
            smratetf.setText("");
            hourlyratetf.setText("");

            JOptionPane.showMessageDialog(this, "Employee Record is deleted.");

        } catch (SQLException ex) {
            Logger.getLogger(DeleteRecordFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error deleting employee record: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_DeleteRecord

    private void close(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close
        dispose();
    }//GEN-LAST:event_close

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteRecordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteRecordFrame().setVisible(true);
            }
        });
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addresstf;
    private javax.swing.JTextField basicsalarytf;
    private javax.swing.JTextField bdaytf;
    private javax.swing.JTextField clothingtf;
    private javax.swing.JTextField employeenumbertf;
    private javax.swing.JTextField firstnametf;
    private javax.swing.JTextField hourlyratetf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastnametf;
    private javax.swing.JTextField pagibigtf;
    private javax.swing.JTextField phnumtf;
    private javax.swing.JTextField phonenumtf;
    private javax.swing.JTextField phonetf;
    private javax.swing.JTextField positiontf;
    private javax.swing.JTextField ricetf;
    private javax.swing.JTextField smratetf;
    private javax.swing.JTextField sssnumtf;
    private javax.swing.JTextField statustf;
    private javax.swing.JTextField supervisortf;
    private javax.swing.JTextField tinnumtf;
    // End of variables declaration//GEN-END:variables
}
