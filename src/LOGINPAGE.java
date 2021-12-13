import javax.swing.*;

import UIutils.*;
import sqlUtils.CheckForData;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class LOGINPAGE extends JFrame implements ActionListener{
    JLabel user_id,password, logo, loginHead;
    JTextField user_input;
    JPasswordField password_input;
    GridBagConstraints Gridwidth;
    JPasswordField passwordField;
    OpaqueButton Login;
    transparentButton Signup;
    Connection con;

    LOGINPAGE(Connection con) 
    {
        this.con = con;
        setTitle("Music Recording Company");

        this.getContentPane().setBackground(new Color(66, 68, 67));
        this.getContentPane().setForeground(Color.WHITE);
        this.getContentPane().setEnabled(false);
        this.setBounds(100, 100, 564, 408);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        Login = new OpaqueButton("Login");
        Login.addActionListener(this);
        Login.setBounds(143, 280, 118, 21);
        this.getContentPane().add(Login);
        
        Signup = new transparentButton("Sign Up");
        Signup.setBounds(295, 280, 105, 21);
        this.getContentPane().add(Signup);
        Signup.addActionListener(this);

        
        password_input = new JPasswordField();
        password_input.setBounds(347, 167, 142, 19);
        this.getContentPane().add(password_input);

        user_input = new JTextField();
        user_input.setBounds(347, 120, 142, 19);
        this.getContentPane().add(user_input);
        user_input.setColumns(10);
        
        user_id = new JLabel("UserName");
        user_id.setForeground(Color.WHITE);
        user_id.setFont(new Font("Times New Roman", Font.BOLD, 10));
        user_id.setBounds(279, 119, 47, 21);
        this.getContentPane().add(user_id);
        
        password = new JLabel("Password");
        password.setFont(new Font("Times New Roman", Font.BOLD, 10));
        password.setForeground(Color.WHITE);
        password.setBounds(279, 167, 47, 19);
        this.getContentPane().add(password);
        
        loginHead = new JLabel("Login");
        loginHead.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
        loginHead.setForeground(Color.WHITE);
        loginHead.setBounds(347, 75, 68, 21);
        this.getContentPane().add(loginHead);

        logo = new JLabel("");
        logo.setIcon(new ImageIcon(this.getClass().getResource("assets/background.png")));
        logo.setBounds(-141, 10, 439, 278);
        this.getContentPane().add(logo);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Login) {
			System.out.println("Login Event");
			String User_id_input = user_input.getText();
			String Password_input = password_input.getText();

            if (User_id_input.equals("") || Password_input.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                String query = "select * from user_info where user_id = '" + User_id_input + "' and password = '" + Password_input + "'";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                    Home home = new Home(con);
                    home.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
            }

		} else if (ae.getSource() == Signup) {
			System.out.println("Signup Event");
			SIGNUPSCREEN loginpage = new SIGNUPSCREEN(con);
			loginpage.setVisible(true);
			this.dispose();
		}
    }   
}
