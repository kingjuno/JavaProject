package sqlUtils;

import java.sql.*;

public class CreateArtistTable {
    Connection conn = null;
    public CreateArtistTable(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE artist_info (artist_id varchar(8) PRIMARY KEY, first_name varchar(20),last_name varchar(20),address varchar(40),phone bigint,email varchar(20),dob date);";
            stmt.executeUpdate(sql);
            String userName = conn.getMetaData().getUserName();
            sql = "GRANT ALL PRIVILEGES ON TABLE user_info to " + userName +";";
            stmt.executeUpdate(sql);    
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
