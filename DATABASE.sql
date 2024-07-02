CREATE DATABASE payrollsystem_db;
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    last_name VARCHAR(50),
    first_name VARCHAR(50),
    birth_date VARCHAR(50),  
    address VARCHAR(255),
    contact_number VARCHAR(20),
    sss_number VARCHAR(15),
    philhealth_number VARCHAR(15),
    tin_number VARCHAR(15),
    pagibig_number VARCHAR(15),
    status VARCHAR(15),
    position VARCHAR(50),
    supervisor VARCHAR(50)
);


CREATE INDEX name_idx ON Employees (first_name, last_name);
CREATE INDEX position_status_idx ON Employees (position, status);
SHOW INDEX FROM Employees;

select *FROM Employees;

CREATE TABLE Payslip (
  PaySlip_ID INT PRIMARY KEY AUTO_INCREMENT,
  Employee_ID INT,
  PeriodStartDate DATE,
  PeriodEndDate DATE,
  MonthlyRate INT,
  DaysWorked INT,
  DailyRate DECIMAL(10, 2),
  hourlyRate DECIMAL(10, 2),
  GrossIncome DECIMAL(10, 2),
  RiceSubsidy DECIMAL(10, 2),
  PhoneAllowance DECIMAL(10, 2),
  ClothingAllowance DECIMAL(10, 2),
  FOREIGN KEY (Employee_ID) REFERENCES Employees(employee_id)
);

CREATE INDEX idx_period_start_date ON Payslip (PeriodStartDate);
CREATE INDEX idx_period_end_date ON Payslip (PeriodEndDate);

SHOW INDEXES from payslip;
SELECT * FROM Payslip;


CREATE VIEW employee_payslip_view AS
SELECT 
    e.employee_id,
    e.last_name,
    e.first_name,
    e.birth_date,
    e.address,
    e.contact_number,
    e.sss_number,
    e.philhealth_number,
    e.tin_number,
    e.pagibig_number,
    e.status,
    e.position,
    e.supervisor,
    p.MonthlyRate,
    p.GrossIncome,
    p.RiceSubsidy,
    p.PhoneAllowance,
    p.ClothingAllowance,
    p.hourlyRate
FROM 
    employees e
JOIN 
    Payslip p ON e.employee_id = p.Employee_ID;

SELECT * FROM employee_payslip_view;


CREATE TABLE sss_cont (
  employee_number INT NOT NULL,
  SSSID VARCHAR(15) NOT NULL,
  monthly_salary DECIMAL(10, 2) NOT NULL,
  sss_deduction DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (employee_number)
);

DELIMITER //

