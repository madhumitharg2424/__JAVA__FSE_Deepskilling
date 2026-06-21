
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerName VARCHAR(50),
    AccountType VARCHAR(20),
    Balance NUMERIC(10,2)
);

INSERT INTO Accounts VALUES
(1,'Madhu','Savings',5000),
(2,'Ramya','Checking',15000),
(3,'Priya','Savings',10000);

CREATE OR REPLACE PROCEDURE ApplyInterest()
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.015)
    WHERE AccountType = 'Savings';
END;
$$;

CREATE OR REPLACE PROCEDURE TransferFunds(
    IN from_account INT,
    IN to_account INT,
    IN transfer_amount NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE Accounts
    SET Balance = Balance - transfer_amount
    WHERE AccountID = from_account;

    UPDATE Accounts
    SET Balance = Balance + transfer_amount
    WHERE AccountID = to_account;
END;
$$;

CALL ApplyInterest();

CALL TransferFunds(1,2,300);

SELECT * FROM Accounts ORDER BY AccountID;