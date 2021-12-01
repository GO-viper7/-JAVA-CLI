package util;
import java.sql.*;

public interface DisplayInterface {
    public static ResultSet displayTable(Connection con,String tableName) {
        try {
            Statement st = con.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
                System.out.println("No Result from "+tableName);
            } else {
                return rs;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get Help Menu");
        }
        return null;
    }
}