CREATE FUNCTION compute_sss_deduction(monthly_salary DECIMAL(10, 2))
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
  DECLARE sss_deduction DECIMAL(10, 2);

  IF monthly_salary < 3250 THEN
    SET sss_deduction = 135.00;
  ELSEIF monthly_salary BETWEEN 3250 AND 3749.99 THEN
    SET sss_deduction = 157.50;
  ELSEIF monthly_salary BETWEEN 3750 AND 4249.99 THEN
    SET sss_deduction = 180.00;
  ELSEIF monthly_salary BETWEEN 4250 AND 4749.99 THEN
    SET sss_deduction = 202.50;
  ELSEIF monthly_salary BETWEEN 4750 AND 5249.99 THEN
    SET sss_deduction = 225.00;
  ELSEIF monthly_salary BETWEEN 5250 AND 5749.99 THEN
    SET sss_deduction = 247.50;
  ELSEIF monthly_salary BETWEEN 5750 AND 6249.99 THEN
    SET sss_deduction = 270.00;
  ELSEIF monthly_salary BETWEEN 6250 AND 6749.99 THEN
    SET sss_deduction = 292.50;
  ELSEIF monthly_salary BETWEEN 6750 AND 7249.99 THEN
    SET sss_deduction = 315.00;
  ELSEIF monthly_salary BETWEEN 7250 AND 7749.99 THEN
    SET sss_deduction = 337.50;
  ELSEIF monthly_salary BETWEEN 7750 AND 8249.99 THEN
    SET sss_deduction = 360.00;
  ELSEIF monthly_salary BETWEEN 8250 AND 8749.99 THEN
    SET sss_deduction = 382.50;
  ELSEIF monthly_salary BETWEEN 8750 AND 9249.99 THEN
    SET sss_deduction = 405.00;
  ELSEIF monthly_salary BETWEEN 9250 AND 9749.99 THEN
    SET sss_deduction = 427.50;
  ELSEIF monthly_salary BETWEEN 9750 AND 10249.99 THEN
    SET sss_deduction = 450.00;
  ELSEIF monthly_salary BETWEEN 10250 AND 10749.99 THEN
    SET sss_deduction = 472.50;
  ELSEIF monthly_salary BETWEEN 10750 AND 11249.99 THEN
    SET sss_deduction = 495.00;
  ELSEIF monthly_salary BETWEEN 11250 AND 11749.99 THEN
    SET sss_deduction = 517.50;
  ELSEIF monthly_salary BETWEEN 11750 AND 12249.99 THEN
    SET sss_deduction = 540.00;
  ELSEIF monthly_salary BETWEEN 12250 AND 12749.99 THEN
    SET sss_deduction = 562.50;
  ELSEIF monthly_salary BETWEEN 12750 AND 13249.99 THEN
    SET sss_deduction = 585.00;
  ELSEIF monthly_salary BETWEEN 13250 AND 13749.99 THEN
    SET sss_deduction = 607.50;
  ELSEIF monthly_salary BETWEEN 13750 AND 14249.99 THEN
    SET sss_deduction = 630.00;
  ELSEIF monthly_salary BETWEEN 14250 AND 14749.99 THEN
    SET sss_deduction = 652.50;
  ELSEIF monthly_salary BETWEEN 14750 AND 15249.99 THEN
    SET sss_deduction = 675.00;
  ELSEIF monthly_salary BETWEEN 15250 AND 15749.99 THEN
    SET sss_deduction = 697.50;
  ELSEIF monthly_salary BETWEEN 15750 AND 16249.99 THEN
    SET sss_deduction = 720.00;
  ELSEIF monthly_salary BETWEEN 16250 AND 16749.99 THEN
    SET sss_deduction = 742.50;
  ELSEIF monthly_salary BETWEEN 16750 AND 17249.99 THEN
    SET sss_deduction = 765.00;
  ELSEIF monthly_salary BETWEEN 17250 AND 17749.99 THEN
    SET sss_deduction = 787.50;
  ELSEIF monthly_salary BETWEEN 17750 AND 18249.99 THEN
    SET sss_deduction = 810.00;
  ELSEIF monthly_salary BETWEEN 18250 AND 18749.99 THEN
    SET sss_deduction = 832.50;
  ELSEIF monthly_salary BETWEEN 18750 AND 19249.99 THEN
    SET sss_deduction = 855.00;
  ELSEIF monthly_salary BETWEEN 19250 AND 19749.99 THEN
    SET sss_deduction = 877.50;
  ELSEIF monthly_salary BETWEEN 19750 AND 20249.99 THEN
    SET sss_deduction = 900.00;
  ELSEIF monthly_salary BETWEEN 20250 AND 20749.99 THEN
    SET sss_deduction = 922.50;
  ELSEIF monthly_salary BETWEEN 20750 AND 21249.99 THEN
    SET sss_deduction = 945.00;
  ELSEIF monthly_salary BETWEEN 21250 AND 21749.99 THEN
    SET sss_deduction = 967.50;
  ELSEIF monthly_salary BETWEEN 21750 AND 22249.99 THEN
    SET sss_deduction = 990.00;
  ELSEIF monthly_salary BETWEEN 22250 AND 22749.99 THEN
    SET sss_deduction = 1012.50;
  ELSEIF monthly_salary BETWEEN 22750 AND 23249.99 THEN
    SET sss_deduction = 1035.00;
  ELSEIF monthly_salary BETWEEN 23250 AND 23749.99 THEN
    SET sss_deduction = 1057.50;
  ELSEIF monthly_salary BETWEEN 23750 AND 24249.99 THEN
    SET sss_deduction = 1080.00;
  ELSEIF monthly_salary BETWEEN 24250 AND 24749.99 THEN
    SET sss_deduction = 1102.50;
  ELSE
    SET sss_deduction = 1125.00;
  END IF;

  RETURN sss_deduction;
