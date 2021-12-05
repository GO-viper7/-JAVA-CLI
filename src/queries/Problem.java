package queries;

import java.util.ArrayList;
import java.sql.*;

import operations.Paginate;
import util.DisplayInterface;
<<<<<<< HEAD
class paginatorProblem extends Paginate{
    public void printPartialTable(ArrayList<String> rs, int startRow, int endRow){
=======

class paginatorProblem {
    public void paginate(ResultSet rs) {
        ArrayList<String> resultRows = new ArrayList<>();
        try {
            do {
                resultRows.add(String.format("|%-15s|%-15s|%-15d|%-10d|\n", rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4)));
            } while (rs.next());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        int maxPages = (resultRows.size() + 9) / 10;
        if (maxPages == 0)
            maxPages = 1;
        int currentPage = 1;
        Scanner scanner = new Scanner(System.in);
        int endPage = 9;
        if (resultRows.size() < 10)
            endPage = resultRows.size() - 1;
        printPartialTable(resultRows, 0, endPage);
        System.out.println("Page 1 of " + String.valueOf(maxPages));
        System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other number to exit.");
        while (true) {
            int choice = Integer.valueOf(scanner.nextLine());
            if (choice != 1 && choice != 2)
                break;
            else {
                if (choice == 1 && currentPage > 1)
                    currentPage--;
                else if (choice == 2 && currentPage < maxPages)
                    currentPage++;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int startPage = (currentPage - 1) * 10;
            endPage = resultRows.size() - 1;
            if (startPage + 9 < endPage)
                endPage = startPage + 9;
            printPartialTable(resultRows, startPage, endPage);
            System.out.println("Page " + String.valueOf(currentPage) + " of " + String.valueOf(maxPages));
            System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        }
        scanner.close();
    }

    public void printPartialTable(ArrayList<String> rs, int startRow, int endRow) {
>>>>>>> 08a15016973886bfc64e81cbadfb0a22697809af
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
