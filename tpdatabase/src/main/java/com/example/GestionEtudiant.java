package com.example;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GestionEtudiant extends JFrame {

    JLabel lbnom, lbprenom, lbnumero, lbmoyenne;
    JTextField tfnom, tfprenom, tfnumero, tfmoyenne;
    JButton btnval;
    JTable table;

    GestionEtudiant() throws SQLException {
        this.setTitle("Gestion etudiant");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lbnom = new JLabel("Nom");
        tfnom = new JTextField(12);

        lbprenom = new JLabel("Prenom");
        tfprenom = new JTextField(12);

        lbnumero = new JLabel("Numero");
        tfnumero = new JTextField(12);

        lbmoyenne = new JLabel("Moyenne");
        tfmoyenne = new JTextField(12);

        btnval = new JButton("Valider");

        JPanel pnorth = new JPanel();
        pnorth.add(lbnom);
        pnorth.add(tfnom);
        pnorth.add(lbprenom);
        pnorth.add(tfprenom);
        pnorth.add(lbnumero);
        pnorth.add(tfnumero);
        pnorth.add(lbmoyenne);
        pnorth.add(tfmoyenne);
        pnorth.add(btnval);
        this.add(pnorth, BorderLayout.NORTH);

        table = new JTable();
        this.add(new JScrollPane(table), BorderLayout.CENTER);

        // DAO
        StudentDAO studentDAO = new StudentDAO();

        // table model
        TableModel model = new TableModel(
                studentDAO.getStudents(null),
                "average" //
        );
        table.setModel(model);

        // EVENT
        btnval.addActionListener(e -> {
            String nom = tfnom.getText();
            String prenom = tfprenom.getText();
            int numero = Integer.parseInt(tfnumero.getText());
            double moyenne = Double.parseDouble(tfmoyenne.getText());
            try {
                studentDAO.addStudent(numero, prenom, nom, moyenne);
                // Refresh the result set and fire the table data changed event
                model.setResultSet(studentDAO.getStudents(null));
                model.fireTableDataChanged();
                // clear the text fields
                tfnom.setText("");
                tfprenom.setText("");
                tfnumero.setText("");
                tfmoyenne.setText("");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Cannot insert: " + e1.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE //
                );
            }
        });

    }

    public static void main(String[] args) {
        try {
            new GestionEtudiant().setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