END //

DELIMITER ;

INSERT INTO sss_cont (employee_number, SSSID, monthly_salary, sss_deduction)
SELECT
  e.employee_id AS employee_number,
  e.sss_number AS SSSID,
  p.MonthlyRate AS monthly_salary,
  compute_sss_deduction(p.MonthlyRate) AS sss_deduction
FROM Employees AS e
JOIN Payslip AS p ON e.employee_id = p.Employee_ID;


SELECT * FROM sss_cont;

CREATE TABLE philhealth_cont (
  employee_id INT NOT NULL,
  philhealth_number VARCHAR(12) NOT NULL,
  basic_salary DECIMAL(10, 2) NOT NULL,
  philhealth_deduction DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (employee_id)
);

DELIMITER //

CREATE FUNCTION compute_philhealth_deduction(basic_salary DECIMAL(10, 2))
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
  DECLARE philhealth_deduction DECIMAL(10, 2);

  IF basic_salary <= 10000 THEN
    SET philhealth_deduction = 300 * 0.5; -- Employee share is 50%
  ELSEIF basic_salary <= 59999.99 THEN
    SET philhealth_deduction = basic_salary * 0.03 * 0.5; -- 3% of the salary, then employee share is 50%
  ELSE
    SET philhealth_deduction = 1800 * 0.5; -- 3% of 60000 is 1800, then employee share is 50%
  END IF;

  RETURN philhealth_deduction;
END //

DELIMITER ;

INSERT INTO philhealth_cont (employee_id, philhealth_number, basic_salary, philhealth_deduction)
SELECT
  e.employee_id,
  e.philhealth_number,
  p.MonthlyRate,
  compute_philhealth_deduction(p.MonthlyRate) AS philhealth_deduction
FROM Employees AS e
JOIN Payslip AS p ON e.employee_id = p.Employee_ID;
  
  SELECT *FROM philhealth_cont;
 

CREATE TABLE pagibig_cont (
  employee_id INT NOT NULL,
  pagibig_id VARCHAR(15) NOT NULL,
  monthly_salary DECIMAL(10, 2) NOT NULL,
  pagibig_deduction DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (employee_id)
);

DELIMITER //

CREATE FUNCTION compute_pagibig_deduction(monthly_salary DECIMAL(10, 2))
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
  DECLARE pagibig_deduction DECIMAL(10, 2);


  IF monthly_salary BETWEEN 1000 AND 1500 THEN
    SET pagibig_deduction = LEAST(monthly_salary * 0.03, 100.00);
  ELSE
    SET pagibig_deduction = LEAST(monthly_salary * 0.04, 100.00);
  END IF;

  RETURN pagibig_deduction;
END //

DELIMITER ;


INSERT INTO pagibig_cont (employee_id, pagibig_id, monthly_salary, pagibig_deduction)
SELECT
  e.employee_id,
  e.pagibig_number,
  p.MonthlyRate,
  compute_pagibig_deduction(p.MonthlyRate) AS pagibig_deduction
FROM Employees AS e
JOIN Payslip AS p ON e.employee_id = p.Employee_ID;


SELECT * FROM pagibig_cont;

CREATE TABLE Tax (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    monthly_salary DECIMAL(10, 2),
    sss_deduction DECIMAL(10, 2),
    philhealth_deduction DECIMAL(10, 2),
    pagibig_deduction DECIMAL(10, 2),
    total_deductions DECIMAL(10, 2),
    taxable_income DECIMAL(10, 2),
    withholding_tax DECIMAL(10, 2),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);


