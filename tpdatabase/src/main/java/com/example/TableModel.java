package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    private ResultSet rs;

    /**
     * Constructor
     *
     * @param rs needs to be scrollable and updatable
     */
    public TableModel(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return rs.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rs.getMetaData().getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
