import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.util.Hashtable;

public class ArtistInfo extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button;
    JButton ADD, UPDATE, REMOVE, CANCEL, BACK;
    JPanel ArtistInfoWindow, FunctionButton, Container;
    JLabel ArtistID, FirstName, LastName, Address, Phone, Email, DateOfBirth;
    JTextField ArtistIDInput, FirstNameInput, LastNameInput, AddressInput, PhoneInput, EmailInput, DateOfBirthInput;
    Connection con;
    Hashtable<String, String> userdata;

    ArtistInfo(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        System.out.println(userdata.get("role"));
        setTitle("Music Recording Management System");

        Artist_Info_Button = new JButton("Artist Info");
        Artist_Info_Button.addActionListener(this);
        Song_Info_Button = new JButton("Song Info");
        Song_Info_Button.addActionListener(this);

        ArtistInfoWindow = new JPanel();
        this.getContentPane().add(ArtistInfoWindow);
        ArtistInfoWindow.setLayout(null);
        ArtistInfoWindow.setBackground(new Color(68,67,68));
        this.setBounds(100, 100, 564, 450);
        
        ArtistInfoWindow.add(Artist_Info_Button);
        Artist_Info_Button.setBounds(65, 10, 210, 30);
        ArtistInfoWindow.add(Song_Info_Button);
        Song_Info_Button.setBounds(285, 10, 210, 30);

        ArtistID = new JLabel("Artist ID");
        FirstName = new JLabel("First Name");
        LastName = new JLabel("Last Name");
        Address = new JLabel("Address");
        Phone = new JLabel("Phone");
        Email = new JLabel("Email");
        DateOfBirth = new JLabel("Date of Birth");

        ArtistIDInput = new JTextField();
        FirstNameInput = new JTextField();
        LastNameInput = new JTextField();
        AddressInput = new JTextField();
        PhoneInput = new JTextField();
        EmailInput = new JTextField();
        DateOfBirthInput = new JTextField();

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

    
        FirstName.setBounds(65, 70, 100, 30);
        FirstName.setForeground(Color.WHITE);
        LastName.setBounds(65, 110, 100, 30);
        LastName.setForeground(Color.WHITE);
        Address.setBounds(65, 150, 100, 30);
        Address.setForeground(Color.WHITE);
        Phone.setBounds(65, 190, 100, 30);
        Phone.setForeground(Color.WHITE);
        Email.setBounds(65, 230, 100, 30);
        Email.setForeground(Color.WHITE);
        DateOfBirth.setBounds(65, 270, 100, 30);
        DateOfBirth.setForeground(Color.WHITE);

        FirstNameInput.setBounds(210, 70, 285, 30);
        LastNameInput.setBounds(210, 110, 285, 30);
        AddressInput.setBounds(210, 150, 285, 30);
        PhoneInput.setBounds(210, 190, 285, 30);
        EmailInput.setBounds(210, 230, 285, 30);
        DateOfBirthInput.setBounds(210, 270, 285, 30);

        ADD.setBounds(65, 330, 100, 30);
        UPDATE.setBounds(175, 330, 100, 30);
        REMOVE.setBounds(285, 330, 100, 30);
        CANCEL.setBounds(395, 330, 100, 30);
        BACK.setBounds(225, 370, 100, 30);

        ArtistInfoWindow.add(ArtistID);
        ArtistInfoWindow.add(FirstName);
        ArtistInfoWindow.add(LastName);
        ArtistInfoWindow.add(Address);
        ArtistInfoWindow.add(Phone);
        ArtistInfoWindow.add(Email);
        ArtistInfoWindow.add(DateOfBirth);
        ArtistInfoWindow.add(ArtistIDInput);
        ArtistInfoWindow.add(FirstNameInput);
        ArtistInfoWindow.add(LastNameInput);
        ArtistInfoWindow.add(AddressInput);
        ArtistInfoWindow.add(PhoneInput);
        ArtistInfoWindow.add(EmailInput);
        ArtistInfoWindow.add(DateOfBirthInput);
        ArtistInfoWindow.add(ADD);
        ArtistInfoWindow.add(UPDATE);
        ArtistInfoWindow.add(REMOVE);
        ArtistInfoWindow.add(CANCEL);
        ArtistInfoWindow.add(BACK);

        add(ArtistInfoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        String artistid = ArtistIDInput.getText();
        String firstname = FirstNameInput.getText();
        String lastname = LastNameInput.getText();
        String address = AddressInput.getText();
        String phone = PhoneInput.getText();
        String email = EmailInput.getText();
        String dateofbirth = DateOfBirthInput.getText();

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
        } else if (ae.getSource() == Song_Info_Button) {
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
        } else if (ae.getSource() == BACK) {
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
        } else if (ae.getSource() == ADD) {
            // JDBC CONNECTION HERE
            /*
             * [TODO]:
             * 1. Add Artist
             */
        } else if (ae.getSource() == UPDATE) {
            // JDBC CONNECTION HERE
            /*
             * [TODO]:
             * 1. Update Artist
             */
        } else if (ae.getSource() == REMOVE) {
            // JDBC CONNECTION HERE
            /*
             * [TODO]:
             * 1. Remove Artist
             */
        } else if (ae.getSource() == CANCEL) {

        }
    }
}