DELIMITER //

CREATE FUNCTION calculate_tax(taxable_income DECIMAL(10, 2)) RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
  DECLARE tax DECIMAL(10, 2);

  IF taxable_income <= 20832 THEN
      SET tax = 0;
  ELSEIF taxable_income > 20832 AND taxable_income <= 33333 THEN
      SET tax = (taxable_income - 20833) * 0.2;
  ELSEIF taxable_income > 33333 AND taxable_income <= 66667 THEN
      SET tax = 2500 + ((taxable_income - 33333) * 0.25);
  ELSEIF taxable_income > 66667 AND taxable_income <= 166667 THEN
      SET tax = 10833 + ((taxable_income - 66667) * 0.3);
  ELSEIF taxable_income > 166667 AND taxable_income <= 666667 THEN
      SET tax = 40833 + ((taxable_income - 166667) * 0.32);
  ELSE
      SET tax = 200833 + ((taxable_income - 666667) * 0.35);
  END IF;

  RETURN tax;
END //

DELIMITER ;


INSERT INTO Tax (employee_id, monthly_salary, sss_deduction, philhealth_deduction, pagibig_deduction, total_deductions, taxable_income, withholding_tax)
SELECT
    p.Employee_ID,
    p.MonthlyRate,
    compute_sss_deduction(p.MonthlyRate) AS sss_deduction,
    compute_philhealth_deduction(p.MonthlyRate) AS philhealth_deduction,
    compute_pagibig_deduction(p.MonthlyRate) AS pagibig_deduction,
    (compute_sss_deduction(p.MonthlyRate) + compute_philhealth_deduction(p.MonthlyRate) + compute_pagibig_deduction(p.MonthlyRate)) AS total_deductions,
    p.MonthlyRate - (compute_sss_deduction(p.MonthlyRate) + compute_philhealth_deduction(p.MonthlyRate) + compute_pagibig_deduction(p.MonthlyRate)) AS taxable_income,
    calculate_tax(p.MonthlyRate - (compute_sss_deduction(p.MonthlyRate) + compute_philhealth_deduction(p.MonthlyRate) + compute_pagibig_deduction(p.MonthlyRate))) AS withholding_tax
FROM Payslip p;

    SELECT * FROM Tax;
    

    
    
   CREATE TABLE attendance (
   attendance_id INT Primary key auto_increment,
    employee_id INT,
    employee_name VARCHAR(50),
    date date,
    time_in TIME,
    time_out TIME,
    hours_worked TIME,
    overtime_hours TIME
);

SELECT * FROM attendance;  

CREATE VIEW attendance_view AS
SELECT 
  a.employee_id,
  e.last_name,
  e.first_name,
  a.date,
  a.time_in,
  a.time_out,
  a.overtime_hours
FROM 
  attendance a
JOIN 
  Employees e ON a.employee_id = e.employee_id;
  
  SELECT * FROM attendance_view;

CREATE TABLE Position (
  Position_ID INT PRIMARY KEY,
  Department_ID VARCHAR(255),
  PositionName VARCHAR(255)
);

