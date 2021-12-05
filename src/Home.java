import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener{
    JPanel Home ;
    JButton btn_1,btn_2,btn_3, btn_4;
    JLabel Search, home;
    JTextField Input,Output;
    Font font;
    JComboBox<String> cb;

    Home() {
        setTitle("Music Recording Management System");
        
		this.setBounds(100, 100, 564, 408);
        Home = new JPanel();
        this.getContentPane().add(Home);
        Home.setLayout(null);
        Home.setBackground(new Color(143, 134, 118));

        home = new JLabel("Home");
        home.setFont(new Font("Serif",Font.BOLD,25));
        home.setBounds(250,10,200,50);
        Home.add(home);

        btn_1 = new JButton("Add Song");
        btn_1.setBounds(25, 180, 118, 21);
        Home.add(btn_1);

        btn_2 = new JButton("View Details");
		btn_2.setBounds(269, 180, 125, 21);
		Home.add(btn_2);
		
		btn_3 = new JButton("Exit");
		btn_3.setBounds(409, 180, 105, 21);
		Home.add(btn_3);

        btn_4 = new JButton("Add Artist");
        btn_4.setBounds(153, 180, 105, 21);
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
        if (ae.getSource() == btn_1) {
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
        if (ae.getSource() == btn_2) {
            this.dispose();
            try {

                viewDetail form = new viewDetail();
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

                ArtistInfo form = new ArtistInfo();
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