import java.io.*;
import java.sql.*;

public class Data {
    public static void loadProblemsData(Connection conn) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Problems.csv"));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] problem = line.split(",");

                String query = "insert into PROBLEM(problemid,author,problemrating,contestid) values (?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, problem[0]);
                preparedStmt.setString(2, problem[1]);
                preparedStmt.setInt(3, Integer.parseInt(problem[2]));
                preparedStmt.setInt(4, Integer.parseInt(problem[3]));
                preparedStmt.execute();
            } // bruh ids are strings
            System.out.println("DATA INSERTED");
            br.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void loadSubmissionsData(Connection conn) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Submissions.csv"));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] submission = line.split(",");

                String query = "insert into SUBMISSION(submissionid,problemid,author,submissionrating,contestid) values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, submission[0]);
                preparedStmt.setString(2, submission[1]);
                preparedStmt.setString(3, submission[2]);
                preparedStmt.setString(4, submission[3]);
                preparedStmt.setString(5, submission[4]);
                preparedStmt.execute();
            }
            System.out.println("DATA INSERTED");
            br.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
