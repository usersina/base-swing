package com.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            new GestionEtudiant().setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}