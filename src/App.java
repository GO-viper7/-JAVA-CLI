import database.*;
import java.io.*;
import java.sql.*;
import queries.*;
import operations.display.*;

public class App {
    private static Connection conn = null;

    public static void createTables() {
        try {
            Statement stmt2 = conn.createStatement();
            String table1 = "CREATE TABLE Problem (ProblemID varchar(50),Author varchar(255),ProblemRating int,ContestID int);";
            String table2 = "CREATE TABLE Users (Username varchar(255),Rating int,MaxRating int,Organisation varchar(255),City varchar(255),Country varchar(255),Contribution int);";
            String table3 = "CREATE TABLE Contest (ContestID int,Author varchar(100),Division int,StartTime datetime,EndTime datetime);";
            String table4 = "CREATE TABLE Submission (SubmissionID int,ContestID int,ProblemID varchar(50),UserName varchar(255),Verdict varchar(50));";
            String dropProblem = "drop table if exists Problem";
            String dropUsers = "drop table if exists Users";
            String dropContest = "drop table if exists Contest";
            String dropSubmission = "drop table if exists Submission";
            stmt2.executeUpdate(dropProblem);
            stmt2.executeUpdate(dropUsers);
            stmt2.executeUpdate(dropContest);
            stmt2.executeUpdate(dropSubmission);
            stmt2.executeUpdate(table1);
            stmt2.executeUpdate(table2);
            stmt2.executeUpdate(table3);
            stmt2.executeUpdate(table4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        sqlconnectivity codeforces = new sqlconnectivity();
        try {
            conn = codeforces.connectSql();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        switch (args[0]) {
        case "-clearData":
            createTables();
            codeforces.disconnect(conn);
            break;
        case "-load":
            Data.loadProblemsData(conn);
            Data.loadSubmissionsData(conn);
            codeforces.disconnect(conn);
            break;
        case "-s":
            switch (args[1]) {
            case "all":
                Display.displayAll(conn);
                codeforces.disconnect(conn);
                break;
            }
            // case "fl":
            // switch (args[2]) {
            // case "cat":

            // Display.displayCatagoriesFirstLetter(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // case "foodname":

            // Display.displayFoodNameFirstLetter(con, args[3]);
            // codeforces.disconnect(conn);
            // break;

            // default:
            // printHelp();
            // break;
            // }
            // case "ps":
            // switch (args[2]) {
            // case "cat":

            // Display.displayCatagoriesPartialString(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // case "foodname":

            // Display.displayFoodNamePartialString(con, args[3]);
            // codeforces.disconnect(conn);
            // break;

            // default:
            // printHelp();
            // break;
            // }
            // break;
            // case "range":
            // switch (args[2]) {
            // case "-e":
            // Display.displayPriceEqual(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // case "-g":
            // Display.displayPriceGreater(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // case "-ge":
            // Display.displayPriceGreaterEqual(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // case "-l":
            // Display.displayPriceLesser(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // case "-le":
            // Display.displayPriceLesserEqual(con, args[3]);
            // codeforces.disconnect(conn);
            // break;
            // default:
            // printHelp();
            // break;
            // }
            // break;
            // default:
            // printHelp();

            // break;
            // }
            // break;
            // case "-i"
            // Insert.insertRecord(conn, args);
            // codeforces.disconnect(conn);
            // break;
            // case "-count":
            // switch (args[1]) {

            // case "cat":

            // CountByCategory.count(conn);
            // codeforces.disconnect(conn);
            // break;
            // case "veg":

            // CountByVeg.count(con);
            // codeforces.disconnect(conn);
            // break;
            // case "nonveg":

            // CountByNonVeg.count(con);
            // codeforces.disconnect(conn);
            // break;
            // default:
            // printHelp();

            // break;
            // }
            // break;
            // case "-avg":
            // switch (args[1]) {

            // case "cat":

            // AvgByCategory.avg(con);
            // codeforces.disconnect(conn);
            // break;
            // case "veg":

            // AvgByVeg.avg(con);
            // codeforces.disconnect(conn);
            // break;
            // case "nonveg":

            // AvgByNonAvg.avg(con);
            // codeforces.disconnect(conn);
            // break;
            // default:
            // printHelp();

            // break;
            // }

            // break;
            // case "-u":
            // switch (args[1]) {

            // case "cat":

            // Update.updateByCategory(con, args);
            // codeforces.disconnect(conn);
            // break;
            // case "veg":

            // Update.updateByVeg(con, args);
            // codeforces.disconnect(conn);
            // break;
            // case "nonveg":

            // Update.updateByNonVeg(con, args);
            // codeforces.disconnect(conn);
            // break;
            // case "id":

            // Update.updateByFoodId(con, args);
            // codeforces.disconnect(conn);
            // break;
            // case "all":

            // Update.updateAll(con, args);
            // codeforces.disconnect(conn);
            // break;
            // default:
            // printHelp();

            // break;
            // }
            // break;
            // case "-o":
            // switch (args[1]) {

            // case "create":
            // OrderList.createOrder(con, args);
            // codeforces.disconnect(conn);
            // break;
            // case "show":

            // OrderList.printOrder(con);
            // codeforces.disconnect(conn);
            // break;
            // case "showmore":

            // OrderList.printOrderMore(con);
            // codeforces.disconnect(conn);
            // break;
            // case "cone":

            // OrderList.cancelOrder(con,Integer.parseInt(args[2]));
            // codeforces.disconnect(conn);
            // break;
            // case "call":

            // OrderList.cancelOrder(conn);
            // codeforces.disconnect(conn);
            // break;
            // default:
            // printHelp();

            // break;
            // }
            // break;
            // case "-d":

            // Delete.deleteRecord(conn,args);
            // codeforces.disconnect(conn);
            // break;
            // case "-h":
            // printHelp();
            // break;
            // default:
            // printHelp();
            // break;
        }
    }
}
