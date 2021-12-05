package queries;
import java.sql.*;
import operations.Paginate;
import java.util.ArrayList;
import util.DisplayInterface;

class paginatorSubmission extends Paginate{
    public void printPartialTable(ArrayList<String> rs, int startRow, int endRow){
        System.out.println("+---------------+---------------+----------+----------+-----------+");
        System.out.println("|SubmissionID   |ContestID      |ProblemID |Username  |Verdict    |");
        System.out.println("+---------------+---------------+----------+----------+-----------+");
        for(int i = startRow; i<=endRow; i++){
            System.out.print(rs.get(i));
        }
        System.out.println("+---------------+---------------+----------+----------+-----------+");
    }
    public ArrayList<String> getRows(ResultSet rs){
        ArrayList<String> resultRows = new ArrayList<>();
        try{ 
            do {
                resultRows.add(String.format("|%-15d|%-15d|%-10s|%-10s|%-11s|\n", rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            } while (rs.next());
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return resultRows;
    }
}
public class Submission {

    public static void printTable(ResultSet rs) {
        paginatorSubmission pg = new paginatorSubmission();
        pg.paginate(rs);
    }

    public static void displayAll(Connection con) {
        ResultSet rs = DisplayInterface.displayTable(con, "Submission",false);
        if (rs == null)
            return;
        printTable(rs);
    }

    public static void insertSubmissions(Connection con, String tuple) {
        try {
            int successCode = updateAll(con, tuple);
            if (successCode == 1)
                return;
            String[] args = tuple.split(" ");
            String query = " insert into Submission(SubmissionID,ContestID,ProblemID,UserName,Verdict) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(args[0]));
            preparedStmt.setInt(2, Integer.parseInt(args[1]));
            preparedStmt.setString(3, args[2]);
            preparedStmt.setString(4, args[3]);
            preparedStmt.setString(5, args[4]);
            preparedStmt.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static int updateAll(Connection con,String tuple){
        try{
            int success = 0;
            String[] args = tuple.split(" ");
            String query = "update Submission set ContestID=?,ProblemID=?,UserName=?,Verdict = ? where SubmissionID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, args[1]);
            preparedStmt.setInt(2, Integer.parseInt(args[2]));
            preparedStmt.setString(3, args[3]);
            preparedStmt.setString(4, args[4]);
            preparedStmt.setString(5, args[0]);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                return success;
            } else {
                System.out.println("Updated successfully");
                return success+1;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
            return 0;
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