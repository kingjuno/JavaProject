import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class viewDetail extends JFrame implements ActionListener{
    JPanel SongInfoWindow ;
    JButton b;
    JLabel Search;
    JTextField Input,Output;
    Font font;
    JComboBox<String> cb;

    viewDetail() {
        setTitle("Music Recording Management System");
        
        SongInfoWindow = new JPanel();
        this.getContentPane().add(SongInfoWindow);
        SongInfoWindow.setLayout(null);
        SongInfoWindow.setBackground(Color.white);
        SongInfoWindow.setBounds(0, 0, 400, 400);
        
        Search = new JLabel("Search by:");
        JButton b = new JButton("Search");
        Input = new JTextField();
        Output = new JTextField();
        font  = new Font(Font.SANS_SERIF,  Font.BOLD, 10);

        String Options[] = { "Song Name", "Artist Name", "Album Name" };
        cb = new JComboBox<String>(Options);

        
        Search.setBounds(30, 50, 100, 30);
        cb.setBounds(100, 50, 200, 30);
        Input.setBounds(325, 50,130, 30);
        b.setBounds(175, 100, 100, 20);
        Output.setBounds(30, 150,425, 200);

        Output.setEditable(false); 
        Output.setFont(font);

        SongInfoWindow.add(Search);
        SongInfoWindow.add(cb);
        SongInfoWindow.add(Input);
        SongInfoWindow.add(b);
        SongInfoWindow.add(Output);

        add(SongInfoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        String option=cb.getItemAt(cb.getSelectedIndex());  
        String input = Input.getText();
        if(option.equals("Song Name"))
            if(input.equals("Runaway"))
                Output.setText("Song Available");  
            else if(input.equals(""))
                Output.setText("Input a Song Name");
            else
                Output.setText("No such song found");

        else if(option.equals("Artist Name"))
            Output.setText("Search by Song Name not Artist Name");

        else
            Output.setText("Search by Song Name not Album Name");

    }
}
