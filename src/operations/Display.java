package operations;

import java.sql.*;

public class Display {
    public static void displayAll(Connection con) {
        try {

            Statement st = con.createStatement();



            ResultSet result1 = st.executeQuery("select * from Problem");
            if (result1.next() == false) {
                System.out.println("No Result from Problems");
            }
             else{
                System.out.println("Problems Table :\n");
                System.out.println("+---------------+---------------+---------------+----------+");
                System.out.println("|ProblemID      |Author         |ProblemRating  |ContestID |");
                System.out.println("+---------------+---------------+---------------+----------+");
                
                do {
                    System.out.printf("|%-15s|%-15s|%-15d|%-10d|\n", result1.getString(1), result1.getString(2),
                            result1.getInt(3), result1.getInt(4));
                } while (result1.next());
                System.out.println("+---------------+---------------+---------------+----------+");
                System.out.printf("\n\n");
             }






            ResultSet result2 = st.executeQuery("select * from User");
            if (result2.next() == false) {
                System.out.println("No Result from Useresult4");
            } else {
                System.out.println("Users Table :\n");
                System.out.println("+---------------+---------------+----------+----------+----------------+---------------+---------------+--------------+");
                System.out.println("|UserID         |Username       |Rating    |MaxRating |Organisation    |City           |Country        |Contribution  |");
                System.out.println("+---------------+---------------+----------+----------+----------------+---------------+---------------+--------------+");
                do {
                    System.out.printf("|%-15s|%-15s|%-10d|%-10d|%-16s|%-15s|%-15s|%-14d|\n", result2.getString(1), result2.getString(2),
                            result2.getInt(3),
                            result2.getInt(4), result2.getString(5), result2.getString(6), result2.getString(7), result2.getInt(8));
                } while (result2.next());
                System.out.println("+---------------+---------------+----------+----------+----------------+---------------+---------------+--------------+");
                System.out.printf("\n\n");
            }








            
            // ResultSet result3 = st.executeQuery("select * from contest");

            // if (result3.next() == false) {
            //     System.out.println("No Result from contests");
            // } else {

            //     System.out.println("Contests Table :\n");

            //     do {
            //         System.out.printf("%-10d%-15s%-10d%-15s%-15s\n", result3.getInt(1), result3.getString(2),
            //                 result3.getInt(3), result3.getString(4), result3.getString(5));
            //     } while (result3.next());
            // }
            // System.out.printf("\n\n");









            ResultSet result4 = st.executeQuery("select * from submission");

            if (result4.next() == false) {
                System.out.println("No Result from submissions");
            } else {
                System.out.println("Submissions Table :\n");
                System.out.println("+---------------+---------------+----------+----------+-----------+");
                System.out.println("|SubmissionID   |ContestID      |ProblemID |Username  |Verdict    |");
                System.out.println("+---------------+---------------+----------+----------+-----------+");
                do {
                    System.out.printf("|%-15d|%-15d|%-10s|%-10s|%-11s|\n", result4.getInt(1), result4.getInt(2),
                        result4.getString(3),
                        result4.getString(4),result4.getString(5));
                } while (result4.next());
                System.out.println("+---------------+---------------+----------+----------+-----------+");
                System.out.printf("\n\n");
            }
            
            
        } catch (Exception e) {
             System.out.println(e);
             System.out.println("Wrong command\nType \"-h\" to get Help Menu");
        }
            
            
            
            
            
            
            
            
            

    }
}
