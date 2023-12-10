package com.example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Principale extends JFrame {

	JSplitPane jsp = new JSplitPane();

	JButton btnrecherche = new JButton("Recherche article");
	JButton btnaffiche = new JButton("Liste articles");

	// Needed to avoid duplicate windows
	Affiche affiche = null;
	Recherche recherche = null;

	public Principale() {
		this.setTitle("Inventaire");
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JDesktopPane desktopPane = new JDesktopPane();

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 1));
		p1.add(btnaffiche);
		p1.add(btnrecherche);

		jsp.setLeftComponent(p1);
		jsp.setRightComponent(desktopPane);

		this.setContentPane(jsp);

		/**
		 * 
		 * afficher les fenetres dans la partie droite du splitpane au lieu des fenetres
		 * externes
		 * (4points)
		 */
		btnaffiche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (affiche == null) {
						affiche = new Affiche();
						desktopPane.add(affiche);
					}
					affiche.setVisible(true);
					affiche.setLocation(0, 0);
					affiche.moveToFront();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		btnrecherche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (recherche == null) {
						recherche = new Recherche();
						desktopPane.add(recherche);
					}
					recherche.setVisible(true);
					recherche.setLocation(0, 0);
					recherche.moveToFront();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
