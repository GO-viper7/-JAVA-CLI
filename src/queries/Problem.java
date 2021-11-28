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
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get Help Menu");
        }
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
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchProblems(Connection con) {
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
            String query = "update problem set ProblemRating = ? where ProblemID =?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(rating));
            preparedStmt.setString(2, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Update failed!!!");
            } else {
                System.out.println("Updated");
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
                do {
                    System.out.printf("%-15s%-15s%-10d%-10d\n", rs.getString(1), rs.getString(2),
                            rs.getInt(3), rs.getInt(4));
                } while (rs.next());
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
            preparedStmt.setInt(1, Integer.parseInt(ContestID));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                do {
                    System.out.printf("%-15s%-15s%-10d%-10d\n", rs.getString(1), rs.getString(2),
                            rs.getInt(3), rs.getInt(4));
                } while (rs.next());
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByRating(Connection con, String Rating) {
        try {
            String query = "select * from problem where ProblemRating = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(Rating));
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from problems");
            } else {
                do {
                    System.out.printf("%-15s%-15s%-10d%-10d\n", rs.getString(1), rs.getString(2),
                            rs.getInt(3), rs.getInt(4));
                } while (rs.next());
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
                do {
                    System.out.printf("%-15s%-15s%-10d%-10d\n", rs.getString(1), rs.getString(2),
                            rs.getInt(3), rs.getInt(4));
                } while (rs.next());
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
                System.out.println("Id " + id + " not presnt in menu");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

}
