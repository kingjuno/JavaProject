import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class LOGINPAGE extends JFrame implements ActionListener{
    JLabel login_signup;
    JPanel login_window,signup_window;
    JLabel user_id,password;
    JTextField user_id_input,password_input;
    GridBagConstraints Gridwidth;
    JButton login_button,signup_button;

    LOGINPAGE() 
    {
        setTitle("Music Recording Company");

        login_button = new JButton("Login");
        login_button.addActionListener(this);
        signup_button = new JButton("Sign Up");
        signup_button.addActionListener(this);

        login_window = new JPanel();
        login_window.setBackground(new Color(143,134,118));
        this.getContentPane().add(login_window);
        login_window.setLayout(null);
        login_window.setBounds(0, 0, 400, 400);
        login_window.add(login_button);
        login_button.setBounds(400,400,400,400);


        user_id = new JLabel("User ID");
        password = new JLabel("Password");
        login_signup = new JLabel("Login");

        login_signup.setFont(new Font("Serif",Font.BOLD,25));

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
        System.out.println(User_id+'#'+Password);
        if (ae.getSource() == login_button) {
            if (User_id=="" && Password == ""){
                // JDBC CONNECTION HERE
                /*
                [TODO]:
                1. Check if user exists
                2. Check if password is correct
                3. If correct, GO TO HOME PAGE
                */
            }
            else{
                // for now ay user and password not empty something is fine
                // will fix this after connecting to DB
                this.dispose();
                Home form = new Home();
                form.setVisible(true);
                form.invalidate();
            }
            
        }
        else if (ae.getSource() == signup_button) {
            this.dispose();
            try {
                SIGNUPSCREEN form = new SIGNUPSCREEN();
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
