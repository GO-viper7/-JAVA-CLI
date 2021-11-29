package queries;

import java.sql.*;

public class Submission {

    public static void printTable(ResultSet rs) {
        try {
            System.out.println("+---------------+---------------+----------+----------+-----------+");
            System.out.println("|SubmissionID   |ContestID      |ProblemID |Username  |Verdict    |");
            System.out.println("+---------------+---------------+----------+----------+-----------+");
            do {
                System.out.printf("|%-15s|%-15s|%-10d|%-10d|%-11s|\n", rs.getString(1), rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
            } while (rs.next());
            System.out.println("+---------------+---------------+----------+----------+-----------+");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayAll(Connection con) {
            try {
                Statement st = con.createStatement();
                ResultSet result1 = st.executeQuery("select * from submission");

                if (result1.next() == false) {
                    System.out.println("No Result from Submissions");
                } else {
                    System.out.println("Submissions Table :\n");
                    printTable(result1);
                }
                System.out.printf("\n");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    public static void insertSubmissions(Connection con, String tuple) {
        try {
            String[] args = tuple.split(" ");
            String query = " insert into Submission(SubmissionID,ContestID,ProblemID,UserName,Verdict) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, args[0]);
            preparedStmt.setString(2, args[1]);
            preparedStmt.setInt(3, Integer.parseInt(args[2]));
            preparedStmt.setInt(4, Integer.parseInt(args[3]));
            preparedStmt.setString(5, args[4]);
            preparedStmt.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }