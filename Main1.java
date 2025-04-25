package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Naveen-2002";


        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS emps");
            System.out.println("Database created ");

            statement.execute("USE emps");

            String createTableemployees = """
                        CREATE TABLE IF NOT EXISTS emp (
                            empCode INT PRIMARY KEY,
                            empName VARCHAR(100),
                            empAge INT,
                            empSalery DECIMAL(10, 2)
                        )
                    """;

            statement.executeUpdate(createTableemployees);
            System.out.println("Table Created");

            String insertDatas = """
                        INSERT INTO emp (empCode,empName,empAge,empSalery) VALUES
                        (101,'Jenny',25,10000.00),
                        (102,'Jacky',30,20000.00),
                        (103,'Joe',20,40000.00),
                        (104,'John',40,80000.00),
                        (105,'Shameer',25,90000.00)
                   
                    """;

            statement.executeUpdate(insertDatas);
            System.out.println("Data inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
