import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Hashtable;
public class viewDetail extends JFrame implements ActionListener{
    JPanel SongInfoWindow ;
    JButton b,back;
    JLabel Search,Back;
    JTextField Input;
    Font font;
    JComboBox<String> cb;
    Connection con;
    Hashtable<String, String> userdata;

    viewDetail(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");
        
        SongInfoWindow = new JPanel();
        this.getContentPane().add(SongInfoWindow);
        SongInfoWindow.setLayout(null);
        SongInfoWindow.setBackground(new Color(68,67,68));
        SongInfoWindow.setBounds(0, 0, 400, 400);
        this.setBounds(100, 100, 564, 450);
        
        Search = new JLabel("Search by:");
        Back = new JLabel("Back");
        b = new JButton("Search");
        back = new JButton("Back");
        Input = new JTextField();
        
        font  = new Font(Font.SANS_SERIF,  Font.BOLD, 10);

        String Options[] = { "Song Name", "Artist Name", "Album Name" };
        cb = new JComboBox<String>(Options);
        Search.setBounds(10, 50, 100, 30);
        Search.setForeground(Color.WHITE);
        cb.setBounds(100, 50, 200, 30);
        Input.setBounds(315, 50,165, 30);
        b.setBounds(265, 100, 100, 20);
        b.addActionListener(this);
        back.setBounds(140, 100, 100, 20);
        back.addActionListener(this);

//display the data in the tabular format insde output text field
    
        
        String Object [][] ={
                {"sef", "eff", null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
            };
        String clm []= {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"};
        JTable jt= new JTable(Object,clm);
        jt.setBounds(10, 150,400, 200);
        jt.setEnabled(false);
        jt.setVisible(true);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        JScrollPane pane = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        pane.setBounds(10, 150,469, 200);
        SongInfoWindow.add(pane);
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
        String option=cb.getItemAt(cb.getSelectedIndex());  
        String input = Input.getText();
        if (ae.getSource() == back) {
            this.dispose();
            try {
                Home form = new Home(con,userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        

        // JDBC CONNECTION HERE
        /*
        [TODO]:
        1. Connect to the database
        2.1.a Search for the song
        2.1.b If found, display the song details
        2.1.c If not found, display "No such song found"
        2.2.a Search for the artist
        2.2.b If found, display the artist details
        2.2.c If not found, display "No such artist found"
        2.3.a Search for the album
        2.3.b If found, display the album details
        2.3.c If not found, display "No such album found"
        */
    }
}