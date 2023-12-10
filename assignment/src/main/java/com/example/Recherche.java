package com.example;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Recherche extends JInternalFrame {

	JLabel lbd = new JLabel("Saisir l'id de l'article");
	JTextField tfrech = new JTextField(15);
	JButton btnValidate = new JButton("Valider");

	JLabel lb1 = new JLabel("Id");
	JLabel lb2 = new JLabel("Nom");
	JLabel lb3 = new JLabel("Quantite");
	JLabel lb4 = new JLabel("Locale");
	JTextField tfi = new JTextField(15);
	JTextField tfn = new JTextField(15);
	JTextField tfq = new JTextField(15);
	JTextField tfl = new JTextField(15);

	Integer selectedId = null;

	Recherche() throws SQLException {
		this.setSize(700, 400);
		this.setTitle("Liste des articles");
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel p1 = new JPanel();
		p1.add(lbd);
		p1.add(tfrech);

		this.add(p1, BorderLayout.NORTH);

		JPanel p2 = new JPanel();
		p2.setLayout(null);
		lb1.setBounds(100, 10, 250, 25);
		p2.add(lb1);
		tfi.setBounds(100, 40, 250, 25);
		p2.add(tfi);
		lb2.setBounds(100, 70, 250, 25);
		p2.add(lb2);
		tfn.setBounds(100, 100, 250, 25);
		p2.add(tfn);
		lb3.setBounds(100, 130, 250, 25);
		p2.add(lb3);
		tfq.setBounds(100, 160, 250, 25);
		p2.add(tfq);
		lb4.setBounds(100, 190, 250, 25);
		p2.add(lb4);
		tfl.setBounds(100, 210, 250, 25);
		p2.add(tfl);
		btnValidate.setBounds(350, 240, 150, 40);
		p2.add(btnValidate);

		this.add(p2, BorderLayout.CENTER);

		ItemDAO itemDAO = new ItemDAO();

		/**
		 * rechercher l'id saisie dans la zone de recherche tfrech, lors de l'appuie sur
		 * le CLAVIER
		 * et afficher les donn�es de l'element trouv� dans les zones de saisies
		 * (4point)
		 * 
		 * le bouton valide met � jour la base selon les valeurs saisies
		 * (4points)
		 */
		tfrech.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				String currentText = tfrech.getText();
				System.out.println(currentText);
				try {
					selectedId = Integer.parseInt(currentText);
					ResultSet rs = itemDAO.getItem(selectedId);

					rs.next();
					tfi.setText(rs.getString(1));
					tfn.setText(rs.getString(2));
					tfq.setText(rs.getString(3));
					tfl.setText(rs.getString(4));
				} catch (NumberFormatException e) {
					System.out.println(currentText + " is not a number");
					tfi.setText("");
					tfn.setText("");
					tfq.setText("");
					tfl.setText("");
					selectedId = null;
				} catch (SQLException e) {
					e.printStackTrace();
					tfi.setText("");
					tfn.setText("");
					tfq.setText("");
					tfl.setText("");
					selectedId = null;
				}
			}
		});

		btnValidate.addActionListener(e -> {
			try {
				itemDAO.updateItem(selectedId, tfn.getText(), Integer.parseInt(tfq.getText()), tfl.getText());
				JOptionPane.showMessageDialog(
						this,
						"Item updated successfully.",
						"Success",
						JOptionPane.INFORMATION_MESSAGE //
				);
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(
						this,
						"Error while updating item.",
						"Error",
						JOptionPane.ERROR_MESSAGE //
				);
			}
		});

	}
}
