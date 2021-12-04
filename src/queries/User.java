package queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import util.DisplayInterface;
class paginatorUser{
    public void paginate(ResultSet rs){
        ArrayList<String> resultRows = new ArrayList<>();
        try{ 
            do {
                resultRows.add(String.format("|%-15s|%-15s|%-10d|%-10d|%-16s|%-15s|%-15s|%-14d|\n", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            } while (rs.next());
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        int maxPages = (resultRows.size() + 9)/10;
        int currentPage = 1;
        Scanner scanner = new Scanner(System.in);
        int endPage = 9;
        if(resultRows.size() < 10)endPage = resultRows.size() - 1;
        printPartialTable(resultRows, 0, endPage);
        System.out.println("Page 1 of " + String.valueOf(maxPages));
        System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        while(true){
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
            int startPage = (currentPage - 1)*10;
            endPage = resultRows.size() - 1;
            if(startPage + 9 < endPage)endPage = startPage + 9;
            printPartialTable(resultRows, startPage,  endPage);
            System.out.println("Page " + String.valueOf(currentPage) + " of " + String.valueOf(maxPages));
            System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        }
        scanner.close();
    }
    public void printPartialTable(ArrayList<String> rs, int startRow, int endRow){
        System.out.println("+---------------+---------------+----------+----------+----------------+---------------+---------------+--------------+");
        System.out.println("|UserID         |Username       |Rating    |MaxRating |Organisation    |City           |Country        |Contribution  |");
        System.out.println("+---------------+---------------+----------+----------+----------------+---------------+---------------+--------------+");
        for(int i = startRow; i<=endRow; i++){
            System.out.print(rs.get(i));
        }
        System.out.println("+---------------+---------------+----------+----------+----------------+---------------+---------------+--------------+");
    }
}
public class User {

    public static void printTable(ResultSet rs) {
        paginatorUser pg = new paginatorUser();
        pg.paginate(rs);
    }

    public static void displayAll(Connection con) {
        ResultSet rs = DisplayInterface.displayTable(con,"User");
        if(rs==null)
            return;
        printTable(rs);
    }

    public static void insertUsers(Connection con, String tuple) {
        try {
            String[] args = tuple.split(" ");
            String query = " insert into user(UserID,Username,Rating,MaxRating,Organisation,City,Country,Contribution) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, args[0]);
            preparedStmt.setString(2, args[1]);
            preparedStmt.setInt(3, Integer.parseInt(args[2]));
            preparedStmt.setInt(4, Integer.parseInt(args[3]));
            preparedStmt.setString(5, args[4]);
            preparedStmt.setString(6, args[5]);
            preparedStmt.setString(7, args[6]);
            preparedStmt.setInt(8, Integer.parseInt(args[7]));
            preparedStmt.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void updateRating(Connection con, String UserID, String Rating) {
        try {
            String query = "update user set Rating = ? where UserID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            preparedStmt.setString(2, UserID);
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

    public static void updateMaxRating(Connection con, String UserID, String MaxRating) {
        try {
            String query = "update user set MaxRating = ? where UserID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(MaxRating));
            preparedStmt.setInt(2, Integer.parseInt(UserID));
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

    public static void updateOrganisation(Connection con, String UserID, String Organisation) {
        try {
            String query = "update user set Organisation = ? where UserID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, Organisation);
            preparedStmt.setInt(2, Integer.parseInt(UserID));
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

    public static void updateCity(Connection con, String UserID, String City) {
        try {
            String query = "update user set City = ? where UserID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, City);
            preparedStmt.setInt(2, Integer.parseInt(UserID));
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

    public static void updateCountry(Connection con, String UserID, String Country) {
        try {
            String query = "update user set Country = ? where UserID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, Country);
            preparedStmt.setInt(2, Integer.parseInt(UserID));
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

    public static void updateContribution(Connection con, String UserID, String Contribution) {
        try {
            String query = "update user set Contribution = ? where UserID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Contribution));
            preparedStmt.setInt(2, Integer.parseInt(UserID));
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
            String query = "select * from user where UserID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByRating(Connection con, String Rating, String operator) {
        try {
            String query = "select * from user where Rating " + operator + " ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByMaxRating(Connection con, String Rating, String operator) {
        try {
            String query = "select * from user where MaxRating " + operator + " ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByUsername(Connection con, String Author) {
        try {
            String query = "select * from user where Username like ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "%" + Author + "%");
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByOrganisation(Connection con, String Author) {
        try {
            String query = "select * from user where Organisation like ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "%" + Author + "%");
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByCity(Connection con, String Author) {
        try {
            String query = "select * from user where City like ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "%" + Author + "%");
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByCountry(Connection con, String Author) {
        try {
            String query = "select * from user where Country like ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "%" + Author + "%");
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByContribution(Connection con, String Rating, String operator) {
        try {
            String query = "select * from user where Contribution " + operator + " ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteUsers(Connection con, String id) {
        try {
            String query = "delete from user where UserID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a user");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void sortUsers(Connection con, String sort) {
        try {
            String query = "select * from user order by " + sort;
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from users");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

}
