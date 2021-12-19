import javax.swing.*;

import sqlUtils.ConnectDB;
import sqlUtils.CreateFeedBackTable;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.util.Hashtable;

public class feedback_info extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button,Album_Info_Button;
    JButton BACK, SUBMIT;
    JPanel feedback_infoWindow, FunctionButton, Container;
    JLabel feedback,username, songid;
    JTextField feedbackInput, usernameInput, songidInput;
    Connection con;
    Hashtable<String, String> userdata;

    feedback_info(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");

       
        feedback_infoWindow = new JPanel();
        this.getContentPane().add(feedback_infoWindow);
        feedback_infoWindow.setLayout(null);
        feedback_infoWindow.setBackground(new Color(68, 67, 68));
        this.setBounds(100, 100, 564, 450);

        username = new JLabel("username");
        usernameInput = new JTextField(userdata.get("username"));
        usernameInput.setEditable(false);
        username.setBounds(65, 70, 100, 30);
        username.setForeground(Color.WHITE);
        usernameInput.setBounds(210, 70, 285, 30);

        songid = new JLabel("songid");
        songidInput = new JTextField();
        songid.setBounds(65, 120, 100, 30);
        songid.setForeground(Color.WHITE);
        songidInput.setBounds(210, 120, 285, 30);

        feedback = new JLabel("feedback");
        feedbackInput = new JTextField("");
        feedback.setBounds(65, 170, 100, 30);
        feedback.setForeground(Color.WHITE);
        feedbackInput.setBounds(210, 170, 285, 120);

        BACK = new JButton("BACK");
        BACK.setBounds(185, 320, 100, 30);
        BACK.addActionListener(this);
        SUBMIT = new JButton("SUBMIT");
        SUBMIT.setBounds(323, 320, 100, 30);
        SUBMIT.addActionListener(this);

        feedback_infoWindow.add(username);
        feedback_infoWindow.add(usernameInput);
        feedback_infoWindow.add(songid);
        feedback_infoWindow.add(songidInput);
        feedback_infoWindow.add(feedback);
        feedback_infoWindow.add(feedbackInput);      
        feedback_infoWindow.add(BACK);
        feedback_infoWindow.add(SUBMIT);

        add(feedback_infoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BACK) {
            this.dispose();
            Home home = new Home(con, userdata);
            home.setVisible(true);
        } else if (e.getSource() == SUBMIT) {
            String feedback_info = feedbackInput.getText();
            String username = usernameInput.getText();
            String songid = songidInput.getText();

            String sql = "SELECT * FROM song_info where song_id = ?";
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, songid);
                ResultSet rs = pst.executeQuery();
                if (!rs.next()) {
                   JOptionPane.showMessageDialog(null, "Song ID does not exist");
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }

            sql = "SELECT * FROM feedback_info WHERE song_id = ? and user_id = ?";
            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, songid);
                pstmt.setString(2, username);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "This song id has been submitted!");
                } else {
                    String sql2 = "INSERT INTO feedback_info VALUES (?, ?, ?)";
                    try {
                        PreparedStatement pstmt2 = con.prepareStatement(sql2);
                        pstmt2.setString(1, songid);
                        pstmt2.setString(2, username);
                        pstmt2.setString(3, feedback_info);
                        pstmt2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Submit successfully!");
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        }
        
    }
    public static void main(String[] args) {
        String username = "geo";
        String password = "6023";
        String url = "jdbc:postgresql://localhost:5432/music_recording";

        ConnectDB connectDB = new ConnectDB(username, password, url);
        Connection con = connectDB.getConnection();
        
        feedback_info feedback_info = new feedback_info(con, null);
        feedback_info.setVisible(true);
    }
}