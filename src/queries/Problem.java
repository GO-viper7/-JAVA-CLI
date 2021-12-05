package queries;

import java.util.ArrayList;
import java.sql.*;
import operations.Paginate;
import util.DisplayInterface;

class paginatorProblem extends Paginate{
    public void printPartialTable(ArrayList<String> rs, int startRow, int endRow) {
        System.out.println("+---------------+---------------+---------------+----------+");
        System.out.println("|ProblemID      |Author         |ProblemRating  |ContestID |");
        System.out.println("+---------------+---------------+---------------+----------+");
        for (int i = startRow; i <= endRow; i++) {
            System.out.print(rs.get(i));
        }
        System.out.println("+---------------+---------------+---------------+----------+");
    }
    public ArrayList<String> getRows(ResultSet rs){
        ArrayList<String> resultRows = new ArrayList<>();
        try{ 
            do {
                resultRows.add(String.format("|%-15s|%-15s|%-15d|%-10d|\n", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            } while (rs.next());
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return resultRows;
    }
}

public class Problem implements DisplayInterface {

    public static void printTable(ResultSet rs) {
        paginatorProblem pg = new paginatorProblem();
        pg.paginate(rs);
    }

    public static void displayAll(Connection con, Boolean checkSort) {
        ResultSet rs = DisplayInterface.displayTable(con, "Problem", checkSort);
        if (rs == null)
            return;
        printTable(rs);
    }

    public static void insertProblems(Connection con, String tuple) {
        try {
            String[] args = tuple.split(" ");
            String query = " insert into Problem(ProblemID,Author,ProblemRating,ContestID) values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, args[0]);
            preparedStmt.setString(2, args[1]);
            preparedStmt.setInt(3, Integer.parseInt(args[2]));
            preparedStmt.setInt(4, Integer.parseInt(args[3]));
            preparedStmt.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }
    
    public static void displayCount(Connection con) {
        try {
            ResultSet rs = DisplayInterface.displayTable(con,"Problem");
            try{ 
                Integer cnt=0;
                do {
                    cnt=cnt+1;
               } while (rs.next());
               System.out.println("Number of Records in Problem Table : "+cnt);
            }catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }   
    }

    public static void displaySumRating(Connection con) {
        ResultSet rs = DisplayInterface.displayTable(con,"Problem");
        try{ 
            Integer sum=0;
            do {
                sum+=(rs.getInt(3));
            } while (rs.next());
            System.out.println("Sum of Rating of Problems in Problem Table : "+sum);
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayAvg(Connection con) {
        ResultSet rs = DisplayInterface.displayTable(con,"Problem");
        try{ 
            Integer sum=0,cnt=0;
            do {
                sum+=(rs.getInt(3));
                cnt+=1;
            } while (rs.next());
            System.out.println("Average Rating of Problems in Problem Table : "+sum/cnt);
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateRatingByContest(Connection con, String ContestID, String Rating) {
        try {
            String query = "update problem set ProblemRating = ? where ContestID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            preparedStmt.setInt(2, Integer.parseInt(ContestID));
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

    public static void updateRating(Connection con, String id, String rating) {
        try {
            String query = "update problem set ProblemRating = ? where ProblemID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(rating));
            preparedStmt.setString(2, id);
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

    public static void searchById(Connection con, String id) {
        try {
            String query = "select * from problem where ProblemID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByContest(Connection con, String ContestID) {
        try {
            String query = "select * from problem where ContestID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ContestID);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByRating(Connection con, String Rating, String operator, Boolean checkSort) {
        try {
            String query = "select * from problem where ProblemRating " + operator + " ?";
            if (checkSort)
                query += " order by ProblemRating";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByAuthor(Connection con, String Author) {
        try {
            String query = "select * from problem where Author = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, Author);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteProblems(Connection con, String id) {
        try {
            String query = "delete from problem where ProblemID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a problem");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void sortProblems(Connection con, String sort) {
        try {
            String query = "select * from problem order by " + sort;
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

}
