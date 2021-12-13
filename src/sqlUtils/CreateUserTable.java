package sqlUtils;

import java.sql.*;

public class CreateUserTable {
    Connection conn = null;
    public CreateUserTable(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "create table user_info(user_id varchar(20),password varchar(20),email varchar(20),role varchar(20),primary key(user_id))";
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
