package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Profils extends JFrame {
    ArrayList<Profil> data = new ArrayList<Profil>();
    DefaultListModel model;
    JTabbedPane jtp;
    // Declaration
    JLabel lb_nom, lb_prenom, lb_pseudo, lb_help;
    JTextField tf_nom, tf_prenom, tf_pseudo;
    JButton btnvalider;

    JList jlist_profil;
    JSplitPane jsp;

    Profils() {
        this.setTitle("Gestion profil");
        this.setSize(750, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setFocusable(true);

        lb_nom = new JLabel("Nom");
        lb_prenom = new JLabel("Prenom");
        lb_pseudo = new JLabel("Pseudo");
        tf_nom = new JTextField(15);
        tf_nom.setText("Tapper votre nom");
        tf_prenom = new JTextField(15);
        tf_prenom.setText("Tapper votre prenom");
        tf_pseudo = new JTextField(15);
        tf_pseudo.setText("Tapper votre pseudo");
        btnvalider = new JButton("Valider");

        JPanel p_north = new JPanel();
        p_north.setLayout(new FlowLayout());
        p_north.add(lb_nom);
        p_north.add(tf_nom);
        p_north.add(lb_prenom);
        p_north.add(tf_prenom);
        p_north.add(lb_pseudo);
        p_north.add(tf_pseudo);
        p_north.add(btnvalider);

        this.setLayout(new BorderLayout());
        this.add(p_north, BorderLayout.NORTH);

        jsp = new JSplitPane();

        model = new DefaultListModel();
        // model.addElement("SSSSSS");
        jlist_profil = new JList(model);
        jlist_profil.setPreferredSize(new Dimension(150, 0));
        jtp = new JTabbedPane();
        // jtp.addTab("titre1",new JPanel());

        jsp.setLeftComponent(jlist_profil);
        jsp.setRightComponent(jtp);

        this.add(jsp, BorderLayout.CENTER);

        lb_help = new JLabel("Help");
        this.add(lb_help, BorderLayout.SOUTH);

        // Evenement
        btnvalider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TESTER si PSEUdo deja existe
                data.add(new Profil(tf_nom.getText(),
                        tf_prenom.getText(),
                        tf_pseudo.getText()));

                model.addElement(tf_pseudo.getText());
            }
        });

        // Ecouteur label
        lb_nom.addMouseListener(new EcouteurLabel());
        lb_prenom.addMouseListener(new EcouteurLabel());
        lb_pseudo.addMouseListener(new EcouteurLabel());

        // Ecouteur Focus
        tf_nom.addFocusListener(new EcouteurFocus(this));
        tf_prenom.addFocusListener(new EcouteurFocus(this));
        tf_pseudo.addFocusListener(new EcouteurFocus(this));

        tf_nom.addMouseListener(new EcouteurTextField(this));
        tf_prenom.addMouseListener(new EcouteurTextField(this));
        tf_pseudo.addMouseListener(new EcouteurTextField(this));

        jlist_profil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // double click
                    jtp.addTab("titre1", new JPanel());
                    // CORRIGER CETTE PARTIE
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    // click droite
                }
            }
        });
    }// fin constructeur

    class EcouteurLabel implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == lb_nom)
                lb_nom.setForeground(Color.red);
            if (e.getSource() == lb_prenom)
                lb_prenom.setForeground(Color.red);
            if (e.getSource() == lb_pseudo)
                lb_pseudo.setForeground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel lbsource = (JLabel) e.getSource();
            lbsource.setForeground(null);
        }
    }
}