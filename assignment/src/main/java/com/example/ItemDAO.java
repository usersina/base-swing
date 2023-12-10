package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDAO {
    private DBConnection dbConn;

    public ItemDAO() throws SQLException {
        dbConn = new DBConnection();
    }

    /**
     * Get all items given a query. If query is null, get all items.
     *
     * @param query
     * @return a result set of items
     * @throws SQLException
     */
    public ResultSet getItems(String query) throws SQLException {
        if (query == null) {
            query = "SELECT * FROM items";
        }
        Statement st = dbConn.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE //
        );
        st.executeQuery(query);
        return st.getResultSet();
    }

    /**
     * Get an item by id.
     *
     * @param id
     * @return a result set with one item
     * @throws SQLException
     */
    public ResultSet getItem(int id) throws SQLException {
        String query = "SELECT * FROM items WHERE id=" + id;
        Statement st = dbConn.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE //
        );
        st.executeQuery(query);
        return st.getResultSet();
    }

    public void updateItem(int id, String nom, int quantite, String locale) throws SQLException {
        Statement st = dbConn.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE //
        );
        String query = "UPDATE items SET nom='" + nom + "', quantite=" + quantite + ", locale='" + locale
                + "' WHERE id=" + id;
        st.executeUpdate(query);
    }

    public void printItems(ResultSet rs) {
        try {
            while (rs.next()) {
                String result = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4);
                System.out.println(result);
            }
        } catch (SQLException e) {
            System.out.println("Cannot print items: " + e.getMessage());
        }
    }
}
