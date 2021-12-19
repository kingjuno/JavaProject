import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Hashtable;

public class Home extends JFrame implements ActionListener {
    JPanel Home;
    JButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;
    JLabel Search, home, icon;
    JTextField Input, Output;
    Font font;
    JComboBox<String> cb;
    Connection con;
    String Username;
    Hashtable<String, String> userdata;

    Home(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");

        this.setBounds(100, 100, 564, 408);
        Home = new JPanel();
        this.getContentPane().add(Home);
        Home.setLayout(null);
        Home.setBackground(new Color(68, 67, 68));

        icon = new JLabel("");
        icon.setIcon(new ImageIcon(this.getClass().getResource("assets/background.png")));
        icon.setBounds(-124, 122, 398, 149);
        this.getContentPane().add(icon);

        home = new JLabel("HOME");
        home.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
        home.setForeground(new Color(240, 255, 255));
        home.setBounds(250, 10, 200, 50);
        Home.add(home);

        btn_1 = new JButton("Add Song");
        btn_1.setBounds(342, 140, 150, 21);
        Home.add(btn_1);

        btn_2 = new JButton("View Details");
        btn_2.setBounds(342, 233, 150, 21);
        Home.add(btn_2);

        btn_3 = new JButton("Exit");
        btn_3.setBounds(484, 340, 56, 21);
        Home.add(btn_3);

        btn_4 = new JButton("Add Artist");
        btn_4.setBounds(342, 202, 150, 21);
        Home.add(btn_4);

        btn_5 = new JButton("Add Album");
        btn_5.setBounds(342, 171, 150, 21);
        Home.add(btn_5);

        btn_6 = new JButton("Add Feedback");
        btn_6.setBounds(342, 263, 150, 21);
        Home.add(btn_6);


        btn_1.addActionListener(this);
        btn_4.addActionListener(this);
        btn_5.addActionListener(this);
        btn_6.addActionListener(this);
        btn_2.addActionListener(this);
        btn_3.addActionListener(this);

        if (userdata.get("role").equals("user")) {
            btn_1.setEnabled(false);
            btn_4.setEnabled(false);
            btn_5.setEnabled(false);
            btn_6.setEnabled(false);
        }

        add(Home, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_1) {
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
        if (ae.getSource() == btn_2) {
            this.dispose();
            try {

                viewDetail form = new viewDetail(con, userdata);
                form.setSize(500, 400);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if (ae.getSource() == btn_3) {
            System.exit(0);
        }
        if (ae.getSource() == btn_4) {
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
        if (ae.getSource() == btn_5) {
            this.dispose();
            try {
                AlbumInfo form = new AlbumInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        if (ae.getSource() == btn_6) {
            this.dispose();
            try {
                feedback_info form = new feedback_info(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }
}