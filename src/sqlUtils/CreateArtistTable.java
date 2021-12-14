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
            String sql = "CREATE TABLE artist_info (artist_id varchar(20) PRIMARY KEY , first_name varchar(20),last_name varchar(20), address varchar(20),phone bigint, email varchar(20), dob date,FOREIGN KEY (artist_id) REFERENCES user_info(user_id));";
            stmt.executeUpdate(sql);
            String userName = conn.getMetaData().getUserName();
            sql = "GRANT ALL PRIVILEGES ON TABLE artist_info to " + userName +";";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
