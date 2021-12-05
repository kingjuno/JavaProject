import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class SIGNUPSCREEN extends JFrame implements ActionListener{
    JLabel login_signup;
    JPanel login_window,signup_window;
    JLabel user_id,password,email,cpassword,roles;
    JTextField user_id_input,password_input,cpassword_input,email_input;
    GridBagConstraints Gridwidth;
    JButton login_button,signup_button;
     


    SIGNUPSCREEN() 
    {
        setTitle("Music Recording Company");
        setSize(500,450);

        login_button = new JButton("Login");
        login_button.addActionListener(this);
        signup_button = new JButton("Sign Up");
        signup_button.addActionListener(this);

        signup_window = new JPanel();
        signup_window.setBackground(new Color(143, 134, 118));
        this.getContentPane().add(signup_window);
        signup_window.setLayout(null);
        signup_window.setBounds(0, 0, 400, 400);
        signup_window.add(login_button);
        login_button.setBounds(400,400,400,400);


        user_id = new JLabel("User ID");
        email = new JLabel("Email");
        password = new JLabel("Password");
        
        roles = new JLabel("Role");
        

        String languages[]={"user","artist","admin"};        
        final JComboBox<String> cb = new JComboBox<String>(languages);   


        login_signup = new JLabel("Signup");
        login_signup.setFont(new Font("Serif",Font.BOLD,25));

        user_id_input = new JTextField();
        password_input = new JTextField();
        cpassword_input = new JTextField();
        email_input = new JTextField();

        user_id.setBounds(30,80,100,30);
        email.setBounds(30,120,100,30);
        password.setBounds(30,160,100,30);
        roles.setBounds(30,200,100,30);



        user_id_input.setBounds(160,80,290,30);
        email_input.setBounds(160,120,290,30);
        password_input.setBounds(160,160,290,30);
        cb.setBounds(160,200,100,30);
        

        signup_button.setBounds(250,300,100,30);
        login_button.setBounds(110,300,100,30);

        login_signup.setBounds(190,20,100,30);


        signup_window.add(user_id);
        signup_window.add(email);
        signup_window.add(password);        
        
        signup_window.add(user_id_input);
        signup_window.add(password_input);
        signup_window.add(roles);
        signup_window.add(email_input); 
        signup_window.add(cb);
        signup_window.add(login_button);
        signup_window.add(signup_button);
        signup_window.add(login_signup);

        add(signup_window, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {


        String User_id = user_id_input.getText();
        String Password = password_input.getText();


        if (ae.getSource() == signup_button) {
            this.dispose();
            if(User_id == "" && Password == ""){
                // JDBC CONNECTION HERE
                /*
                [TODO]:
                1. Check if user exists
                2. Check if password is valid
                3. If correct, GO TO HOME PAGE
                */
            }
            else{
                this.dispose();
                Home form = new Home();
                form.setVisible(true);
                form.invalidate();
            }
        }
        else if (ae.getSource() ==  login_button) {
            this.dispose();
            try {

                LOGINPAGE form = new LOGINPAGE();
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
