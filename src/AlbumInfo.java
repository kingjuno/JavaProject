import javax.swing.*;

import sqlUtils.CheckForData;
import sqlUtils.CreateAlbumTable;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.util.Hashtable;

public class AlbumInfo extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button,Album_Info_Button;
    JButton ADD, UPDATE, REMOVE, CLEAR, BACK;
    JPanel AlbumInfoWindow, FunctionButton, Container;
    JLabel AlbumID, AlbumName, ArtistID, no_of_songs, release_date;
    JTextField AlbumIDInput, AlbumNameInput, ArtistIDInput, no_of_songsInput, release_dateInput;
    Connection con;
    Hashtable<String, String> userdata;

    AlbumInfo(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");

        Artist_Info_Button = new JButton("Artist Info");
        Artist_Info_Button.addActionListener(this);
        Song_Info_Button = new JButton("Song Info");
        Song_Info_Button.addActionListener(this);
        Album_Info_Button = new JButton("Album Info");
        Album_Info_Button.addActionListener(this);

        AlbumInfoWindow = new JPanel();
        this.getContentPane().add(AlbumInfoWindow);
        AlbumInfoWindow.setLayout(null);
        AlbumInfoWindow.setBackground(new Color(68, 67, 68));
        this.setBounds(100, 100, 564, 450);

        AlbumInfoWindow.add(Artist_Info_Button);
        Artist_Info_Button.setBounds(24, 10, 142, 30);
        AlbumInfoWindow.add(Song_Info_Button);
        Song_Info_Button.setBounds(205, 10, 142, 30);
        AlbumInfoWindow.add(Album_Info_Button);
        Album_Info_Button.setBounds(381, 10, 142, 30);

        AlbumID = new JLabel("Album ID");
        AlbumName = new JLabel("Album Name");
        ArtistID = new JLabel("ArtistID");
        no_of_songs = new JLabel("no. of songs");
        release_date = new JLabel("release_date");

        AlbumIDInput = new JTextField();
        AlbumNameInput = new JTextField();
        ArtistIDInput = new JTextField();
        no_of_songsInput = new JTextField();
        release_dateInput = new JTextField();

        ADD = new JButton("ADD");
        ADD.addActionListener(this);
        UPDATE = new JButton("UPDATE");
        UPDATE.addActionListener(this);
        REMOVE = new JButton("REMOVE");
        REMOVE.addActionListener(this);
        CLEAR = new JButton("CLEAR");
        CLEAR.addActionListener(this);
        BACK = new JButton("BACK");
        BACK.addActionListener(this);

        AlbumID.setBounds(65, 70, 100, 30);
        AlbumID.setForeground(Color.WHITE);
        AlbumName.setBounds(65, 110, 100, 30);
        AlbumName.setForeground(Color.WHITE);
        ArtistID.setBounds(65, 150, 100, 30);
        ArtistID.setForeground(Color.WHITE);
        no_of_songs.setBounds(65, 190, 100, 30);
        no_of_songs.setForeground(Color.WHITE);
        release_date.setBounds(65, 230, 100, 30);
        release_date.setForeground(Color.WHITE);

        AlbumIDInput.setBounds(210, 70, 285, 30);
        AlbumNameInput.setBounds(210, 110, 285, 30);
        ArtistIDInput.setBounds(210, 150, 285, 30);
        no_of_songsInput.setBounds(210, 190, 285, 30);
        release_dateInput.setBounds(210, 230, 285, 30);

        ADD.setBounds(65, 330, 100, 30);
        UPDATE.setBounds(175, 330, 100, 30);
        REMOVE.setBounds(285, 330, 100, 30);
        CLEAR.setBounds(395, 330, 100, 30);
        BACK.setBounds(225, 370, 100, 30);

        AlbumInfoWindow.add(AlbumID);
        AlbumInfoWindow.add(AlbumName);
        AlbumInfoWindow.add(ArtistID);
        AlbumInfoWindow.add(no_of_songs);
        AlbumInfoWindow.add(release_date);
        AlbumInfoWindow.add(AlbumIDInput);
        AlbumInfoWindow.add(AlbumNameInput);
        AlbumInfoWindow.add(ArtistIDInput);
        AlbumInfoWindow.add(no_of_songsInput);
        AlbumInfoWindow.add(release_dateInput);
        AlbumInfoWindow.add(ADD);
        AlbumInfoWindow.add(UPDATE);
        AlbumInfoWindow.add(REMOVE);
        AlbumInfoWindow.add(CLEAR);
        AlbumInfoWindow.add(BACK);

        add(AlbumInfoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Album_Info_Button) {
            this.dispose();
            try {
                AlbumInfo form = new AlbumInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return;
        } else if (ae.getSource() == Artist_Info_Button){
            this.dispose();
            try{
                ArtistInfo form = new ArtistInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else if (ae.getSource() == Song_Info_Button) {
            this.dispose();
            try {

                SongInfo form = new SongInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return;
        } else if (ae.getSource() == BACK) {
            this.dispose();
            try {

                Home form = new Home(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return;
        } else if (ae.getSource() == CLEAR) {
            try {
                AlbumIDInput.setText("");
                AlbumNameInput.setText("");
                ArtistIDInput.setText("");
                no_of_songsInput.setText("");
                release_dateInput.setText("");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        try {
            String AlbumID = AlbumIDInput.getText();
            String AlbumName = AlbumNameInput.getText();
            String ArtistID = ArtistIDInput.getText();
            String no_of_songs = no_of_songsInput.getText();
            long no_of_songs_number = 0;
            if (ae.getSource() != REMOVE)
                no_of_songs_number = Long.parseLong(no_of_songs);
            String release_date = release_dateInput.getText();
            java.sql.Date sqlDate = null;
            if (ae.getSource() != REMOVE) {
                java.util.Date date = new java.util.Date(release_date);
                sqlDate = new java.sql.Date(date.getTime());
            }
            if (ae.getSource() == ADD) {
                // check if any content is empty
                if (AlbumID.equals("") || AlbumName.equals("") || ArtistID.equals("") || no_of_songs.equals("")
                        || release_date.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                String query = "select * from artist_info where artist_id = '" + ArtistID + "'";
                CheckForData check = new CheckForData(con);
                if (!check.check_data_exist(query)) {
                    JOptionPane.showMessageDialog(null, "Artist ID does not exist");
                    return;
                }
                try {
                    String sql = "SELECT * FROM Album_info";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.executeQuery();
                } catch (Exception e) {
                    CreateAlbumTable form = new CreateAlbumTable(con);
                    form.createTable();
                    JOptionPane.showMessageDialog(null, "Album Info Table is created");
                }
                try {
                    String sql = "INSERT INTO Album_info (Album_ID, AlbumName, Artist_ID, no_of_songs, release_date) VALUES (?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, AlbumID);
                    pst.setString(2, AlbumName);
                    pst.setString(3, ArtistID);
                    pst.setLong(4, no_of_songs_number);
                    pst.setDate(5, sqlDate);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Album Added");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (ae.getSource() == UPDATE) {
                try {
                    String sql = "SELECT * FROM Album_info where Album_id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, AlbumID);
                    ResultSet rs = pst.executeQuery();
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Add Album Details first");
                    } else {
                        String sql1 = "UPDATE Album_info SET AlbumName = ?, no_of_songs = ?, release_date = ? WHERE Album_id = ?";
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                        pst1.setString(1, AlbumName);
                        pst1.setLong(2, no_of_songs_number);
                        pst1.setDate(3, sqlDate);
                        pst1.setString(4, AlbumID);
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Album Details Updated");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (ae.getSource() == REMOVE) {
                try {
                    String sql = "SELECT * FROM Album_info where Album_id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, AlbumID);
                    ResultSet rs = pst.executeQuery();
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Add Album Details first");
                    } else {
                        String sql1 = "DELETE FROM Album_info WHERE Album_id = ?";
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                        pst1.setString(1, AlbumID);
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Album Removed");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input");
            return;
        }

    }
}
