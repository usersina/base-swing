package com.example;

import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Affiche extends JInternalFrame {

	JTable jt;

	Affiche() throws SQLException {
		this.setSize(900, 500);
		this.setTitle("Liste des articles");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		/**
		 * afficher les donnees de la base
		 * (8points)
		 */
		jt = new JTable();

		ItemDAO itemDAO = new ItemDAO();
		TableModel model = new TableModel(
				itemDAO.getItems(null),
				"nom" //
		);
		jt.setModel(model);

		this.add(new JScrollPane(jt));

	}

}
