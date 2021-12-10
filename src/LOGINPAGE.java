import javax.swing.*;

import UIutils.*;

import java.awt.*;
import java.awt.event.*;

public class LOGINPAGE extends JFrame implements ActionListener{
    JLabel user_id,password, logo, loginHead;
    JTextField textField;
    GridBagConstraints Gridwidth;
    JPasswordField passwordField;
    OpaqueButton login;
    transparentButton signup;

    LOGINPAGE() 
    {
        setTitle("Music Recording Company");

        this.getContentPane().setBackground(new Color(66, 68, 67));
        this.getContentPane().setForeground(Color.WHITE);
        this.getContentPane().setEnabled(false);
        this.setBounds(100, 100, 564, 408);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        login = new OpaqueButton("Login");
        login.addActionListener(this);
        login.setBounds(143, 280, 118, 21);
        this.getContentPane().add(login);
        
        signup = new transparentButton("Sign Up");
        signup.setBounds(295, 280, 105, 21);
        this.getContentPane().add(signup);
        signup.addActionListener(this);

        
        passwordField = new JPasswordField();
        passwordField.setBounds(347, 167, 142, 19);
        this.getContentPane().add(passwordField);

        textField = new JTextField();
        textField.setBounds(347, 120, 142, 19);
        this.getContentPane().add(textField);
        textField.setColumns(10);
        
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

        // String User_id = user_id_input.getText();
        // String Password = password_input.getText();
        // System.out.println(User_id+'#'+Password);
        // if (ae.getSource() == login_button) {
        //     if (User_id=="" && Password == ""){
        //         // JDBC CONNECTION HERE
        //         /*
        //         [TODO]:
        //         1. Check if user exists
        //         2. Check if password is correct
        //         3. If correct, GO TO HOME PAGE
        //         */
        //     }
        //     else{
        //         // for now ay user and password not empty something is fine
        //         // will fix this after connecting to DB
        //         this.dispose();
        //         Home form = new Home();
        //         form.setVisible(true);
        //         form.invalidate();
        //     }
            
        // }
        // else if (ae.getSource() == signup_button) {
        //     this.dispose();
        //     try {
        //         SIGNUPSCREEN form = new SIGNUPSCREEN();
        //         form.setVisible(true);
        //         form.invalidate();
        //         form.validate();
        //         form.repaint();
        //     } catch (Exception e) {
        //         JOptionPane.showMessageDialog(null, e.getMessage());
        //     }
        // }
    }
    public static void main(String[] args) {
        LOGINPAGE form = new LOGINPAGE();
        form.setVisible(true);
        form.invalidate();
        form.validate();
        form.repaint();
    }
}
