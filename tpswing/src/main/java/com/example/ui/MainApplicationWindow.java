package com.example.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.example.util.JFrameDraggable;

public class MainApplicationWindow extends JFrameDraggable {
    private JMenuBar mainMenuBar;
    private JMenu appMenu;
    private JMenuItem manageProfilesMenuItem;

    public MainApplicationWindow() {
        this.setTitle("Java Swing Project");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        mainMenuBar = new JMenuBar();
        appMenu = new JMenu("Actions");
        manageProfilesMenuItem = new JMenuItem("Manage Profiles");

        // Add components to containers
        appMenu.add(manageProfilesMenuItem);
        mainMenuBar.add(appMenu);
        this.setJMenuBar(mainMenuBar);

        // Add event listeners
        manageProfilesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfileManager().setVisible(true);
            }
        });
    }
}