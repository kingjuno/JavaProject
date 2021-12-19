import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sqlUtils.ConnectDB;
import sqlUtils.CreateFeedBackTable;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.util.Hashtable;
import java.util.Vector;

public class viewFeedback extends JFrame{
    JButton Artist_Info_Button, Song_Info_Button, Album_Info_Button;
    JButton BACK, SUBMIT;
    JPanel feedback_infoWindow, FunctionButton, Container;
    JLabel feedback, username, songid;
    JTextField feedbackInput, usernameInput, songidInput;
    Connection con;
    Hashtable<String, String> userdata;
    JTable table;

    viewFeedback(Connection con, String songid) {
        this.con = con;
        setTitle("Music Recording Management System");

        feedback_infoWindow = new JPanel();
        this.getContentPane().add(feedback_infoWindow);
        feedback_infoWindow.setLayout(null);
        feedback_infoWindow.setBackground(new Color(68, 67, 68));
        this.setBounds(100, 100, 564, 450);

        String sql = "SELECT * FROM feedback_info where song_id = ?;";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, songid);
            ResultSet rs = pstmt.executeQuery();
            // System.out.println(rs.next());
            table = new JTable(buildTableModel(rs));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(65, 70, 400, 300);
            // feedback_infoWindow.add(table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // feedback_infoWindow.add(table);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));

    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
}