import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Hashtable;

public class viewDetail extends JFrame implements ActionListener {
    JPanel SongInfoWindow;
    JButton b, back;
    JLabel Search, Back;
    JTextField Input;
    Font font;
    JComboBox<String> cb;
    Connection con;
    Hashtable<String, String> userdata;
    String Object[][] = {
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
            { "", "", "", "", "" },
    };
    String clm[] = {
            "", "", "", "", "" };

    viewDetail(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");

        SongInfoWindow = new JPanel();
        this.getContentPane().add(SongInfoWindow);
        SongInfoWindow.setLayout(null);
        SongInfoWindow.setBackground(new Color(68, 67, 68));
        SongInfoWindow.setBounds(0, 0, 400, 400);
        this.setBounds(100, 100, 564, 450);

        Search = new JLabel("Search by:");
        Back = new JLabel("Back");
        b = new JButton("Search");
        back = new JButton("Back");
        Input = new JTextField();

        font = new Font(Font.SANS_SERIF, Font.BOLD, 10);

        String Options[] = { "Song Name", "Artist Name", "Album Name" };
        cb = new JComboBox<String>(Options);
        Search.setBounds(10, 50, 100, 30);
        Search.setForeground(Color.WHITE);
        cb.setBounds(100, 50, 200, 30);
        Input.setBounds(315, 50, 165, 30);
        b.setBounds(265, 100, 100, 20);
        b.addActionListener(this);
        back.setBounds(140, 100, 100, 20);
        back.addActionListener(this);

        SongInfoWindow.add(Search);
        SongInfoWindow.add(cb);
        SongInfoWindow.add(Input);
        SongInfoWindow.add(b);
        SongInfoWindow.add(back);

        add(SongInfoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String option = cb.getItemAt(cb.getSelectedIndex());
        if (ae.getSource() == back) {
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
        } else if (option.equals("Song Name")) {
            String song_name_input = Input.getText();
            try {
                String sql = "SELECT song_name,first_name as artist,albumname,duration,release_date FROM song_info INNER JOIN artist_info ON song_info.artist = artist_info.artist_id INNER JOIN album_info ON song_info.album = album_info.album_id WHERE song_name= ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, song_name_input);
                ResultSet rs = pst.executeQuery();
                int r = 0;
                for (int i = 0; i < clm.length; i++) {
                    clm[i] = "";
                }
                for (int i = 0; i < Object.length; i++) {
                    for (int j = 0; j < Object[i].length; j++) {
                        Object[i][j] = "";
                    }
                }
                clm[0] = "Song Name";
                clm[1] = "Artist Name";
                clm[2] = "Album Name";
                clm[3] = "Duration";
                clm[4] = "Release Date";
                while (rs.next()) {
                    Object[r][0] = rs.getString("song_name");
                    Object[r][1] = rs.getString("artist");
                    Object[r][2] = rs.getString("albumname");
                    Object[r][3] = rs.getString("duration");
                    Object[r][4] = rs.getString("release_date");
                    r++;
                }
                if(Object[0][0]==""){
                    JOptionPane.showMessageDialog(null, "No such song found");
                    return;
                }
                JTable jt = new JTable(Object, clm);
                jt.setBounds(10, 150, 400, 200);
                jt.setEnabled(false);
                jt.setVisible(true);
                jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                JScrollPane pane = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                pane.setBounds(10, 150, 469, 200);
                SongInfoWindow.add(pane);
                SongInfoWindow.add(Search);
                SongInfoWindow.add(cb);
                SongInfoWindow.add(Input);
                SongInfoWindow.add(b);
                SongInfoWindow.add(back);
                add(SongInfoWindow, BorderLayout.CENTER);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }

        else if (option.equals("Artist Name")) {
            String artist_name_input = Input.getText();
            try {
                String sql = "SELECT song_name,first_name as artist,albumname,duration,release_date FROM song_info INNER JOIN artist_info ON song_info.artist = artist_info.artist_id INNER JOIN album_info ON song_info.album = album_info.album_id WHERE first_name= ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, artist_name_input);
                ResultSet rs = pst.executeQuery();
                int r = 0;
                for (int i = 0; i < clm.length; i++) {
                    clm[i] = "";
                }
                for (int i = 0; i < Object.length; i++) {
                    for (int j = 0; j < Object[i].length; j++) {
                        Object[i][j] = "";
                    }
                }
                clm[0] = "Song Name";
                clm[1] = "Artist Name";
                clm[2] = "Album Name";
                clm[3] = "Duration";
                clm[4] = "Release Date";
                while (rs.next()) {
                    Object[r][0] = rs.getString("song_name");
                    Object[r][1] = rs.getString("artist");
                    Object[r][2] = rs.getString("albumname");
                    Object[r][3] = rs.getString("duration");
                    Object[r][4] = rs.getString("release_date");
                    r++;
                }
                if(Object[0][0]==""){
                    JOptionPane.showMessageDialog(null, "No such song found");
                    return;
                }
                JTable jt = new JTable(Object, clm);
                jt.setBounds(10, 150, 400, 200);
                jt.setEnabled(false);
                jt.setVisible(true);
                jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                JScrollPane pane = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                pane.setBounds(10, 150, 469, 200);
                // reset song info window
                // SongInfoWindow = new JPanel();
                SongInfoWindow.add(pane);
                SongInfoWindow.add(Search);
                SongInfoWindow.add(cb);
                SongInfoWindow.add(Input);
                SongInfoWindow.add(b);
                SongInfoWindow.add(back);
                add(SongInfoWindow, BorderLayout.CENTER);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }

        else if (option.equals("Album Name")) {
            String albumname_input = Input.getText();
            try {
                String sql = "SELECT song_name,first_name as artist,albumname,duration,release_date FROM song_info INNER JOIN artist_info ON song_info.artist = artist_info.artist_id INNER JOIN album_info ON song_info.album = album_info.album_id WHERE albumname=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, albumname_input);
                ResultSet rs = pst.executeQuery();
                int r = 0;
                for (int i = 0; i < clm.length; i++) {
                    clm[i] = "";
                }
                for (int i = 0; i < Object.length; i++) {
                    for (int j = 0; j < Object[i].length; j++) {
                        Object[i][j] = "";
                    }
                }
                clm[0] = "Song Name";
                clm[1] = "Artist Name";
                clm[2] = "Album Name";
                clm[3] = "Duration";
                clm[4] = "Release Date";

                while (rs.next()) {
                    Object[r][0] = rs.getString("song_name");
                    Object[r][1] = rs.getString("artist");
                    Object[r][2] = rs.getString("albumname");
                    Object[r][3] = rs.getString("duration");
                    Object[r][4] = rs.getString("release_date");
                    r++;
                }
                if(Object[0][0]==""){
                    JOptionPane.showMessageDialog(null, "No such song found");
                    return;
                }
                
                JTable jt = new JTable(Object, clm);
                jt.setBounds(10, 150, 400, 200);
                jt.setEnabled(false);
                jt.setVisible(true);
                jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                JScrollPane pane = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                pane.setBounds(10, 150, 469, 200);
                SongInfoWindow.add(pane);
                SongInfoWindow.add(Search);
                SongInfoWindow.add(cb);
                SongInfoWindow.add(Input);
                SongInfoWindow.add(b);
                SongInfoWindow.add(back);
                add(SongInfoWindow, BorderLayout.CENTER);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }
    }
}