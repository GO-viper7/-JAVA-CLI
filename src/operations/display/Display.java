package operations.display;

import java.sql.*;

public class Display {
    public static void displayAll(Connection con) {
        try {
            
            Statement st = con.createStatement();
            ResultSet result2 = st.executeQuery("select * from contest");

            if (result2.next() == false) {
                System.out.println("No Result from contests");
            } else {

                System.out.println("Contests Table :\n");

                do {
                    System.out.printf("%-10d%-15s%-10d%-15s%-15s\n", result2.getInt(1), result2.getString(2),
                            result2.getInt(3), result2.getString(4), result2.getString(5));
                } while (result2.next());
            }
            System.out.printf("\n\n");

            ResultSet result4 = st.executeQuery("select * from submission");

            if (result4.next() == false) {
                System.out.println("No Result from submissions");
            } else {

                System.out.println("Submissions Table :\n");

                do {
                    System.out.printf("%-10d%-10d%-10d%-15s%-15s\n", result4.getInt(1), result4.getInt(2),
                            result4.getString(3), result4.getString(4), result4.getString(5));
                } while (result4.next());
            }
            System.out.printf("\n");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get Help Menu");
        }

    }
}
