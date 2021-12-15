import javax.swing.*;
import javax.xml.crypto.Data;

import sqlUtils.CreateArtistTable;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.util.Hashtable;

public class ArtistInfo extends JFrame implements ActionListener {
    JButton Artist_Info_Button, Song_Info_Button;
    JButton ADD, UPDATE, REMOVE, CLEAR, BACK;
    JPanel ArtistInfoWindow, FunctionButton, Container;
    JLabel FirstName, LastName, Address, Phone, Email, DateOfBirth;
    JTextField FirstNameInput, LastNameInput, AddressInput, PhoneInput, EmailInput, DateOfBirthInput;
    Connection con;
    Hashtable<String, String> userdata;

    ArtistInfo(Connection con, Hashtable<String, String> userdata) {
        this.con = con;
        this.userdata = userdata;
        setTitle("Music Recording Management System");

        Artist_Info_Button = new JButton("Artist Info");
        Artist_Info_Button.addActionListener(this);
        Song_Info_Button = new JButton("Song Info");
        Song_Info_Button.addActionListener(this);

        ArtistInfoWindow = new JPanel();
        this.getContentPane().add(ArtistInfoWindow);
        ArtistInfoWindow.setLayout(null);
        ArtistInfoWindow.setBackground(new Color(68, 67, 68));
        this.setBounds(100, 100, 564, 450);

        ArtistInfoWindow.add(Artist_Info_Button);
        Artist_Info_Button.setBounds(65, 10, 210, 30);
        ArtistInfoWindow.add(Song_Info_Button);
        Song_Info_Button.setBounds(285, 10, 210, 30);

        FirstName = new JLabel("First Name");
        LastName = new JLabel("Last Name");
        Address = new JLabel("Address");
        Phone = new JLabel("Phone");
        Email = new JLabel("Email");
        DateOfBirth = new JLabel("Date of Birth");

        String data[] = getFields();
        FirstNameInput = new JTextField(data[0]);
        LastNameInput = new JTextField(data[1]);
        AddressInput = new JTextField(data[2]);
        PhoneInput = new JTextField(data[3]);
        EmailInput = new JTextField(data[4]);
        DateOfBirthInput = new JTextField(data[5]);

        ADD = new JButton("ADD");
        ADD.addActionListener(this);
        UPDATE = new JButton("UPDATE");
        UPDATE.addActionListener(this);
        REMOVE = new JButton("REMOVE");
        REMOVE.addActionListener(this);
        CLEAR = new JButton("CLEAR");
        CLEAR.addActionListener(this);
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
        CLEAR.setBounds(395, 330, 100, 30);
        BACK.setBounds(225, 370, 100, 30);

        ArtistInfoWindow.add(FirstName);
        ArtistInfoWindow.add(LastName);
        ArtistInfoWindow.add(Address);
        ArtistInfoWindow.add(Phone);
        ArtistInfoWindow.add(Email);
        ArtistInfoWindow.add(DateOfBirth);
        ArtistInfoWindow.add(FirstNameInput);
        ArtistInfoWindow.add(LastNameInput);
        ArtistInfoWindow.add(AddressInput);
        ArtistInfoWindow.add(PhoneInput);
        ArtistInfoWindow.add(EmailInput);
        ArtistInfoWindow.add(DateOfBirthInput);
        ArtistInfoWindow.add(ADD);
        ArtistInfoWindow.add(UPDATE);
        ArtistInfoWindow.add(REMOVE);
        ArtistInfoWindow.add(CLEAR);
        ArtistInfoWindow.add(BACK);

        add(ArtistInfoWindow, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private String[] getFields() {
        String[] fields = new String[7];
        fields[0] = "";
        fields[1] = "";
        fields[2] = "";
        fields[3] = "";
        fields[4] = "";
        fields[5] = "";
        try{
            String query = "SELECT * FROM artist_info where artist_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userdata.get("username"));
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                fields[0] = rs.getString("first_name");
                fields[1] = rs.getString("last_name");
                fields[2] = rs.getString("address");
                fields[3] = rs.getString("phone");
                fields[4] = rs.getString("email");
                fields[5] = rs.getString("dob");
                return fields;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return fields;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Artist_Info_Button) {
            this.dispose();
            try {

                ArtistInfo form = new ArtistInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return;
        } else if (ae.getSource() == Song_Info_Button) {
            this.dispose();
            try {

                SongInfo form = new SongInfo(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return;
        } else if (ae.getSource() == BACK) {
            this.dispose();
            try {

                Home form = new Home(con, userdata);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return;
        } else if (ae.getSource() == CLEAR) {
            try {
                FirstNameInput.setText("");
                LastNameInput.setText("");
                AddressInput.setText("");
                PhoneInput.setText("");
                EmailInput.setText("");
                DateOfBirthInput.setText("");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        try {
            String firstname = FirstNameInput.getText();
            String lastname = LastNameInput.getText();
            String address = AddressInput.getText();
            String phone = PhoneInput.getText();
            long phone_number = 0;
            if (ae.getSource() != REMOVE)
                phone_number = Long.parseLong(phone);
            String email = EmailInput.getText();
            java.sql.Date sqlDate = null;
            String dateofbirth = DateOfBirthInput.getText();
            if (ae.getSource() != REMOVE) {
                java.util.Date date = new java.util.Date(dateofbirth);
                sqlDate = new java.sql.Date(date.getTime());
            }

            if (ae.getSource() == ADD) {
                // check if any content is empty
                if (firstname.equals("") || lastname.equals("") || address.equals("") || phone.equals("")
                        || email.equals("") || dateofbirth.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                try {
                    String sql = "SELECT * FROM artist_info";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.executeQuery();
                } catch (Exception e) {
                    CreateArtistTable form = new CreateArtistTable(con);
                    form.createTable();
                    JOptionPane.showMessageDialog(null, "Artist Info Table is created");
                }
                try {
                    String sql = "INSERT INTO artist_info (artist_id, first_name, last_name, address, phone, email, dob) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, userdata.get("username"));
                    pst.setString(2, firstname);
                    pst.setString(3, lastname);
                    pst.setString(4, address);
                    pst.setLong(5, phone_number);
                    pst.setString(6, email);
                    pst.setDate(7, sqlDate);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Artist Added");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (ae.getSource() == UPDATE) {
                try {
                    String sql = "SELECT * FROM artist_info where artist_id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, userdata.get("username"));
                    ResultSet rs = pst.executeQuery();
                    // if no record found display add artist
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Add artist Details first");
                    } else {
                        String sql1 = "UPDATE artist_info SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?, dob = ? WHERE artist_id = ?";
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                        pst1.setString(1, firstname);
                        pst1.setString(2, lastname);
                        pst1.setString(3, address);
                        pst1.setLong(4, phone_number);
                        pst1.setString(5, email);
                        pst1.setDate(6, sqlDate);
                        pst1.setString(7, userdata.get("username"));
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Artist Details Updated");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (ae.getSource() == REMOVE) {
                try {
                    String sql = "SELECT * FROM artist_info where artist_id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, userdata.get("username"));
                    ResultSet rs = pst.executeQuery();
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Add artist Details first");
                    } else {
                        String sql1 = "DELETE FROM artist_info WHERE artist_id = ?";
                        PreparedStatement pst1 = con.prepareStatement(sql1);
                        pst1.setString(1, userdata.get("username"));
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Artist Removed");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input");
            return;
        }

    }
}
