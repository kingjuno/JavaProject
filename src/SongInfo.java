import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.Connection;
import java.util.Hashtable;
import java.sql.*;

public class SongInfo extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button;
    JButton ADD, UPDATE, REMOVE, CLEAR, BACK;
    JPanel SongInfoWindow, FunctionButton, Container;
    JLabel SongID, SongName, Artist, Duration, Album, Release_Year;
    JTextField SongIDInput, SongNameInput, ArtistInput, DurationInput, AlbumInput, Release_YearInput;
    Connection con;
    Hashtable<String, String> userdata;

    SongInfo(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");
        Artist_Info_Button = new JButton("Artist Info");
        Artist_Info_Button.addActionListener(this);
        Song_Info_Button = new JButton("Song Info");
        Song_Info_Button.addActionListener(this);

        SongInfoWindow = new JPanel();
        this.getContentPane().add(SongInfoWindow);
        SongInfoWindow.setLayout(null);
        SongInfoWindow.setBackground(new Color(68,67,68));
        this.setBounds(100, 100, 564, 450);
        
        SongInfoWindow.add(Artist_Info_Button);
        Artist_Info_Button.setBounds(65, 10, 210, 30);
        SongInfoWindow.add(Song_Info_Button);
        Song_Info_Button.setBounds(285, 10, 210, 30);


        SongID = new JLabel("Song ID");
        SongName = new JLabel("Song Name");
        Artist = new JLabel("Artist");
        Duration = new JLabel("Duration");
        Album = new JLabel("Album");
        Release_Year = new JLabel("Release Year");

        SongIDInput = new JTextField();
        SongNameInput = new JTextField();
        ArtistInput = new JTextField();
        DurationInput = new JTextField();
        AlbumInput = new JTextField();
        Release_YearInput = new JTextField();

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

        SongID.setBounds(65, 70, 100, 30);
        SongID.setForeground(Color.WHITE);
        SongName.setBounds(65,110, 100, 30);
        SongName.setForeground(Color.WHITE);
        Artist.setBounds(65, 150, 100, 30);
        Artist.setForeground(Color.WHITE);
        Duration.setBounds(65, 190, 100, 30);
        Duration.setForeground(Color.WHITE);
        Album.setBounds(65, 230, 100, 30);
        Album.setForeground(Color.WHITE);
        Release_Year.setBounds(65, 270, 100, 30);
        Release_Year.setForeground(Color.WHITE);

        SongIDInput.setBounds(210, 70, 285, 30);
        SongNameInput.setBounds(210, 110, 285, 30);
        ArtistInput.setBounds(210, 150, 285, 30);
        DurationInput.setBounds(210, 190, 285, 30);
        AlbumInput.setBounds(210, 230, 285, 30);
        Release_YearInput.setBounds(210, 270, 285, 30);

        ADD.setBounds(65, 330, 100, 30);
        UPDATE.setBounds(175, 330, 100, 30);
        REMOVE.setBounds(285, 330, 100, 30);
        CLEAR.setBounds(395, 330, 100, 30);
        BACK.setBounds(225, 370, 100, 30);

        SongInfoWindow.add(SongID);
        SongInfoWindow.add(SongName);
        SongInfoWindow.add(Artist);
        SongInfoWindow.add(Duration);
        SongInfoWindow.add(Album);
        SongInfoWindow.add(Release_Year);
        SongInfoWindow.add(SongIDInput);
        SongInfoWindow.add(SongNameInput);
        SongInfoWindow.add(ArtistInput);
        SongInfoWindow.add(DurationInput);
        SongInfoWindow.add(AlbumInput);
        SongInfoWindow.add(Release_YearInput);
        SongInfoWindow.add(ADD);
        SongInfoWindow.add(UPDATE);
        SongInfoWindow.add(REMOVE);
        SongInfoWindow.add(CLEAR);
        SongInfoWindow.add(BACK);
        
        add(SongInfoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        String songid = SongIDInput.getText();
        String songname = SongNameInput.getText();
        String artist = ArtistInput.getText();
        String duration = DurationInput.getText();
        String album = AlbumInput.getText();
        String release_year = Release_YearInput.getText();

        // check if song_info table exists
        // try{
        //     String sql = "SELECT * FROM song_info";
        //     java.sql.Statement stmt = con.createStatement();
        //     java.sql.ResultSet rs = stmt.executeQuery(sql);

        // }

        if (ae.getSource() == Artist_Info_Button) {
            this.dispose();
            try {

                ArtistInfo form = new ArtistInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else if (ae.getSource() == BACK) {
            this.dispose();
            try {

                Home form = new Home(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else if (ae.getSource() == ADD)    {
            // JDBC CONNECTION HERE
            /*
            [TODO]:
            1. Add Artist
            */
        }
        else if (ae.getSource() == UPDATE) {
            // JDBC CONNECTION HERE
            /*
            [TODO]:
            1. Update Artist
            */
        }
        else if (ae.getSource() == REMOVE) {
            // JDBC CONNECTION HERE
            /*
            [TODO]:
            1. Remove Artist
            */
        }
        else if (ae.getSource() == CLEAR) {
            try {
              
                SongIDInput.setText("");
                SongNameInput.setText("");
                ArtistInput.setText("");
                DurationInput.setText("");
                AlbumInput.setText("");
                Release_YearInput.setText("");

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }

}
