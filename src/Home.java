import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class Home extends JFrame implements ActionListener{
    JPanel Home ;
    JButton btn_1,btn_2,btn_3, btn_4;
    JLabel Search, home,icon;
    JTextField Input,Output;
    Font font;
    JComboBox<String> cb;
    Connection con;

    Home(Connection con) {
        this.con = con;
        setTitle("Music Recording Management System");
        
		this.setBounds(100, 100, 564, 408);
        Home = new JPanel();
        this.getContentPane().add(Home);
        Home.setLayout(null);
        Home.setBackground(new Color(68,67,68));

        
        icon = new JLabel("");
		icon.setIcon(new ImageIcon(this.getClass().getResource("assets/background.png")));
		icon.setBounds(0, 69, 398, 149);
		this.getContentPane().add(icon);

        home = new JLabel("HOME");
        home.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.PLAIN,25));
        home.setForeground(new Color(240, 255, 255));
        home.setBounds(250,10,200,50);
        Home.add(home);

        btn_1 = new JButton("Add Song");
        btn_1.setBounds(10, 273, 128, 21);
        Home.add(btn_1);

        btn_2 = new JButton("View Details");
		btn_2.setBounds(283, 273, 122, 21);
		Home.add(btn_2);
		
		btn_3 = new JButton("Exit");
		btn_3.setBounds(415, 273, 128, 21);
		Home.add(btn_3);

        btn_4 = new JButton("Add Artist");
        btn_4.setBounds(148, 273, 122, 21);
        Home.add(btn_4);

        btn_1.addActionListener(this);
        btn_2.addActionListener(this);
        btn_3.addActionListener(this);
        btn_4.addActionListener(this);

        add(Home, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        // if (ae.getSource() == btn_1) {
        //     this.dispose();
        //     try {

        //         SongInfo form = new SongInfo();
        //         form.setVisible(true);
        //         form.invalidate();
        //         form.validate();
        //         form.repaint();
        //     } catch (Exception e) {
        //         JOptionPane.showMessageDialog(null, e.getMessage());
        //     }
        // }
        // if (ae.getSource() == btn_2) {
        //     this.dispose();
        //     try {

        //         viewDetail form = new viewDetail();
        //         form.setSize(500, 400);
        //         form.setVisible(true);
        //         form.invalidate();
        //         form.validate();
        //         form.repaint();
        //     } catch (Exception e) {
        //         JOptionPane.showMessageDialog(null, e.getMessage());
        //     }
        // }
        // if (ae.getSource() == btn_3) {
        //     System.exit(0);
        // }
        // if (ae.getSource() == btn_4) {
        //     this.dispose();
        //     try {

        //         ArtistInfo form = new ArtistInfo();
        //         form.setVisible(true);
        //         form.invalidate();
        //         form.validate();
        //         form.repaint();
        //     } catch (Exception e) {
        //         JOptionPane.showMessageDialog(null, e.getMessage());
        //     }
        // }

    }
}