INSERT INTO Position (Position_ID, Department_ID, PositionName) VALUES
(1, 'Executive', 'Chief Executive Officer'),
(2, 'Executive', 'Chief Operating Officer'),
(3, 'Executive', 'Chief Finance Officer'),
(4, 'Executive', 'Chief Marketing Officer'),
(5, 'IT', 'IT Operations and Systems'),
(6, 'HR', 'HR Manager'),
(7, 'HR', 'HR Team Leader'),
(8, 'HR', 'HR Rank and File'),
(9, 'HR', 'HR Rank and File'),
(10, 'Finance', 'Accounting Head'),
(11, 'Finance', 'Payroll Manager'),
(12, 'Finance', 'Payroll Team Leader'),
(13, 'Finance', 'Payroll Rank and File'),
(14, 'Finance', 'Payroll Rank and File'),
(15, 'Account Management', 'Account Manager'),
(16, 'Account Management', 'Account Team Leader'),
(17, 'Account Management', 'Account Team Leader'),
(18, 'Account Management', 'Account Rank and File'),
(19, 'Account Management', 'Account Rank and File'),
(20, 'Account Management', 'Account Rank and File'),
(21, 'Account Management', 'Account Rank and File'),
(22, 'Account Management', 'Account Rank and File'),
(23, 'Account Management', 'Account Rank and File'),
(24, 'Account Management', 'Account Rank and File'),
(25, 'Account Management', 'Account Rank and File'),
(26, 'Account Management', 'Account Rank and File'),
(27, 'Account Management', 'Account Rank and File'),
(28, 'Account Management', 'Account Rank and File'),
(29, 'Account Management', 'Account Rank and File'),
(30, 'Account Management', 'Account Rank and File'),
(31, 'Account Management', 'Account Rank and File'),
(32, 'Sales and Marketing', 'Sales & Marketing'),
(33, 'Resources', 'Supply Chain and Logistics'),
(34, 'CSR', 'Customer Service and Relations');

SELECT * FROM Position;

CREATE TABLE employee_leave (
    employee_id INT PRIMARY KEY,
    last_name VARCHAR(50),
    first_name VARCHAR(50),
    sick_leave INT,
    vacation_leave INT,
    emergency_leave INT
);

INSERT INTO employee_leave (employee_id, last_name, first_name, sick_leave, vacation_leave, emergency_leave) VALUES
('1', 'Garcia', 'Manuel III', 5,7,5),
('2', 'Lim', 'Antonio', 5, 7, 5),
('3', 'Aquino', 'Bianca Sofia', 5, 7, 5),
('4', 'Reyes', 'Isabella', 5, 7, 5),
('5', 'Hernandez', 'Eduard', 5, 7, 5),
('6', 'Villanueva', 'Andrea Mae', 5, 7, 5),
('7', 'San Jose', 'Brad', 5, 7, 5),
('8', 'Romualdez', 'Alice', 5, 7, 5),
('9', 'Atienza', 'Rosie', 5, 7, 5),
('10', 'Alvaro', 'Roderick', 5, 7, 5),
('11', 'Salcedo', 'Anthony', 5, 7, 5),
('12', 'Lopez', 'Josie', 5, 7, 5),
('13', 'Farala', 'Martha', 5, 7, 5),
('14', 'Martinez', 'Leila', 5, 7, 5),
('15', 'Romualdez', 'Fredrick', 5, 7, 5),
('16', 'Mata', 'Christian', 5, 7, 5),
('17', 'De Leon', 'Selena', 5, 7, 5),
('18', 'San Jose', 'Allison', 5, 7, 5),
('19', 'Rosario', 'Cydney', 5, 7, 5),
('20', 'Bautista', 'Mark', 5, 7, 5),
('21', 'Lazaro', 'Darlene', 5, 7, 5),
('22', 'Delos Santos', 'Kolby', 5, 7, 5),
('23', 'Santos', 'Vella', 5, 7, 5),
('24', 'Del Rosario', 'Tomas', 5, 7, 5),
('25', 'Tolentino', 'Jacklyn', 5, 7, 5),
('26', 'Gutierrez', 'Percival', 5, 7, 5),
('27', 'Manalaysay', 'Garfield', 5, 7, 5),
('28', 'Villegas', 'Lizeth', 5, 7, 5),
('29', 'Ramos', 'Carol', 5, 7, 5),
('30', 'Maceda', 'Emelia', 5, 7, 5),
('31', 'Aguilar', 'Delia', 5, 7, 5),
('32', 'Castro', 'John Rafael', 5, 7, 5),
('33', 'Martinez', 'Carlos Ian', 5, 7, 5),
('34', 'Santos', 'Beatriz', 5, 7, 5);

