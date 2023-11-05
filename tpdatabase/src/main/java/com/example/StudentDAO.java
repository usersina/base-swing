package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
    private DBConnection dbConn;

    public StudentDAO() throws SQLException {
        dbConn = new DBConnection();
    }

    public void addStudent(int id, String firstname, String lastname, double average) {
        try {
            PreparedStatement ps = dbConn.conn.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setDouble(4, average);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot insert new student: " + e.getMessage());
        }
    }

    public ResultSet getStudents(String query) throws SQLException {
        if (query == null) {
            query = "SELECT * FROM student";
        }
        Statement st = dbConn.getConnection().createStatement();
        st.executeQuery(query);
        return st.getResultSet();
    }

    public void printStudents(ResultSet rs) {
        try {
            while (rs.next()) {
                String result = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4);
                System.out.println(result);
            }
        } catch (SQLException e) {
            System.out.println("Cannot print students: " + e.getMessage());
        }
    }
}
