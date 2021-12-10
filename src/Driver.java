import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import sqlUtils.ConnectDB;

public class Driver {
    public static void main(String[] args) {
        String username = "";
        String password = "";
        String url = "jdbc:postgresql://localhost:5432/music_recording_system";

        ConnectDB connectDB = new ConnectDB(username, password, url);
        Connection con = connectDB.getConnection();

        try {
            LOGINPAGE form = new LOGINPAGE();
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
