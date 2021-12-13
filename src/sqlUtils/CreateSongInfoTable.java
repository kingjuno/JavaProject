package sqlUtils;

import java.sql.*;

public class CreateSongInfoTable {
    Connection conn = null;
    public CreateSongInfoTable(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE song_info (song_id varchar(4) PRIMARY KEY ,song_name varchar(20),artist varchar(20),duration float,album varchar(20), release_year date);";
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
