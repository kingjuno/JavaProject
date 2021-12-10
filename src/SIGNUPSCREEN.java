import javax.swing.*;

import UIutils.OpaqueButton;
import UIutils.transparentButton;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class SIGNUPSCREEN extends JFrame implements ActionListener{
    JLabel login_signup;
    JPanel login_window,signup_window;
    JLabel uname, email, signup, icon, Role;
    JTextField user_id_input ,cpassword_input,email_input;
    GridBagConstraints Gridwidth;
    transparentButton Login;
    OpaqueButton Signup;
    JPasswordField password_input;
    String Options[]={"User","Artist","Admin"};
    JComboBox<String> comboBox;

    SIGNUPSCREEN() 
    {
        setTitle("Music Recording Company");
		this.setTitle("Music Recording Company");
		this.getContentPane().setBackground(new Color(66, 68, 67));
		this.getContentPane().setForeground(Color.WHITE);
		this.getContentPane().setEnabled(false);
		this.setBounds(100, 100, 564, 408);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Login = new transparentButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Login.setBounds(143, 280, 118, 21);
		this.getContentPane().add(Login);
		
		OpaqueButton Signup = new OpaqueButton("Sign Up");
		Signup.setBounds(295, 280, 105, 21);
		this.getContentPane().add(Signup);
		
		user_id_input = new JTextField();
		user_id_input.setBounds(347, 120, 142, 19);
		this.getContentPane().add(user_id_input);
		user_id_input.setColumns(10);
		
		uname = new JLabel("UserName");
		uname.setForeground(Color.WHITE);
		uname.setFont(new Font("Times New Roman", Font.BOLD, 10));
		uname.setBounds(279, 119, 47, 21);
		this.getContentPane().add(uname);
		
		icon = new JLabel("");
		icon.setIcon(new ImageIcon(this.getClass().getResource("assets/background.png")));
		icon.setBounds(-145, 43, 400, 218);
		this.getContentPane().add(icon);
		
		signup = new JLabel("Sign Up");
		signup.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		signup.setForeground(Color.WHITE);
		signup.setBounds(347, 83, 68, 21);
		this.getContentPane().add(signup);
		
		email = new JLabel("Email Id");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Times New Roman", Font.BOLD, 10));
		email.setBounds(279, 150, 47, 19);
		this.getContentPane().add(email);
		
		email_input = new JTextField();
		email_input.setColumns(10);
		email_input.setBounds(347, 149, 142, 19);
		this.getContentPane().add(email_input);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblPassword.setBounds(279, 180, 47, 19);
		this.getContentPane().add(lblPassword);
		
		password_input = new JPasswordField();
		password_input.setBounds(347, 179, 142, 19);
		this.getContentPane().add(password_input);
		
		comboBox = new JComboBox<String>(Options);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 10));
		comboBox.setBounds(347, 209, 142, 21);
		this.getContentPane().add(comboBox);
		
		Role = new JLabel("Role");
		Role.setForeground(Color.WHITE);
		Role.setFont(new Font("Times New Roman", Font.BOLD, 10));
		Role.setBounds(279, 213, 47, 19);
		this.getContentPane().add(Role);

    }

    public void actionPerformed(ActionEvent ae) {


        // String User_id = user_id_input.getText();
        // String Password = password_input.getText();


        // if (ae.getSource() == signup_button) {
        //     this.dispose();
        //     if(User_id == "" && Password == ""){
        //         // JDBC CONNECTION HERE
        //         /*
        //         [TODO]:
        //         1. Check if user exists
        //         2. Check if password is valid
        //         3. If correct, GO TO HOME PAGE
        //         */
        //     }
        //     else{
        //         this.dispose();
        //         Home form = new Home();
        //         form.setVisible(true);
        //         form.invalidate();
        //     }
        // }
        // else if (ae.getSource() ==  login_button) {
        //     this.dispose();
        //     try {

        //         LOGINPAGE form = new LOGINPAGE();
        //         form.setSize(500, 400);
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
        SIGNUPSCREEN form = new SIGNUPSCREEN();
        form.setVisible(true);
        form.invalidate();
        form.validate();
        form.repaint();
    }
    
    
}
