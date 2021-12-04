import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

class login extends JFrame implements ActionListener{
    JLabel login_signup;
    JPanel login_window,signup_window;
    JLabel user_id,password;
    JTextField user_id_input,password_input;
    GridBagConstraints Gridwidth;
    JButton login_button,signup_button;

    login() 
    {
        setTitle("Music Recording Company");


        login_button = new JButton("Login");
        login_button.addActionListener(this);
        signup_button = new JButton("Sign Up");
        signup_button.addActionListener(this);

        login_window = new JPanel();
        this.getContentPane().add(login_window);
        login_window.setLayout(null);
        login_window.setBackground(Color.white);
        login_window.setBounds(0, 0, 400, 400);
        login_window.add(login_button);
        login_button.setBounds(400,400,400,400);


        user_id = new JLabel("User ID");
        password = new JLabel("Password");
        login_signup = new JLabel("Login");

        user_id_input = new JTextField();
        password_input = new JTextField();

        user_id.setBounds(30,120,100,30);
        password.setBounds(30,160,100,30);

        user_id_input.setBounds(170,120,290,30);
        password_input.setBounds(170,160,290,30);

        signup_button.setBounds(250,260,100,30);
        login_button.setBounds(110,260,100,30);

        login_signup.setBounds(190,20,100,30);


        login_window.add(user_id);
        login_window.add(password);
        login_window.add(user_id_input);
        login_window.add(password_input);
        login_window.add(login_button);
        login_window.add(signup_button);
        login_window.add(login_signup);

        add(login_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {


        String User_id = user_id_input.getText();
        String Password = password_input.getText();


        if (ae.getSource() == login_button) {
            this.dispose();
            try {

                login form = new login();
                form.setSize(500, 430);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else if (ae.getSource() == signup_button) {
            this.dispose();
            try {

                signup form = new signup();
                form.setSize(500, 400);
                form.setVisible(true);
                form.invalidate();
                form.validate();
                form.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
   
    
    
}


class login_form {

    public static void main(String arg[]) {
        try {

            login form = new login();
            form.setSize(500, 430);
            form.setVisible(true);
            form.invalidate();
            form.validate();
            form.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}