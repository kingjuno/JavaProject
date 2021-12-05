import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class SongInfo extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button;
    JButton ADD, UPDATE, REMOVE, CANCEL, BACK;
    JPanel SongInfoWindow, FunctionButton, Container;
    JLabel SongID, SongName, Artist, Duration, Album, Release_Year;
    JTextField SongIDInput, SongNameInput, ArtistInput, DurationInput, AlbumInput, Release_YearInput;
    GridBagConstraints gridwidth;

    SongInfo() {
        setTitle("Music Recording Management System");
        setSize(500, 450);
        Artist_Info_Button = new JButton("Artist Info");
        Artist_Info_Button.addActionListener(this);
        Song_Info_Button = new JButton("Song Info");
        Song_Info_Button.addActionListener(this);

        SongInfoWindow = new JPanel();
        this.getContentPane().add(SongInfoWindow);
        SongInfoWindow.setLayout(null);
        SongInfoWindow.setBackground(new Color(143, 134, 118));
        SongInfoWindow.setBounds(0, 0, 450, 450);
        SongInfoWindow.add(Artist_Info_Button);
        Artist_Info_Button.setBounds(30, 10, 210, 30);
        SongInfoWindow.add(Song_Info_Button);
        Song_Info_Button.setBounds(250, 10, 210, 30);


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
        CANCEL = new JButton("CANCEL");
        CANCEL.addActionListener(this);
        BACK = new JButton("BACK");
        BACK.addActionListener(this);

        SongID.setBounds(30, 50, 100, 30);
        SongName.setBounds(30, 90, 100, 30);
        Artist.setBounds(30, 130, 100, 30);
        Duration.setBounds(30, 170, 100, 30);
        Album.setBounds(30, 210, 100, 30);
        Release_Year.setBounds(30, 250, 100, 30);

        SongIDInput.setBounds(170, 50, 290, 30);
        SongNameInput.setBounds(170, 90, 290, 30);
        ArtistInput.setBounds(170, 130, 290, 30);
        DurationInput.setBounds(170, 170, 290, 30);
        AlbumInput.setBounds(170, 210, 290, 30);
        Release_YearInput.setBounds(170, 250, 290, 30);

        ADD.setBounds(30, 300, 100, 30);
        UPDATE.setBounds(140, 300, 100, 30);
        REMOVE.setBounds(250, 300, 100, 30);
        CANCEL.setBounds(360, 300, 100, 30);
        BACK.setBounds(190, 350, 100, 30);

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
        SongInfoWindow.add(CANCEL);
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


        if (ae.getSource() == Artist_Info_Button) {
            this.dispose();
            try {

                ArtistInfo form = new ArtistInfo();
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

                SongInfo form = new SongInfo();
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

                Home form = new Home();
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
        else if (ae.getSource() == CANCEL) {
            
        }
    }

}
