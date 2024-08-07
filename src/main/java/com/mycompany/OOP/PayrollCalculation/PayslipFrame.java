/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.OOP.PayrollCalculation;

import Frames.MainFrame;
import com.mycompany.OOP.EmployeeVerification.Employee1;
import com.mycompany.OOP.EmployeeVerification.Employees;
import com.mycompany.oopmotorph.DatabaseUtility;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Yennie
 */
public class PayslipFrame extends javax.swing.JDialog {
    private MainFrame mainFrame; // Declare mainFrame as a class variable

    /**
     * Creates new form ViewRecordFrame
     * @param employee
     * @param mainFrame
     * 
     */
    
    
     public PayslipFrame(Employees employee, MainFrame mainFrame) {
        initComponents();
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(null);
        loadEmployeeData(employee);
        this.mainFrame = mainFrame; // Initialize mainFrame
    }

    private void loadEmployeeData(Employees employee) {
        employeeNumberTF.setText(employee.getEmployeeNum());
        firstNameTF.setText(employee.getFirstName());
        lastNameTF.setText(employee.getLastName());
        birthdayTF.setText(employee.getBirthday());
        adressTF.setText(employee.getAddress());
        phoneNumberTF.setText(employee.getPhoneNum());
        sssTF.setText(employee.getSssNum());
        phNumTF.setText(employee.getPhNum());
        tinNumTF.setText(employee.getTinNum());
        pagibigTF.setText(employee.getPagibigNum());
        statusTF.setText(employee.getStatus());
        positionTF.setText(employee.getPosition());
        supervisorTF.setText(employee.getSupervisor());
        basicSalaryTF.setText(employee.getBasicSalary());
        riceTF.setText(employee.getRiceAllowance());
        phoneTF.setText(employee.getphoneAllowance());
        clothingTF.setText(employee.getClothAllowance());
        semRateTF.setText(employee.getSemRate());
        hourlyRateTF.setText(employee.getHourlyRate());
    }






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lastNameTF = new javax.swing.JTextField();
        firstNameTF = new javax.swing.JTextField();
        birthdayTF = new javax.swing.JTextField();
        adressTF = new javax.swing.JTextField();
        phoneNumberTF = new javax.swing.JTextField();
        sssTF = new javax.swing.JTextField();
        phNumTF = new javax.swing.JTextField();
        tinNumTF = new javax.swing.JTextField();
        pagibigTF = new javax.swing.JTextField();
        statusTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        positionTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        supervisorTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        employeeNumberTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        basicSalaryTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        riceTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phoneTF = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        clothingTF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        semRateTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hourlyRateTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        salperiodtf = new javax.swing.JTextField();
        salearnedtf = new javax.swing.JTextField();
        riceallowtf = new javax.swing.JTextField();
        phoneallowtf = new javax.swing.JTextField();
        clothingallowtf = new javax.swing.JTextField();
        grosstf = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        nettf = new javax.swing.JTextField();
        ssstf = new javax.swing.JTextField();
        phtf = new javax.swing.JTextField();
        pgbtf = new javax.swing.JTextField();
        taxtf = new javax.swing.JTextField();
        tdeducttf = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        y1cb = new javax.swing.JComboBox<>();
        m1cb = new javax.swing.JComboBox<>();
        d1cb = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        m2cb = new javax.swing.JComboBox<>();
        y2cb = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        d2cb = new javax.swing.JComboBox<>();
        showpaybtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lastNameTF.setEditable(false);
        lastNameTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lastNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 34, 387, -1));

        firstNameTF.setEditable(false);
        firstNameTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(firstNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 62, 387, -1));

        birthdayTF.setEditable(false);
        birthdayTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(birthdayTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 90, 387, -1));

        adressTF.setEditable(false);
        adressTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(adressTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 118, 387, -1));

        phoneNumberTF.setEditable(false);
        phoneNumberTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(phoneNumberTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 146, 387, -1));

        sssTF.setEditable(false);
        sssTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(sssTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 174, 387, -1));

        phNumTF.setEditable(false);
        phNumTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(phNumTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 202, 387, -1));

        tinNumTF.setEditable(false);
        tinNumTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tinNumTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 230, 387, -1));

        pagibigTF.setEditable(false);
        pagibigTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(pagibigTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 258, 387, -1));

        statusTF.setEditable(false);
        statusTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(statusTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 286, 387, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Philhealth Number:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 205, -1, -1));

        positionTF.setEditable(false);
        positionTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(positionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 314, 387, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("TIN Number:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 233, -1, -1));

        supervisorTF.setEditable(false);
        supervisorTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(supervisorTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 342, 387, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("PAGIBIG Number:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 261, -1, -1));

        employeeNumberTF.setEditable(false);
        employeeNumberTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(employeeNumberTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 6, 387, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Status:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 289, -1, -1));

        basicSalaryTF.setEditable(false);
        basicSalaryTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(basicSalaryTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 370, 387, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Position:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 317, -1, -1));

        riceTF.setEditable(false);
        riceTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(riceTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 398, 387, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Immediate Supervisor:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 348, -1, -1));

        phoneTF.setEditable(false);
        phoneTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(phoneTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 426, 387, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Basic Salary:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 373, -1, -1));

        clothingTF.setEditable(false);
        clothingTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(clothingTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 454, 387, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Rice Subsidy:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 401, -1, -1));

        semRateTF.setEditable(false);
        semRateTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(semRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 482, 387, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Phone Allowance:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 429, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Clothing Allowance:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 457, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Employee Number:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 9, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Last Name: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("First Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 65, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Birthday:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 93, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Address:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 121, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Phone Number:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 149, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("SSS Number:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 177, -1, -1));

        hourlyRateTF.setEditable(false);
        hourlyRateTF.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(hourlyRateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 510, 387, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("Semi-monthly Rate:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 482, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText("Hourly Rate:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 510, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Close");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 80, 30));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 600));

        jTabbedPane1.addTab("Employee Details", jPanel1);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 251, 181));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 5));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("Earnings");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 104, -1));
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 240, -1, -1));

        jLabel40.setText("Salary Period:");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 36, 104, -1));

        jLabel41.setText("Salary Earned:");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 64, 104, -1));

        jLabel42.setText("Rice Allowance:");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 92, 104, -1));

        jLabel43.setText("Phone Allowance:");
        jPanel6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 120, 110, -1));

        jLabel44.setText("Clothing Allowance:");
        jPanel6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 145, 120, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("Gross Salary:");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 182, 104, -1));

        salperiodtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salperiodtfActionPerformed(evt);
            }
        });
        jPanel6.add(salperiodtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 33, 170, -1));
        jPanel6.add(salearnedtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 61, 170, -1));
        jPanel6.add(riceallowtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 89, 170, -1));
        jPanel6.add(phoneallowtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 117, 170, -1));
        jPanel6.add(clothingallowtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 145, 170, -1));
        jPanel6.add(grosstf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 179, 170, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 102));
        jLabel30.setText("Deductions");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 252, 104, -1));

        jLabel31.setText("SSS:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 280, 104, -1));

        jLabel33.setText("Philhealth:");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 308, 104, -1));

        jLabel34.setText("PAGIBIG:");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 336, 104, -1));

        jLabel35.setText("Witholding Tax:");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 364, 104, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setText("Total Deductions:");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 407, 104, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setText("Net Salary:");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 457, 104, -1));
        jPanel6.add(nettf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 457, 170, -1));
        jPanel6.add(ssstf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 274, 170, -1));
        jPanel6.add(phtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 302, 170, -1));
        jPanel6.add(pgbtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 333, 170, -1));
        jPanel6.add(taxtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 361, 170, -1));
        jPanel6.add(tdeducttf, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 404, 170, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        jLabel46.setText("**this payslip is auto-generated by the system**");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 190, 10));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 340, 520));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Start Date:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 45, -1, -1));

        jLabel21.setText("Year:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 70, -1, -1));

        jLabel22.setText("Month:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 98, -1, -1));

        jLabel23.setText("Date:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 126, -1, -1));

        y1cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2024" }));
        y1cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y1cbActionPerformed(evt);
            }
        });
        jPanel2.add(y1cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 67, 70, -1));

        m1cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "9", "10", "11", "12" }));
        jPanel2.add(m1cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 95, 70, -1));

        d1cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel2.add(d1cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 123, 70, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel24.setText("Select Payslip Date Range");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("End Date:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 163, -1, -1));

        jLabel26.setText("Year:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 188, -1, -1));

        jLabel27.setText("Month:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 216, -1, -1));

        m2cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "9", "10", "11", "12" }));
        jPanel2.add(m2cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 213, 70, -1));

        y2cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2024" }));
        jPanel2.add(y2cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 185, 70, -1));

        jLabel29.setText("Date:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 241, -1, -1));

        d2cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel2.add(d2cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 241, 70, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 280));

        showpaybtn.setBackground(new java.awt.Color(0, 0, 102));
        showpaybtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showpaybtn.setForeground(new java.awt.Color(255, 255, 255));
        showpaybtn.setText("Show Payslip");
        showpaybtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        showpaybtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showpaybtnMouseClicked(evt);
            }
        });
        showpaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpaybtnActionPerformed(evt);
            }
        });
        jPanel5.add(showpaybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, 30));

        closebtn.setBackground(new java.awt.Color(0, 0, 102));
        closebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        closebtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        jPanel5.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 70, 30));
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 140, 170));

        jTabbedPane1.addTab("Payslip", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showpaybtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showpaybtnMouseClicked
        
        Employees employees = new Employees();

        employees.setemployeenum(employeeNumberTF.getText());
        employees.setlastname(lastNameTF.getText());
        employees.setfirstname(firstNameTF.getText());
        employees.setbirthday(birthdayTF.getText());
        employees.setaddress(adressTF.getText());
        employees.setphonenum(phoneNumberTF.getText());
        employees.setsssnum(sssTF.getText());
        employees.setphnum(phNumTF.getText());
        employees.settin(tinNumTF.getText());
        employees.setpgbnum(pagibigTF.getText());
        employees.setstatus(statusTF.getText());
        employees.setposition(positionTF.getText());
        employees.setsupervisor(supervisorTF.getText());
        employees.setbasic(basicSalaryTF.getText());
        employees.setriceall(riceTF.getText());
        employees.setphoneall(phoneTF.getText());
        employees.setclotheall(clothingTF.getText());
        employees.setsmrate(semRateTF.getText());
        employees.sethourlyrate(hourlyRateTF.getText());

        String startYear = y1cb.getSelectedItem().toString();
        String startMonth = m1cb.getSelectedItem().toString();
        String startDay = d1cb.getSelectedItem().toString();
        String endYear = y2cb.getSelectedItem().toString();
        String endMonth = m2cb.getSelectedItem().toString();
        String endDay = d2cb.getSelectedItem().toString();

        String start = startYear + "-" + startMonth + "-" + startDay;
        String end = endYear + "-" + endMonth + "-" + endDay;

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = format.parse(start);
            Date endDate = format.parse(end);

            if (startDate.after(endDate)) {
                JOptionPane.showMessageDialog(this, "End date must be after start date", "Invalid Dates", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float hw = employees.ComputeHoursWorked(start, end);
            salperiodtf.setText(start + " - " + end);
            salearnedtf.setText(employees.computeSalEarned(hw));
            riceallowtf.setText(employees.getRiceAllowance());
            phoneallowtf.setText(employees.getphoneAllowance());
            clothingallowtf.setText(employees.getClothAllowance());
            grosstf.setText(employees.computeGross(hw));
            ssstf.setText(employees.computeSSS());
            phtf.setText(employees.computePH());
            pgbtf.setText(employees.computePGB());
            taxtf.setText(employees.computeTax());
            tdeducttf.setText(employees.computeTotalDeduct());
            nettf.setText(employees.computeNet(hw));

           

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Select Valid Dates", "Invalid Dates", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(PayslipFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    

    
            
        
        
        
    }//GEN-LAST:event_showpaybtnMouseClicked

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        dispose();
    }//GEN-LAST:event_closebtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void y1cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y1cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_y1cbActionPerformed

    private void showpaybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpaybtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showpaybtnActionPerformed

    private void salperiodtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salperiodtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salperiodtfActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
  public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayslipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Employees employee = new Employees();
        employee.setemployeenum("1");
        employee.setlastname("Doe");
        employee.setfirstname("John");
        employee.setbirthday("01/01/1990");
        employee.setaddress("123 Main St");
        employee.setphonenum("555-5555");
        employee.setsssnum("SSS123456");
        employee.setphnum("PH123456");
        employee.settin("TIN123456");
        employee.setpgbnum("PGB123456");
        employee.setstatus("Single");
        employee.setposition("Developer");
        employee.setsupervisor("Jane Smith");
        employee.setbasic("50000");
        employee.setriceall("2000");
        employee.setphoneall("1000");
        employee.setclotheall("1500");
        employee.setsmrate("25000");
        employee.sethourlyrate("200");
    }


   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressTF;
    private javax.swing.JTextField basicSalaryTF;
    private javax.swing.JTextField birthdayTF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closebtn;
    private javax.swing.JTextField clothingTF;
    private javax.swing.JTextField clothingallowtf;
    private javax.swing.JComboBox<String> d1cb;
    private javax.swing.JComboBox<String> d2cb;
    private javax.swing.JTextField employeeNumberTF;
    private javax.swing.JTextField firstNameTF;
    private javax.swing.JTextField grosstf;
    private javax.swing.JTextField hourlyRateTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastNameTF;
    private javax.swing.JComboBox<String> m1cb;
    private javax.swing.JComboBox<String> m2cb;
    private javax.swing.JTextField nettf;
    private javax.swing.JTextField pagibigTF;
    private javax.swing.JTextField pgbtf;
    private javax.swing.JTextField phNumTF;
    private javax.swing.JTextField phoneNumberTF;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JTextField phoneallowtf;
    private javax.swing.JTextField phtf;
    private javax.swing.JTextField positionTF;
    private javax.swing.JTextField riceTF;
    private javax.swing.JTextField riceallowtf;
    private javax.swing.JTextField salearnedtf;
    private javax.swing.JTextField salperiodtf;
    private javax.swing.JTextField semRateTF;
    private javax.swing.JButton showpaybtn;
    private javax.swing.JTextField sssTF;
    private javax.swing.JTextField ssstf;
    private javax.swing.JTextField statusTF;
    private javax.swing.JTextField supervisorTF;
    private javax.swing.JTextField taxtf;
    private javax.swing.JTextField tdeducttf;
    private javax.swing.JTextField tinNumTF;
    private javax.swing.JComboBox<String> y1cb;
    private javax.swing.JComboBox<String> y2cb;
    // End of variables declaration//GEN-END:variables
}
