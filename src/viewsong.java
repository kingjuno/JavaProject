import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class viewsong extends JFrame  {
    JFrame f;
    JPanel SongInfoWindow ;
    JButton b;
    JLabel Search;
    JTextField Input,Output;
    Font font;

    viewsong() {
        f = new JFrame("Music Recording Management System");
        
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
        final JComboBox<String> cb = new JComboBox<String>(Options);

        
        Search.setBounds(30, 50, 100, 30);
        cb.setBounds(100, 50, 200, 30);
        Input.setBounds(325, 50,130, 30);
        b.setBounds(200, 100, 75, 20);
        Output.setBounds(30, 150,425, 200);

        Output.setEditable(false); 
        Output.setFont(font);

        f.add(Search);
        f.add(cb);
        f.add(Input);
        f.add(b);
        f.add(Output);


        f.setLayout(null);
        f.setSize(500, 400);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        });
    }

    public static void main(String[] args) {
        new viewsong();
    }
}