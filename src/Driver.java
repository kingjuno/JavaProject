import java.sql.Connection;

import javax.swing.JOptionPane;

import sqlUtils.ConnectDB;

public class Driver {
    public static void main(String[] args) {
        String username = "pheonixfire";
        String password = "Lastimosa5184";
        String url = "jdbc:postgresql://localhost:5432/music_recording";

        ConnectDB connectDB = new ConnectDB(username, password, url);
        Connection con = connectDB.getConnection();

        try {
            LOGINPAGE form = new LOGINPAGE(con);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
