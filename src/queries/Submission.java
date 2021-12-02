package queries;

import java.sql.*;

import util.DisplayInterface;

public class Submission {

    public static void printTable(ResultSet rs) {
        try {
            System.out.println("+---------------+---------------+----------+----------+-----------+");
            System.out.println("|SubmissionID   |ContestID      |ProblemID |Username  |Verdict    |");
            System.out.println("+---------------+---------------+----------+----------+-----------+");
            do {
                System.out.printf("|%-15d|%-15d|%-10s|%-10s|%-11s|\n", rs.getInt(1), rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4), rs.getString(5));
            } while (rs.next());
            System.out.println("+---------------+---------------+----------+----------+-----------+");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayAll(Connection con) {
        ResultSet rs = DisplayInterface.displayTable(con, "Submission");
        if (rs == null)
            return;
        printTable(rs);
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

    public static void updateVerdictBySub(Connection con, String SubmissionID, String ver) {
        try {
            String query = "update Submission set verdict = ? where SubmissionID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ver);
            preparedStmt.setString(2, SubmissionID);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Update failed!!!");
            } else {
                System.out.println("Updated successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void updateVerdictByProb(Connection con, String ProblemID, String ver) {
        try {
            String query = "update Submission set verdict = ? where ProblemID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ver);
            preparedStmt.setString(2, ProblemID);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Update failed!!!");
            } else {
                System.out.println("Updated successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchBySubId(Connection con, String id) {
        try {
            String query = "select * from Submission where SubmissionID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Submissions");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByConId(Connection con, String id) {
        try {
            String query = "select * from Submission where ContestID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Submissions");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByProbId(Connection con, String id) {
        try {
            String query = "select * from Submission where ProblemID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Submissions");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteSubBySub(Connection con, String id) {
        try {
            String query = "delete from user where SubmissionID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a Submission");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteSubByCon(Connection con, String id) {
        try {
            String query = "delete from user where ContestID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a Submission");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteSubByProb(Connection con, String id) {
        try {
            String query = "delete from user where ProblemID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a Submission");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

}