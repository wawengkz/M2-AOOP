/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.OOP.EmployeeVerification;

import com.mycompany.oopmotorph.DatabaseUtility;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Yennie
 */
public class Employees {
    
    private String employeenum,firstname,lastname,birthday,address,phonenum,
            sssnum,phnum,tin,pgbnum,status,position,supervisor,
            basicsalary,riceall,phoneall,clotheall,smrate,hourlyrate; 
    
    
    
    public Employees(){};
    
    public Employees(String _employeenum,String _firstname,String _lastname,String _birthday,String _address,
                     String _phonenum,String _sssnum,String _phnum,String _tin, String _pgbnum, 
                     String _status,String _position,String _supervisor,String _basicsalary, String _riceall,
                     String _phoneall, String _clotheall, String _smrate, String _hourlyrate){
                    
        
        employeenum = _employeenum;
        firstname = _firstname;
        lastname = _lastname;
        birthday = _birthday;
        address = _address;
        phonenum = _phonenum;
        sssnum = _sssnum;
        phnum = _phnum;
        tin = _tin;
        pgbnum = _pgbnum;
        status = _status;
        position = _position;
        supervisor = _supervisor;
        basicsalary = _basicsalary;
        riceall = _riceall;
        phoneall = _phoneall;
        clotheall = _clotheall;
        smrate = _smrate;
        hourlyrate = _hourlyrate;
    }
    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }
    public void setemployeenum(String _employeenum){
        employeenum = _employeenum;
    }
    
    public void setfirstname(String _firstname){
        firstname = _firstname;
    }
    
    public void setlastname(String _lastname){
        lastname = _lastname;
    }
    
    public void setbirthday(String _birthday){
        birthday = _birthday;
    }
    
    public void setaddress(String _address){
        address=_address;
    }
    
    public void setphonenum(String _phonenum){
        phonenum = _phonenum;
    }
    
    public void setsssnum(String _sssnum){
        sssnum=_sssnum;
    }
    
    public void setphnum(String _phnum){
        phnum = _phnum;
    }
    public void settin(String _tin){
        tin = _tin;
    }
    
    public void setpgbnum(String _pgbnum){
        pgbnum = _pgbnum;
    }
    
    public void setstatus(String _status){
        status = _status;
    }
    
    public void setposition(String _position){
        position = _position;
    }
    
    public void setsupervisor(String _supervisor){
        supervisor = _supervisor;
    }
    
    public void setbasic(String _basicsalary){
        basicsalary=_basicsalary;
    }
    
    public void setriceall(String _riceall){
        riceall = _riceall;
    }
    public void setphoneall(String _phoneall){
        phoneall = _phoneall;
    }
    public void setclotheall(String _clotheall){
        clotheall = _clotheall;
    }
    public void setsmrate(String _smrate){
        smrate = _smrate;
    }
    public void sethourlyrate(String _hourlyrate){
        hourlyrate = _hourlyrate;
    }
    
    
    
    public String getEmployeeNum(){
        return employeenum ;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public String getLastName(){
        return lastname ;
    }
    
    public String getBirthday(){
        return birthday;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhoneNum(){
        return phonenum;
    }
    
    public String getSssNum(){
        return sssnum;
    }
    
    public String getPhNum(){
        return phnum;
    }
    public String getTinNum(){
        return tin;
    }
    
    public String getPagibigNum(){
        return pgbnum;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getPosition(){
        return position ;
    }
    
    public String getSupervisor(){
        return supervisor;
    }
    
    public String getBasicSalary(){
        return basicsalary;
    }
    
    public String getRiceAllowance(){
        return riceall;
    }
    public String getphoneAllowance(){
        return phoneall;
    }
    public String getClothAllowance(){
        return clotheall;
    }
    public String getSemRate(){
        return smrate;
    }
    public String getHourlyRate(){
        return hourlyrate;
    }
    
    
    
 
    
       public float ComputeHoursWorked(String startDate, String endDate) throws SQLException, ParseException {
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

    Date dateIn = format2.parse(startDate);
    Date dateOut = format2.parse(endDate);

    String query = "SELECT date, time_in, time_out FROM attendance WHERE employee_id = ? AND date BETWEEN ? AND ?";
    ArrayList<Date> timein = new ArrayList<>();
    ArrayList<Date> timeout = new ArrayList<>();

    try (Connection connection = DatabaseUtility.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, Integer.parseInt(employeenum));
        stmt.setDate(2, new java.sql.Date(dateIn.getTime()));
        stmt.setDate(3, new java.sql.Date(dateOut.getTime()));
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                timein.add(format1.parse(rs.getDate("date").toString() + " " + rs.getTime("time_in").toString()));
                timeout.add(format1.parse(rs.getDate("date").toString() + " " + rs.getTime("time_out").toString()));
            }
        }
    }

    if (timein.isEmpty() || timeout.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No attendance records found for the given period.", "Error", JOptionPane.ERROR_MESSAGE);
        return 0;
    }

    int indexStart = 0;
    for (int i = 0; i < timein.size(); i++) {
        if (timein.get(i).compareTo(dateIn) >= 0) {
            indexStart = i;
            break;
        }
    }

    int indexEnd = timein.size() - 1;
    for (int i = 0; i < timeout.size(); i++) {
        if (timeout.get(i).compareTo(dateOut) <= 0) {
            indexEnd = i;
        }
    }

    float sum = 0;
    for (int k = indexStart; k <= indexEnd; k++) {
        Date t1 = timein.get(k);
        Date t2 = timeout.get(k);

        float t = t2.getTime() - t1.getTime() - (60 * 60 * 1000); // Adjust for lunch break
        float hoursWorked = t / (60 * 60 * 1000);

        if (hoursWorked >= 47.0 / 6) { // Adjust for late tolerance
            hoursWorked = 8;
        }
        sum += hoursWorked;
    }

    return sum;
    
    
  
    

    
       
    }
    public String computeSalEarned(float hw){
        float salEarned= Float.parseFloat(hourlyrate)*hw;
        return format("%.2f",salEarned);
    }
    
    public String computeGross(float hw){
        float gross =  Float.parseFloat(computeSalEarned(hw))+
                       Float.parseFloat(riceall)+
                       Float.parseFloat(phoneall)+
                       Float.parseFloat(clotheall);
        
        return format("%.2f",gross);
    }
    
    public String computeSSS(){
        double sss;
         
        float sal = Float.parseFloat(basicsalary);
         
         
         if(sal<=3250){
                sss = 135;
            }
            else if(sal>3250 & sal<=24750) {
               if(sal%1000==250 |sal%1000==750 ){// this check whether the salary is in the lower/upper bound of range. 
                   float mod = (sal-3250)%500; // after deducting 3250, in every 500 increment, the sss increases by 22.5
                    float multiplier = ((sal-3250-mod)/500);              
                    sss = 22.5*(multiplier)+135;                        
               }
                else{// this applies the normal formule is salary falls within the range
                    float mod = (sal-3250)%500; 
                    float multiplier = ((sal-3250-mod)/500);              
                    sss = 22.5*(multiplier+1)+135;           
               }
            }
            else{
                sss = 1125;
            }
           
            return format("%.2f",sss);  
    }
    
    public String computePH(){
        double ph;

        float sal = Float.parseFloat(basicsalary);
         

        if(sal<=10000){//if-elseif-else statement checks the range of salary and applies formula in each range
           ph = 300/2;
        }
        else if (sal>10000 & sal<60000){
           ph = sal*(0.03)/2;
        }
        else{
           ph = 1800/2;
        }
       
       return format("%.2f",ph);
    }
    
    public String computePGB(){
        double pagibig;
        float sal = Float.parseFloat(basicsalary);
        
        if(sal>1000 & sal<=1500){//if-else statement checks the range of salary and applies formula in each rang
            pagibig = sal*(float)0.01;
        } 
        else{
            if(sal*0.02 <100){// this nested if-else statement provides the pagibig to be 100 if the values exceeds 100
              pagibig= sal*(float)0.02;
            }
            else{
                pagibig = 100;
            }
        }
        
        return format("%.2f",pagibig);    
    }
    
    public String computeTax(){
        float tax;
        float sal = Float.parseFloat(basicsalary);
        float sss = Float.parseFloat(computeSSS());
        float pagibig = Float.parseFloat(computePGB());
        float ph = Float.parseFloat(computePH());
        
        float taxable = sal-sss-pagibig-ph;
       
         if(sal <=20832){//if-elseif-else statement checks the range of taxable income and applies formula in each range 
                tax = 0;
            }
            else if(sal>20832 & sal<33333){
                tax = (float) ((taxable-20833)*0.2);               
            }
            else if(sal>=33333 & sal< 66667){
                tax = (float) ((taxable-33333)*0.25+2500);
            }
            else if(sal>=66667 & sal< 166667){
                tax = (float) ((taxable-66667)*0.3+10833);
            }
            else if(sal>=166667 & sal< 666667){
                tax = (float) ((taxable-166667)*0.32+40833.33);
            }
            else{
                tax = (float) ((sal-666667)*0.35+200833.33);
            }
           
            
            return format("%.2f",tax);
    }
    
    public String computeTotalDeduct(){
        
        float tax = Float.parseFloat(computeTax());
        float sss = Float.parseFloat(computeSSS());
        float pagibig = Float.parseFloat(computePGB());
        float ph = Float.parseFloat(computePH());
        
        return format("%.2f",sss+ph+pagibig+tax);
    }
    
    public String computeNet(float hw){
        float net = Float.parseFloat(computeGross(hw))-Float.parseFloat(computeTotalDeduct());
        return format("%.2f",net);
    }
    
    
    
    
    public void ApplyLeave(String filename, String leaveType, String days) throws FileNotFoundException, IOException, CsvValidationException {
        
        String tempfilename = filename.replace(".csv", ".tmp");
        
        try(CSVWriter csvwriter = new CSVWriter(new FileWriter(tempfilename,true))){
            
            String[] line;

            
            try (CSVReader csvreader = new CSVReader(new FileReader(filename))) {
                String[] header =csvreader.readNext();
                csvwriter.writeNext(header);
                
                while((line=csvreader.readNext())!=null){
                    if(line[0].equals(employeenum) & leaveType.equals("Sick Leave")){
                        
                        line[3] = String.valueOf(Integer.parseInt(line[3])-Integer.parseInt(days));
                        
                    }
                    else if(line[0].equals(employeenum) & leaveType.equals("Vacation Leave")){
                        line[4] = String.valueOf(Integer.parseInt(line[4])-Integer.parseInt(days));
                    }
                    else if(line[0].equals(employeenum) & leaveType.equals("Sick Leave")){
                        line[5] = String.valueOf(Integer.parseInt(line[5])-Integer.parseInt(days));
                    }
                    
                    
                    csvwriter.writeNext(line);
                    
                }
            }
               
        }
        finally{
            new File(filename).delete();
            new File(tempfilename).renameTo(new File(filename));
        }
        
    }
    
    public TableModel tableDetails() throws SQLException {
        String[] columnNames = {"Employee No.", "Last Name", "First Name", "SSS", "Philhealth", "TIN", "PAGIBIG"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        try (Connection connection = DatabaseUtility.getConnection()) {
            String query = "SELECT employee_id, last_name, first_name, sss_number, philhealth_number, tin_number, pagibig_number FROM employees";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("employee_id"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("sss_number"),
                    rs.getString("philhealth_number"),
                    rs.getString("tin_number"),
                    rs.getString("pagibig_number")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return model;
    }
    
    public boolean fetchEmployeeDetails() throws SQLException {
         String query = "SELECT * FROM employees WHERE employee_id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(employeenum));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.lastname = rs.getString("last_name");
                    this.firstname = rs.getString("first_name");
                    // Set other fields...
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    
public Employees getEmployeeDetails(String employeeNum) throws IOException, CsvValidationException {
    String filename = "MotorPH Employee Data.csv"; // Ensure this path is correct
    try (CSVReader csvReader = new CSVReader(new FileReader(filename))) {
        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            if (nextLine[0].equals(employeeNum)) { // Assuming the employee number is in the first column
                // Assuming the order and structure of your CSV matches your Employees constructor
                return new Employees(
                    nextLine[0], // employeenum
                    nextLine[2], // firstname
                    nextLine[1], // lastname
                    nextLine[3], // birthday
                    nextLine[4], // address
                    nextLine[5], // phonenum
                    nextLine[6], // sssnum
                    nextLine[7], // phnum
                    nextLine[8], // tin
                    nextLine[9], // pgbnum
                    nextLine[10], // status
                    nextLine[11], // position
                    nextLine[12], // supervisor
                    nextLine[13], // basicsalary
                    nextLine[14], // riceall
                    nextLine[15], // phoneall
                    nextLine[16], // clotheall
                    nextLine[17], // smrate
                    nextLine[18]  // hourlyrate
                        
                              );
            }
        }
    }
    return null; // Employee not found
}

}
