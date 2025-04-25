package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Naveen-2002";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS employees");
            System.out.println("Database created ");

            statement.execute("USE employees");

            String createTableemployee = """
                        CREATE TABLE IF NOT EXISTS employee (
                            empNo INT PRIMARY KEY,
                            empName VARCHAR(100),
                            job VARCHAR(50),
                            mgr INT,
                            hireDate DATE,
                            salery DECIMAL(10, 2),
                            comm DECIMAL(10, 2),
                            deptNo INT
                        )
                    """;

            statement.executeUpdate(createTableemployee);
            System.out.println("Table Created");

            String insertData = """
                        INSERT INTO employee (empNo, empName, job, mgr, hireDate, salery, comm, deptNo) VALUES
                        (8369, 'SMITH', 'CLERK', 8902, '1990-12-18', 800.00, NULL, 20),
                        (8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00, 30),
                        (8521, 'SETH', 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00, 30),
                        (8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02', 2985.00, NULL, 20),
                        (8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30),
                        (8698, 'BINA', 'MANAGER', 8839, '1991-05-01', 2850.00, NULL, 30),
                        (8882, 'SHIVANSH', 'MANAGER', 8839, '1991-06-09', 2450.00, NULL, 10),
                        (8888, 'SCOTT', 'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20),
                        (8839, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10),
                        (8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30)
                    """;

            statement.executeUpdate(insertData);
            System.out.println("Data inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}