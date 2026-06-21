DROP TABLE IF EXISTS Employees;

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(50),
    Department VARCHAR(50),
    Salary NUMERIC(10,2)
);

INSERT INTO Employees VALUES
(1,'Madhu','IT',50000),
(2,'Ramya','HR',45000),
(3,'Priya','Finance',60000);

CREATE OR REPLACE FUNCTION CalculateAnnualSalary(
    monthly_salary NUMERIC
)
RETURNS NUMERIC
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN monthly_salary * 12;
END;
$$;

SELECT
    EmployeeID,
    EmployeeName,
    Salary,
    CalculateAnnualSalary(Salary) AS AnnualSalary
FROM Employees;