import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Driver {
    public static void main(String[] args) {
        try {
            // # jdbc connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "geo";
            String password = "6023";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
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
