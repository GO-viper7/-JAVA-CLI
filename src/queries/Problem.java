package queries;

import java.sql.*;

public class Problem {
    public void createProblems(Connection con){
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Problem");
            while (rs.next()) {
                System.out.println(rs.getString("ProblemID") + " " + rs.getInt("ProblemRating"));
            }
            stmt.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void searchProblems(Connection con){
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

    public void updateProblems(Connection con){
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update account set balance = balance + 100 where account_number = '123456789'");
            stmt.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteProblems(Connection con){
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from account where account_number = '123456789'");
            stmt.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
