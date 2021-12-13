package sqlUtils;

import java.sql.*;

public class CheckForData {
    Connection con = null;
    public CheckForData(Connection con) {
        this.con = con;
    }

    public boolean check_data_exist(String query){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
