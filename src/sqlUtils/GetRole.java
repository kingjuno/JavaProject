package sqlUtils;

import java.sql.*;

public class GetRole {
    Connection conn = null;
    String username;

    public GetRole(Connection conn, String username) {
        this.conn = conn;
        this.username = username;
    }

    public String getRolename() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "select role from user_info where user_id = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String role = rs.getString("role");
                return role;
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
