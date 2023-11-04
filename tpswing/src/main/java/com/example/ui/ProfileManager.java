package com.example.ui;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.example.constants.Labels;
import com.example.listener.TextFieldFocusListener;
import com.example.model.UserProfile;
import com.example.util.JFrameDraggable;

public class ProfileManager extends JFrameDraggable {
    ArrayList<UserProfile> data = new ArrayList<UserProfile>();
    DefaultListModel<String> model;
    JTabbedPane jtp;
    public JLabel lb_nom, lb_prenom, lb_pseudo, lb_help;
    public JTextField tf_nom, tf_prenom, tf_pseudo;
    JButton btnvalider;

    JList<String> jlist_profil;
    JSplitPane jsp;

    public ProfileManager() {
        this.setTitle("Gestion profil");
        this.setSize(750, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setFocusable(true);

        lb_nom = new JLabel("Nom");
        lb_prenom = new JLabel("Prenom");
        lb_pseudo = new JLabel("Pseudo");

        tf_nom = new JTextField(15);
        tf_nom.setText(Labels.LASTNAME_LABEL);

        tf_prenom = new JTextField(15);
        tf_prenom.setText(Labels.FIRSTNAME_LABEL);

        tf_pseudo = new JTextField(15);
        tf_pseudo.setText(Labels.NICKNAME_LABEL);

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

        model = new DefaultListModel<String>();
        // model.addElement("SSSSSS");
        jlist_profil = new JList<String>(model);
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
                String newPseudo = tf_pseudo.getText();

                if (newPseudo.equals(Labels.NICKNAME_LABEL)) {
                    // Show error message
                    JOptionPane.showMessageDialog(
                            ProfileManager.this,
                            "Pseudo cannot be empty.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE //
                    );
                    return;
                }

                // Check if pseudo already exists
                boolean pseudoExists = data.stream().anyMatch(profil -> profil.getNickname().equals(newPseudo));

                if (!pseudoExists) {
                    // Add new Profil if pseudo is unique
                    data.add(new UserProfile(tf_nom.getText(), tf_prenom.getText(), newPseudo));
                    model.addElement(newPseudo);
                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(
                            ProfileManager.this,
                            "Pseudo already exists. Please choose a different one.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE //
                    );
                }
            }
        });

        // Ecouteur label
        lb_nom.addMouseListener(new EcouteurLabel());
        lb_prenom.addMouseListener(new EcouteurLabel());
        lb_pseudo.addMouseListener(new EcouteurLabel());

        // Ecouteur Focus
        tf_nom.addFocusListener(new TextFieldFocusListener(this));
        tf_prenom.addFocusListener(new TextFieldFocusListener(this));
        tf_pseudo.addFocusListener(new TextFieldFocusListener(this));

        jlist_profil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // double click
                    String pseudo = jlist_profil.getSelectedValue();

                    // Check if tab with same title already exists
                    for (int i = 0; i < jtp.getTabCount(); i++) {
                        if (jtp.getTitleAt(i).equals(pseudo)) {
                            return; // Exit if tab already exists
                        }
                    }

                    // Add new tab if it doesn't exist
                    jtp.addTab(pseudo, new JPanel());
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    // right click
                    if (jtp.getSelectedIndex() != -1) {
                        jtp.removeTabAt(jtp.getSelectedIndex());
                    }
                }
            }
        });
    }

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
