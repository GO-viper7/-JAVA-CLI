package database;

import java.sql.*;

public class sqlconnectivity {
    public Connection connectSql() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            String URL="jdbc:mysql://localhost:3306/codeforces";
            String USER="root";
            String PASS="7886";
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
