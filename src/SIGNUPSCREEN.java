import javax.swing.*;

import UIutils.OpaqueButton;
import UIutils.transparentButton;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

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
	Connection con;

    SIGNUPSCREEN(Connection con) 
    {
        this.con=con;
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
		
		Signup = new OpaqueButton("Sign Up");
		Signup.setBounds(295, 280, 105, 21);
		Signup.addActionListener(this);
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

	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern)
		  .matcher(emailAddress)
		  .matches();
	}

	boolean validate(String username, String password, String email){
		if(username.length()<=4 && username.length()>=20){
			JOptionPane.showMessageDialog(null, "Username cannot be empty");
			return false;
		}
		if(password.length()<=8 && password.length()>=20){
			JOptionPane.showMessageDialog(null, "Password cannot be empty");
			return false;
		}
		if(email.length()<=0){
			JOptionPane.showMessageDialog(null, "Email cannot be empty");
			return false;
		}
		if(!patternMatches(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
			JOptionPane.showMessageDialog(null, "Invalid Email");
			return false;
		}
		return true;
	}

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Signup) {
			System.out.println("Signup");
			String User_id_input = user_id_input.getText();
			String Password_input = password_input.getText();
			String Email_input = email_input.getText();
			String Role_input = (String) comboBox.getSelectedItem();

			if (validate(User_id_input, Password_input, Email_input)) {
				try {
					String query = "insert into user_info(user_id,password,email,role) values('" + User_id_input + "','"
							+ Password_input + "','" + Email_input + "','" + Role_input + "')";
					con.createStatement().executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Sign Up Successful");
					this.dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "User already exists");
				}
			}

        }
        else if (ae.getSource() ==  Login) {
            //rewrite current jframe with LOGIN CLASS
        }
    }
//    public static void main(String[] args) {
//         SIGNUPSCREEN form = new SIGNUPSCREEN();
//         form.setVisible(true);
//         form.invalidate();
//         form.validate();
//         form.repaint();
//     }
    
    
}
