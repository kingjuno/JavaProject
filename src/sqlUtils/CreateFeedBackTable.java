package sqlUtils;

import java.sql.*;

public class CreateFeedBackTable {
    Connection conn = null;
    public CreateFeedBackTable(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE feedback_info (song_id varchar(20) ,user_id varchar(20),feedback_para varchar (1000));";
            stmt.executeUpdate(sql);
            String userName = conn.getMetaData().getUserName();
            sql = "GRANT ALL PRIVILEGES ON TABLE feedback_info to " + userName +";";
            stmt.executeUpdate(sql);    
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