SELECT * FROM employee_leave;
SELECT * FROM employee_leave WHERE employee_id = 1;

CREATE TABLE leave_applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    date_filed DATE,
    leave_type VARCHAR(50),
    days INT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employee_leave(employee_id)
);
SELECT * FROM leave_applications;

CREATE VIEW employee_leave_view AS
SELECT 
  el.leave_id,
  el.employee_id,
  e.last_name,
  e.first_name,
  el.date_requested,
  el.start_date,
  el.end_date,
  el.leave_type,
  el.leave_balance,
  el.leave_reason
FROM 
  employee_leave el
JOIN 
  Employees e ON el.employee_id = e.employee_id;

SELECT * FROM employee_leave_view;

CREATE TABLE employee_login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO employee_login (username, password) VALUES
('Manuel', 'Manuel1001'),
('Antonio', 'Antonio1002'),
('Bianca', 'Bianca1003'),
('Isabella', 'Isabella1004'),
('Eduard', 'Eduard1005'),
('Andrea', 'Andrea1006'),
('Brad', 'Brad1006'),
('Alice', 'Alice1007'),
('Rosie', 'Rosie1008'),
('Roderick', 'Roderick1009'),
('Anthony', 'Anthony1010'),
('Josie', 'Josie1011'),
('Martha', 'Martha1012'),
('Leila', 'Leila1013'),
('Fredrick', 'Fredrick1014'),
('Christian', 'Christian1015'),
('Selena', 'Selena1016'),
('Allison', 'Allison1017'),
('Cydney', 'Cydney1018'),
('Mark', 'Mark1019'),
('Darlene', 'Darlene1020'),
('Kolby', 'Kolby1021'),
('Vella', 'Vella1022'),
('Tomas', 'Tomas1023'),
('Jacklyn', 'Jacklyn1024'),
('Percival', 'Percival1025'),
('Garfield', 'Garfield1026'),
('Lizeth', 'Lizeth1027'),
('Carol', 'Carol1028'),
('Emelia', 'Emelia1029'),
('Delia', 'Delia1030'),
('John', 'John1031'),
('Carlos', 'Carlos1032'),
('Beatriz', 'Beatriz1033');

SELECT * FROM employee_login;


CREATE TABLE admin_login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO admin_login (username, password) VALUES
('Andrea', 'Andrea1006'),
('Brad', 'Brad1007'),
('Bianca', 'Bianca1003'),
('Roderick', 'Roderick1010'),
('Anthony', 'Anthony1011'),
('Christian', 'Christian1016'),
('Selena', 'Selena1017');

SELECT * FROM admin_login;

CREATE VIEW EmployeePayslipView AS
SELECT
    e.employee_id,
    CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
    CONCAT(pos.PositionName, ' / ', pos.Department_ID) AS employee_position_department,
    MAX(p.PaySlip_ID) AS PaySlip_ID,  -- Assuming you want the latest Payslip ID
    MAX(p.PeriodStartDate) AS PeriodStartDate,
    MAX(p.PeriodEndDate) AS PeriodEndDate,
    MAX(p.MonthlyRate) AS MonthlyRate,
    MAX(p.DailyRate) AS DailyRate,
    MAX(p.DaysWorked) AS DaysWorked,
    MIN(a.overtime_hours) AS Overtime_hours,
    (MAX(p.DailyRate) * MAX(p.DaysWorked)) AS GrossIncome,
    MAX(p.RiceSubsidy) AS RiceSubsidy,
    MAX(p.PhoneAllowance) AS PhoneAllowance,
    MAX(p.ClothingAllowance) AS ClothingAllowance,
    (MAX(p.RiceSubsidy) + MAX(p.PhoneAllowance) + MAX(p.ClothingAllowance)) AS TotalBenefits,
    COALESCE(MAX(sss.sss_deduction), 0) AS SSSDeduction,
    COALESCE(MAX(ph.philhealth_deduction), 0) AS PhilhealthDeduction,
    COALESCE(MAX(pi.pagibig_deduction), 0) AS PagibigDeduction,
    COALESCE(MAX(wt.withholding_tax), 0) AS TaxDeduction,
    (COALESCE(MAX(sss.sss_deduction), 0) + COALESCE(MAX(ph.philhealth_deduction), 0) + COALESCE(MAX(pi.pagibig_deduction), 0) + COALESCE(MAX(wt.withholding_tax), 0)) AS TotalDeductions,
    ((MAX(p.DailyRate) * MAX(p.DaysWorked)) + MAX(p.RiceSubsidy) + MAX(p.PhoneAllowance) + MAX(p.ClothingAllowance) - COALESCE(MAX(sss.sss_deduction), 0) - COALESCE(MAX(ph.philhealth_deduction), 0) - COALESCE(MAX(pi.pagibig_deduction), 0) - COALESCE(MAX(wt.withholding_tax), 0)) AS TakeHomePay
