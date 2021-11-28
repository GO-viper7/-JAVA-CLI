package queries;

import java.sql.*;

public class Problem {

    public static void displayAll(Connection con) {
        try {
            Statement st = con.createStatement();
            ResultSet result3 = st.executeQuery("select * from problem");
            if (result3.next() == false) {
                System.out.println("No Result from problems");
            } else {

                do {
                    System.out.printf("%-15s%-15s%-10d%-10d\n", result3.getString(1), result3.getString(2),
                            result3.getInt(3), result3.getInt(4));
                } while (result3.next());
            }
            System.out.printf("\n");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get Help Menu");
        }
    }

    public void createProblems(Connection con) {

    }

    public void searchProblems(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from account");
            while (rs.next()) {
                System.out.println(rs.getString("account_number") + " " + rs.getDouble("balance"));
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProblems(Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update account set balance = balance + 100 where account_number = '123456789'");
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProblems(Connection con) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from account where account_number = '123456789'");
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
