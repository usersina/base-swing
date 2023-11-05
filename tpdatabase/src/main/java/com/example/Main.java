package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO;
        try {
            studentDAO = new StudentDAO();
            studentDAO.addStudent(0, "Test 1", "Tester", 10);
            studentDAO.addStudent(1, "Test 2", "Tester", 15);
            studentDAO.addStudent(2, "Test 3", "Tester", 13.5);

            ResultSet rs = studentDAO.getStudents(null);
            studentDAO.printStudents(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}