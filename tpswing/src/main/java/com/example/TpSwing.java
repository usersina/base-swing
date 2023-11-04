package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.example.utils.JFrameDraggable;

public class TpSwing extends JFrameDraggable {
    JMenuBar menuBar;
    JMenu menutp1;
    JMenuItem itemprofil;

    TpSwing() {
        this.setTitle("Tp Swing");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // initialisation
        menuBar = new JMenuBar();
        menutp1 = new JMenu("Tp 1");
        itemprofil = new JMenuItem(" Gestion Profils");

        menutp1.add(itemprofil);
        menuBar.add(menutp1);
        this.setJMenuBar(menuBar);

        // Evenement
        // ANONYME
        itemprofil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Profils().setVisible(true);
            }
        });
    }

}
