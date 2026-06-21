CREATE DATABASE db;

USE db;

CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    location VARCHAR(50)
);

CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    designation VARCHAR(50),
    salary DECIMAL(10,2),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id)
);

INSERT INTO Department VALUES
(1,'Information Technology','Chennai'),
(2,'Human Resources','Bangalore'),
(3,'Finance','Hyderabad'),
(4,'Marketing','Mumbai');

INSERT INTO Employee VALUES
(101,'Madhu','Software Engineer',65000,1),
(102,'Ramya','HR Executive',45000,2),
(103,'Priya','Financial Analyst',70000,3),
(104,'Karthik','Software Developer',60000,1),
(105,'Anu','Marketing Executive',50000,4),
(106,'Arun','Software Engineer',75000,1),
(107,'Divya','HR Manager',65000,2);

SELECT * FROM Department;

SELECT * FROM Employee;

SELECT
e.emp_id,
e.emp_name,
e.designation,
e.salary,
d.dept_name,
d.location
FROM Employee e
INNER JOIN Department d
ON e.dept_id = d.dept_id;

SELECT
e.emp_name,
e.salary,
d.dept_name
FROM Employee e
INNER JOIN Department d
ON e.dept_id = d.dept_id
WHERE e.salary > 60000;

SELECT
d.dept_name,
COUNT(e.emp_id) AS employee_count
FROM Department d
INNER JOIN Employee e
ON d.dept_id = e.dept_id
GROUP BY d.dept_name;

SELECT
d.dept_name,
AVG(e.salary) AS average_salary
FROM Department d
INNER JOIN Employee e
ON d.dept_id = e.dept_id
GROUP BY d.dept_name;

UPDATE Employee
SET salary = 80000
WHERE emp_id = 106;

SELECT * FROM Employee WHERE emp_id = 106;

DELETE FROM Employee
WHERE emp_id = 105;

SELECT * FROM Employee;