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
            } 
            System.out.println("DATA INSERTED");
            br.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void loadUsersData(Connection conn) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Users.csv"));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] user = line.split(",");

                String query = "insert into USERS(userid,username,Rating,MaxRating,Organisation,City,Country,Contribution) values (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, user[0]);
                preparedStmt.setString(2, user[1]);
                preparedStmt.setInt(3, Integer.parseInt(user[2]));
                preparedStmt.setInt(4, Integer.parseInt(user[3]));
                preparedStmt.setString(5, user[4]);
                preparedStmt.setString(6, user[5]);
                preparedStmt.setString(7, user[6]);
                preparedStmt.setInt(8, Integer.parseInt(user[7]));
                preparedStmt.execute();
            }
            System.out.println("DATA INSERTED");
            br.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void loadContestsData(Connection conn) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Contests.csv"));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] contest = line.split(",");

                String query = "insert into CONTEST(contestid,contestname,contestdate,contestrating) values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, Integer.parseInt(contest[0]));
                preparedStmt.setString(2, contest[1]);
                preparedStmt.setInt(3, Integer.parseInt(contest[2]));
                preparedStmt.setString(4, contest[3]);
                preparedStmt.setString(5, contest[4]);
                preparedStmt.execute();
            }
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
                preparedStmt.setInt(1, Integer.parseInt(submission[0]));
                preparedStmt.setInt(2, Integer.parseInt(submission[1]));
                preparedStmt.setInt(3, Integer.parseInt(submission[2]));
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
