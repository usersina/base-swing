package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to connect to the database.
 */
public class DBConnection {
    Connection conn;

    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_tp_db", "root", "root");
    }

    public Connection getConnection() {
        return conn;
    }
}
