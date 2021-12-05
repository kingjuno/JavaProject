import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class ArtistInfo extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button;
    JButton ADD, UPDATE, REMOVE, CANCEL, BACK;
    JPanel ArtistInfoWindow, FunctionButton, Container;
    JLabel ArtistID, FirstName, LastName, Address, Phone, Email, DateOfBirth;
    JTextField ArtistIDInput, FirstNameInput, LastNameInput, AddressInput, PhoneInput, EmailInput, DateOfBirthInput;
    GridBagConstraints gridwidth;

    ArtistInfo() {
        setTitle("Music Recording Management System");
        setSize(500, 450);

        Artist_Info_Button = new JButton("Artist Info");
        Artist_Info_Button.addActionListener(this);
        Song_Info_Button = new JButton("Song Info");
        Song_Info_Button.addActionListener(this);

        ArtistInfoWindow = new JPanel();
        this.getContentPane().add(ArtistInfoWindow);
        ArtistInfoWindow.setLayout(null);
        ArtistInfoWindow.setBackground(new Color(143, 134, 118));
        ArtistInfoWindow.setBounds(0, 0, 400, 400);
        ArtistInfoWindow.add(Artist_Info_Button);
        Artist_Info_Button.setBounds(30, 10, 210, 30);
        ArtistInfoWindow.add(Song_Info_Button);
        Song_Info_Button.setBounds(250, 10, 210, 30);


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

        ArtistID.setBounds(30, 50, 100, 30);
        FirstName.setBounds(30, 90, 100, 30);
        LastName.setBounds(30, 130, 100, 30);   
        Address.setBounds(30, 170, 100, 30);
        Phone.setBounds(30, 210, 100, 30);
        Email.setBounds(30, 250, 100, 30);
        DateOfBirth.setBounds(30, 290, 100, 30);
    

        ArtistIDInput.setBounds(170, 50, 290, 30);
        FirstNameInput.setBounds(170, 90, 290, 30);
        LastNameInput.setBounds(170, 130, 290, 30);     
        AddressInput.setBounds(170, 170, 290, 30);
        PhoneInput.setBounds(170, 210, 290, 30);
        EmailInput.setBounds(170, 250, 290, 30);
        DateOfBirthInput.setBounds(170, 290, 290, 30);

        ADD.setBounds(30, 330, 100, 30);
        UPDATE.setBounds(140, 330, 100, 30);
        REMOVE.setBounds(250, 330, 100, 30);
        CANCEL.setBounds(360, 330, 100, 30);
        BACK.setBounds(190, 370, 100, 30);

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
