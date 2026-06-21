DROP TABLE IF EXISTS EmployeeAudit;
DROP TABLE IF EXISTS Employees;

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(50),
    Salary NUMERIC(10,2)
);

CREATE TABLE EmployeeAudit (
    AuditID SERIAL PRIMARY KEY,
    EmployeeID INT,
    ActionPerformed VARCHAR(20),
    ActionDate TIMESTAMP
);

CREATE OR REPLACE FUNCTION LogEmployeeInsert()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO EmployeeAudit(
        EmployeeID,
        ActionPerformed,
        ActionDate
    )
    VALUES(
        NEW.EmployeeID,
        'INSERT',
        CURRENT_TIMESTAMP
    );

    RETURN NEW;
END;
$$;

CREATE TRIGGER EmployeeInsertTrigger
AFTER INSERT
ON Employees
FOR EACH ROW
EXECUTE FUNCTION LogEmployeeInsert();

INSERT INTO Employees VALUES
(1,'Madhu',50000);

INSERT INTO Employees VALUES
(2,'Ramya',45000);

SELECT * FROM Employees;

SELECT * FROM EmployeeAudit;