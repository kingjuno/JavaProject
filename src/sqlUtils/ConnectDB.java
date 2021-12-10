package sqlUtils;

import java.sql.*;

public class ConnectDB {
    String UserName, Password, url;
    
    public ConnectDB(String UserName, String Password, String url) {
        this.UserName = UserName;
        this.Password = Password;
        this.url = url;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, UserName, Password);
            System.out.println("Connected To Database\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
