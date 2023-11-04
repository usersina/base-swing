package com.example.app.scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.setTitle("Hello World");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // ========================================
        JLabel label = new JLabel("Hello World");
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setBackground(Color.RED);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        // ========================================
        JPanel southPanel = new JPanel();
        southPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        southPanel.setLayout(new FlowLayout());

        JButton validateButton = new JButton("Validate");
        southPanel.add(validateButton);

        JButton quitButton = new JButton("Quit");
        southPanel.add(quitButton);

        this.add(southPanel, java.awt.BorderLayout.SOUTH);

        // ========================================
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2));

        JLabel nameLabel = new JLabel("Name:");
        centerPanel.add(nameLabel);

        JTextField nameTextField = new JTextField();
        centerPanel.add(nameTextField);

        JLabel dateLabel = new JLabel("Date:");
        centerPanel.add(dateLabel);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new FlowLayout());

        // Day input
        String[] daysArr = new String[31];
        for (int i = 0; i < 31; i++) {
            daysArr[i] = Integer.toString(i + 1);
        }
        datePanel.add(new JComboBox<String>(daysArr));

        // Month input
        String[] monthsArr = new String[12];
        for (int i = 0; i < 12; i++) {
            monthsArr[i] = Integer.toString(i + 1);
        }
        datePanel.add(new JComboBox<String>(monthsArr));

        // Year input
        String[] yearsArr = new String[200];
        for (int i = 0; i < 200; i++) {
            yearsArr[i] = Integer.toString(i + 1900);
        }
        datePanel.add(new JComboBox<String>(yearsArr));

        centerPanel.add(datePanel);

        // ========================================
        this.add(centerPanel, java.awt.BorderLayout.CENTER);
        this.setVisible(true);

        // ========================================
        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String name = nameTextField.getText();
                System.out.println("Name: " + name);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
    }
}
