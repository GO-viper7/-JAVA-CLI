package database;

import java.sql.*;

public class sqlconnectivity {
    public void connectSql() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            String URL="jdbc:mysql://localhost:3306/lab4";
            String USER="root";
            String PASS="7886";
            Connection con = DriverManager.getConnection(URL, USER, PASS);
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
}