FROM
    Employees e
    JOIN Payslip p ON e.employee_id = p.Employee_ID
    LEFT JOIN SSS_cont sss ON e.employee_id = sss.employee_number
    LEFT JOIN Philhealth_cont ph ON e.employee_id = ph.employee_id
    LEFT JOIN Pagibig_cont pi ON e.employee_id = pi.employee_id
    LEFT JOIN Tax wt ON e.employee_id = wt.employee_id
    LEFT JOIN Position pos ON e.position = pos.PositionName
    LEFT JOIN attendance a ON e.employee_id = a.employee_id
GROUP BY
    e.employee_id, e.first_name, e.last_name, pos.PositionName, pos.Department_ID;

-- Select data from the updated EmployeePayslipView
SELECT * FROM EmployeePayslipView;


CREATE VIEW monthlypayrollsummary AS
SELECT
    e.employee_id AS EmployeeNo,
    CONCAT(e.first_name, ' ', e.last_name) AS EmployeeFullName,
    pos.PositionName AS Position,
    pos.Department_ID AS Department,
    p.GrossIncome AS GrossIncome,
    sss.sssid AS SocialSecurityNo,
    sss.sss_deduction AS SocialSecurityContribution,
    ph.philhealth_number AS PhilhealthNo,
    ph.philhealth_deduction AS PhilhealthContribution,
    pi.pagibig_id AS PagibigNo,
    pi.pagibig_deduction AS PagibigContribution,
    e.tin_number AS TIN,
    wt.withholding_tax AS WithholdingTax,
    ((p.GrossIncome - COALESCE(sss.sss_deduction, 0) - COALESCE(ph.philhealth_deduction, 0) - COALESCE(pi.pagibig_deduction, 0) - COALESCE(wt.withholding_tax, 0)) + 
        COALESCE(p.RiceSubsidy, 0) + COALESCE(p.PhoneAllowance, 0) + COALESCE(p.ClothingAllowance, 0)) AS NetPay
FROM
    Employees e
    JOIN Payslip p ON e.employee_id = p.Employee_ID
    LEFT JOIN SSS_cont sss ON e.employee_id = sss.employee_number
    LEFT JOIN Philhealth_cont ph ON e.employee_id = ph.employee_id
    LEFT JOIN Pagibig_cont pi ON e.employee_id = pi.employee_id
    LEFT JOIN Tax wt ON e.employee_id = wt.employee_id
    LEFT JOIN Position pos ON e.position = pos.PositionName
GROUP BY
    e.employee_id, e.first_name, e.last_name, pos.PositionName, pos.Department_ID, p.GrossIncome, sss.sssid, sss.sss_deduction,
    ph.philhealth_number, ph.philhealth_deduction, pi.pagibig_id, pi.pagibig_deduction, e.tin_number, wt.withholding_tax, 
    p.RiceSubsidy, p.PhoneAllowance, p.ClothingAllowance;



SELECT * FROM MonthlyPayrollSummary;

SELECT * FROM employees;
