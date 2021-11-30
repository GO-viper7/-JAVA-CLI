package queries;

import java.sql.*;

public class Contest {
    public void createContests(Connection con){
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from account");
            while (rs.next()) {
                System.out.println(rs.getString("account_number") + " " + rs.getDouble("balance"));
            }
            stmt.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
