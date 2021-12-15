package sqlUtils;

import java.sql.*;

public class CreateAlbumTable {
    Connection conn = null;
    public CreateAlbumTable(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE album_info (album_id serial PRIMARY KEY , album_name varchar(20), artist_id varchar(20), no_of_songs int, release_date date,FOREIGN KEY (artist_id) REFERENCES artist_info(artist_id));";
            stmt.executeUpdate(sql);
            String userName = conn.getMetaData().getUserName();
            sql = "GRANT ALL PRIVILEGES ON TABLE album_info to " + userName +";";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
