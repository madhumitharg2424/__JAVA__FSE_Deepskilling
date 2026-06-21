DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Customers;

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    City VARCHAR(50)
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT REFERENCES Customers(CustomerID),
    AccountType VARCHAR(20),
    Balance NUMERIC(10,2)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT REFERENCES Customers(CustomerID),
    LoanAmount NUMERIC(10,2),
    InterestRate NUMERIC(5,2)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT REFERENCES Accounts(AccountID),
    TransactionDate DATE,
    Amount NUMERIC(10,2),
    TransactionType VARCHAR(20)
);

INSERT INTO Customers VALUES
(1,'Madhu','Chennai'),
(2,'Ramya','Bangalore'),
(3,'Priya','Hyderabad');

INSERT INTO Accounts VALUES
(101,1,'Savings',50000),
(102,2,'Checking',75000),
(103,3,'Savings',60000);

INSERT INTO Loans VALUES
(201,1,200000,7.5),
(202,2,150000,6.8),
(203,3,250000,8.0);

INSERT INTO Transactions VALUES
(301,101,CURRENT_DATE,5000,'Deposit'),
(302,102,CURRENT_DATE,10000,'Deposit'),
(303,103,CURRENT_DATE,3000,'Withdrawal');

CREATE OR REPLACE PROCEDURE DepositAmount(
    IN acc_id INT,
    IN deposit_amount NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE Accounts
    SET Balance = Balance + deposit_amount
    WHERE AccountID = acc_id;
END;
$$;

CREATE OR REPLACE FUNCTION GetTotalLoanAmount()
RETURNS NUMERIC
LANGUAGE plpgsql
AS $$
DECLARE
    total_loan NUMERIC;
BEGIN
    SELECT SUM(LoanAmount)
    INTO total_loan
    FROM Loans;

    RETURN total_loan;
END;
$$;

CALL DepositAmount(101,5000);

SELECT * FROM Customers;

SELECT * FROM Accounts;

SELECT * FROM Loans;

SELECT * FROM Transactions;

SELECT
    c.CustomerName,
    a.AccountType,
    a.Balance
FROM Customers c
INNER JOIN Accounts a
ON c.CustomerID = a.CustomerID;

SELECT
    c.CustomerName,
    l.LoanAmount,
    l.InterestRate
FROM Customers c
INNER JOIN Loans l
ON c.CustomerID = l.CustomerID;

SELECT GetTotalLoanAmount();

SELECT
    CustomerName,
    Balance
FROM Customers c
INNER JOIN Accounts a
ON c.CustomerID = a.CustomerID
ORDER BY Balance DESC;