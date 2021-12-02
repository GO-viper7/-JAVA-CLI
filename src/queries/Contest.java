package queries;

import java.sql.*;

import util.DisplayInterface;

public class Contest {

    public static void printTable(ResultSet rs) {
        try {
            System.out.println("+---------------+---------------+----------+--------------+--------------+");
            System.out.println("|ContestID      |Author         |Division  |StartTime     |EndTime       |");
            System.out.println("+---------------+---------------+----------+--------------+--------------+");
            do {
                System.out.printf("|%-15d|%-15s|%-10d|%-20s|%-20s|\n", rs.getInt(1), rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4), rs.getString(5));
            } while (rs.next());
            System.out.println("+---------------+---------------+----------+--------------+--------------+");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayAll(Connection con) {
        ResultSet rs = DisplayInterface.displayTable(con,"Contest");
        if(rs==null)
            return;
        printTable(rs);
    }

    public static void insertContest(Connection con, String tuple) {
        try {
            String[] args = tuple.split(" ");
            String query = " insert into Contest(ContestID,Author,Division,StartTime,EndTime) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(args[0]));
            preparedStmt.setString(2, args[1]);
            preparedStmt.setInt(3, Integer.parseInt(args[2]));
            preparedStmt.setString(4, args[3]);
            preparedStmt.setString(5, args[4]);
            preparedStmt.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void updateAuthor(Connection con, String ContestID, String Author) {
        try {
            String query = "update Contest set Author = ? where ContestID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(ContestID));
            preparedStmt.setString(2, Author);
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

    public static void updateDivision(Connection con, String ContestID, String Division) {
        try {
            String query = "update Contest set Division = ? where ContestID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Division));
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

    public static void updateStartTime(Connection con, String ContestID, String StartTime) {
        try {
            String query = "update Contest set StartTime = ? where ContestID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, StartTime);
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

    public static void updateEndTime(Connection con, String ContestID, String EndTime) {
        try {
            String query = "update Contest set EndTime = ? where ContestID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, EndTime);
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

    public static void searchByContestId(Connection con, String ContestID) {
        try {
            String query = "select * from Contest where ContestID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(ContestID));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Contest");
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
            String query = "select * from Contest where Author = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, Author);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Contest");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByDivision(Connection con, String Division, String operator) {
        try {
            String query = "select * from Contest where Division " + operator + " ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Division));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Contest");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByStartTime(Connection con, String StartTime) {
        try {
            String query = "select * from Contest where StartTime = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, StartTime);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Contest");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByEndTime(Connection con, String EndTime) {
        try {
            String query = "select * from Contest where EndTime = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, EndTime);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Contest");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteContests(Connection con, String id) {
        try {
            String query = "delete from Contest where ContestID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(id));
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a registered Contest.");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void sortContests(Connection con, String sort) {
        try {
            String query = "select * from Contest order by " + sort;
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Contest");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

}
