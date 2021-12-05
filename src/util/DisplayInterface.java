package util;

import java.sql.*;

public interface DisplayInterface {
    public static ResultSet displayTable(Connection con, String tableName, Boolean checkSort) {
        try {
            Statement st = con.createStatement();
            String query = "SELECT * FROM " + tableName;
            if (checkSort) {
                if (tableName == "Problem") {
                    query += " order by problemRating";
                }
                if (tableName == "User") {
                    query += " order by Rating";
                }
                if (tableName == "Subbmission") {
                    query += " order by submissionId";
                }
                if (tableName == "Contest") {
                    query += " order by division";
                }
            }
            ResultSet rs = st.executeQuery(query);
            if (rs.next() == false) {
                System.out.println("No Result from " + tableName);
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
