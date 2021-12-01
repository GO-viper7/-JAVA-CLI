import database.*;
import java.io.*;
import java.sql.*;
import queries.*;
import java.util.Scanner;

public class App {
    private static Connection conn = null;

    public static void HelpMenu() {
        String[] com={"-ld","-dispall","-cd"};
        String[] des={"Load all the Existing Data into Tables to perform operations","Display all the tables in the Codeforces Database","Clear Data from the Database"};
           System.out.println("+--------------------+------------------------------------------------------------+");
           System.out.println("|Basic Commands      |Description                                                 |");
           System.out.println("+--------------------+------------------------------------------------------------+");
        for(int i=0;i<com.length;i++) {
            System.out.printf("|%-20s|%-60s|\n",com[i],des[i]);
        }
        System.out.println("+--------------------+------------------------------------------------------------+");
        String[] prob={"-prob -disp","-prob -ins","-prob -del <ProblemID>","-prob -upd -ratById <ProblemRating> <ProblemID>","-prob -upd -ratByConId <ProblemRating> <ContestID>",
                       "-prob -s -byId <ProblemID>","-prob -s -byConId <ContestID>","-prob -s -byRat -gt <ProblemRating>","-prob -s -byRat -lt <ProblemRating>",
                       "-prob -s -byRat -gte <ProblemRating>","-prob -s -byRat -lte <ProblemRating>","-prob -s -byRat -eq <ProblemRating>","-prob -s -byAut",
                       "-prob -sort -byConId <ContestID>","-prob -sort -byRat <ProblemRating>"};
        String[] des1={"Displays Problems Table","Insert Data into Problems Table","Delete Data from Problems Table using ProblemID",
                       "Update ProblemRating for the corresponding ProblemID","Update ProblemRating for the corresponding ContestID",
                       "Search Problems by providing ProblemID","Search Problems by providing ContestID","Search Problems which are greater than the respective ProblemRating",
                       "Search Problems which are less than the respective ProblemRating","Search Problems which are greater than or equals to the respective ProblemRating",
                       "Search Problems which are less than or equals to the respective ProblemRating","Search Problems which are equals to the respective ProblemRating",
                       "Search Problems by providing Name of the Author","Sort Problems by providing ContestID","Sort Problems by providing ProblemRating"};
        //System.out.println("                                                          +--------------------+-----------------------------------------------------------+\n\n");
        System.out.println("+-------------------------------------------------------+--------------------------------------------------------------------------------+");
        System.out.println("|Commands related to Problems Of Codeforces             |Description                                                                     |");
        System.out.println("+-------------------------------------------------------+--------------------------------------------------------------------------------+");
        for(int i=0;i<prob.length;i++) {
            System.out.printf("|%-55s|%-80s|\n",prob[i],des1[i]);
        }
        System.out.println("+-------------------------------------------------------+--------------------------------------------------------------------------------+");
        String[] user={"-user -disp","-user -ins","user -del <UserID>","-user -upd -ratById <UserID> <Rating>","-user -upd -maxratById <UserID> <MaxRating>","-user -upd -orgById <UserID> <Name of Organisation>",
                       "-user -upd -cityById <UserID> <Name of City>","-user -upd -couById <UserID> <Country>","-user -upd -contriById <UserID> <Contribution>","-user -s -byId <UserID>",
                       "-user -s -byRat -gt <Rating>","-user -s -byRat -lt <Rating>","-user -s -byRat -gte <Rating>","-user -s -byRat -lte <Rating>","-user -s -byRat -eq <Rating>",
                       "-user -s -byMaxRat -gt <MaxRating>","-user -s -byMaxRat -lt <MaxRating>","-user -s -byMaxRat -gte <MaxRating>","-user -s -byMaxRat -lte <MaxRating>","-user -s -byMaxRat -eq <MaxRating>",
                       "-user -s -byUser <UserName>","-user -s -byOrg <OrganisationName>","-user -s -byCity <CityName>","-user -s -byCou <CountryName>","-user -s -byContri gt <Contribution>",
                       "-user -s -byContri -lt <Contribution>","-user -s -byContri -gte <Contribution>","-user -s -byContri -lte <Contribution>","-user -s -byContri -eq <Contribution>","-user -sort -byId",
                       "-user -sort -byRat","-user -sort -byMaxRat","-user -sort -byContri"};
        String[] des2={"Displays Users Table","Insert Data into Users Table","Delete Data from Users Table for respective UserID","Update Rating by providing UserID","Update MaxRating by providing UserID",
                       "Update Name of Organisation by providing UserID","Update Name of City by providing UserID","Update Name of Country by providing UserID","Update Name of Contribution by providing UserID",
                       "Search Details of user by providing UserID","Search Details of user who has Rating greater than the provided Rating","Search Details of user who has Rating less than the provided Rating",
                       "Search Details of user who has Rating greater than or equals to the provided Rating","Search Details of user who has Rating lesser than or equals to the provided Rating",
                       "Search Details of user who has Rating equal to the provided Rating","Search Details of user who has MaxRating greater than the provided MaxRating","Search Details of user who has MaxRating lesser than the provided MaxRating",
                       "Search Details of user who has MaxRating greater than or equals to the provided MaxRating","Search Details of user who has MaxRating lesser than or equals to the provided MaxRating",
                       "Search Details of user who has MaxRating equal to the provided MaxRating","Search Details of user who has the respective Username","Search Details of user who is in the respective Organisation",
                       "Search Details of user who is in the respective City","Search Details of user who is in the respective Country","Search Details of user who has the Contribution greater than the provided Contribution",
                       "Search Details of user who has the Contribution lesser than the provided Contribution","Search Details of user who has the Contribution greater than or equal to the provided Contribution",
                       "Search Details of user who has the Contribution lesser than or equal to the provided Contribution","Search Details of user who has the Contribution equal to the provided Contribution",
                       "Sort the Users by providing UserID","Sort the Users by providing Rating","Sort the Users by providing MaxRating","Sort the Users by providing Contribution"};
        System.out.println("+-------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        System.out.println("|Commands related to Users Of Codeforces                |Description                                                                                         |");
        System.out.println("+-------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        for(int i=0;i<user.length;i++) {
            System.out.printf("|%-55s|%-100s|\n",user[i],des2[i]);
        }
        System.out.println("+-------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        String[] submission={"-sub -disp","-sub -ins","-sub -del -bySub <SubmissionID>","-sub -del -byCon <ContestID>","-sub -del -byProb <ProblemID>","-sub -upd -bySub <SubmissionID> <verdict>",
                             "-sub -upd -byProb <ProblemID> <verdict>","-sub -s -bySub <SubmissionID>","-sub -s -byCon <ContestID>","-sub -s -byProb <ProblemID>"};
        String[] des3={"Displays Submissions Table","Insert Data into Submissions Table","Delete Data from Submissions Table for respective SubmissiosnID",
                       "Delete Data from Submissions Table for respective ContestID","Delete Data from Submissions Table for respective ProblemID",
                       "Update Verdict of submission corresponding to provided SubmissionID","Update Verdict of submission corresponding to provided ProblemID","Search Submission Details for respective SubmissionID",
                       "Search Submission Details for respective ContestID","Search Submission Details for respective ProblemID"};
        System.out.println("+-------------------------------------------------------+--------------------------------------------------------------------------------+");
        System.out.println("|Commands related to Submissions Of Codeforces          |Description                                                                     |");
        System.out.println("+-------------------------------------------------------+--------------------------------------------------------------------------------+");
        for(int i=0;i<submission.length;i++) {
            System.out.printf("|%-55s|%-80s|\n",submission[i],des3[i]);
        }
        System.out.println("+-------------------------------------------------------+--------------------------------------------------------------------------------+");
        
    }

    public static void createTables() {
        try {
            Statement stmt2 = conn.createStatement();
            String table1 = "CREATE TABLE Problem (ProblemID varchar(50),Author varchar(255),ProblemRating int,ContestID int);";
            String table2 = "CREATE TABLE User (UserID varchar(50),Username varchar(255),Rating int,MaxRating int,Organisation varchar(255),City varchar(255),Country varchar(255),Contribution int);";
            String table3 = "CREATE TABLE Contest (ContestID int,Author varchar(100),Division int,StartTime datetime,EndTime datetime);";
            String table4 = "CREATE TABLE Submission (SubmissionID int,ContestID int,ProblemID varchar(50),UserName varchar(255),Verdict varchar(50));";
            String dropProblem = "drop table if exists Problem";
            String dropUsers = "drop table if exists User";
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
            System.out.println("Tables created successfully and Data cleared");
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
            case "-h":
                HelpMenu();
            case "-cd":
                createTables();
                codeforces.disconnect(conn);
                break;
            case "-ld":
                Data.loadProblemsData(conn);
                Data.loadUsersData(conn);
                Data.loadSubmissionsData(conn);
                codeforces.disconnect(conn);
                break;
            case "-dispall":
                operations.Display.displayAll(conn);
            case "-prob":
                switch (args[1]) {
                    case "-disp":
                        Problem.displayAll(conn);
                        codeforces.disconnect(conn);
                        break;
                    case "-ins":
                        System.out.println("Write the tuple you want to insert");
                        Scanner sc = new Scanner(System.in);
                        String tuple = sc.nextLine();
                        queries.Problem.insertProblems(conn, tuple);
                        sc.close();
                        break;
                    case "-del":
                        queries.Problem.deleteProblems(conn, args[2]);
                        break;
                    case "-upd":
                        switch (args[2]) {
                            case "-ratById":
                                queries.Problem.updateRating(conn, args[3], args[4]);
                                break;
                            case "-ratByConId":
                                queries.Problem.updateRatingByContest(conn, args[3], args[4]);
                                break;
                        }
                        break;
                    case "-s":
                        switch (args[2]) {
                            case "-byId":
                                queries.Problem.searchById(conn, args[3]);
                                break;
                            case "-byConId":
                                queries.Problem.searchByContest(conn, args[3]);
                                break;
                            case "-byRat":
                                switch (args[3]) {
                                    case "-gt":
                                        queries.Problem.searchByRating(conn, args[4], ">");
                                        break;
                                    case "-lt":
                                        queries.Problem.searchByRating(conn, args[4], "<");
                                        break;
                                    case "-lte":
                                        queries.Problem.searchByRating(conn, args[4], "<=");
                                        break;
                                    case "-gte":
                                        queries.Problem.searchByRating(conn, args[4], ">=");
                                        break;
                                    case "-eq":
                                        queries.Problem.searchByRating(conn, args[4], "=");
                                        break;
                                }
                                break;
                            case "-byAut":
                                System.out.println("Write the author you want to search");
                                Scanner sc6 = new Scanner(System.in);
                                String author = sc6.nextLine();
                                queries.Problem.searchByAuthor(conn, author);
                                sc6.close();
                                break;
                        }
                        break;
                    case "-sort":
                        switch (args[2]) {
                            case "-byConId":
                                queries.Problem.sortProblems(conn, "ContestId");
                                break;
                            case "-byRat":
                                queries.Problem.sortProblems(conn, "ProblemRating");
                                break;
                        }
                        break;
                }
                break;
            case "-user":
                switch (args[1]) {
                    case "-disp":
                        queries.User.displayAll(conn);
                        codeforces.disconnect(conn);
                        break;
                    case "-ins":
                        System.out.println("Write the tuple you want to insert");
                        Scanner sc = new Scanner(System.in);
                        String tuple = sc.nextLine();
                        queries.User.insertUsers(conn, tuple);
                        sc.close();
                        break;
                    case "-del":
                        queries.User.deleteUsers(conn, args[2]);
                        break;
                    case "-upd":
                        switch (args[2]) {
                            case "-ratById":
                                queries.User.updateRating(conn, args[3], args[4]);
                                break;
                            case "-maxratById":
                                queries.User.updateMaxRating(conn, args[3], args[4]);
                                break;
                            case "-orgById":
                                queries.User.updateOrganisation(conn, args[3], args[4]);
                                break;
                            case "-cityById":
                                queries.User.updateCity(conn, args[3], args[4]);
                                break;
                            case "-couById":
                                queries.User.updateCountry(conn, args[3], args[4]);
                                break;
                            case "-contriById":
                                queries.User.updateContribution(conn, args[3], args[4]);
                                break;
                        }
                        break;
                    case "-s":
                        switch (args[2]) {
                            case "-byId":
                                queries.User.searchById(conn, args[3]);
                                break;
                            case "-byRat":
                                switch (args[3]) {
                                    case "-gt":
                                        queries.User.searchByRating(conn, args[4], ">");
                                        break;
                                    case "-lt":
                                        queries.User.searchByRating(conn, args[4], "<");
                                        break;
                                    case "-lte":
                                        queries.User.searchByRating(conn, args[4], "<=");
                                        break;
                                    case "-gte":
                                        queries.User.searchByRating(conn, args[4], ">=");
                                        break;
                                    case "eq":
                                        queries.User.searchByRating(conn, args[4], "=");
                                        break;
                                }
                                break;
                            case "byMaxRat":
                                switch (args[3]) {
                                    case "-gt":
                                        queries.User.searchByMaxRating(conn, args[4], ">");
                                        break;
                                    case "-lt":
                                        queries.User.searchByMaxRating(conn, args[4], "<");
                                        break;
                                    case "-lte":
                                        queries.User.searchByMaxRating(conn, args[4], "<=");
                                        break;
                                    case "-gte":
                                        queries.User.searchByMaxRating(conn, args[4], ">=");
                                        break;
                                    case "eq":
                                        queries.User.searchByMaxRating(conn, args[4], "=");
                                        break;
                                }
                                break;
                            case "-byUser":
                                queries.User.searchByUsername(conn, args[3]);
                                break;
                            case "-byOrg":
                                queries.User.searchByOrganisation(conn, args[3]);
                                break;
                            case "-byCity":
                                queries.User.searchByCity(conn, args[3]);
                                break;
                            case "-byCountry":
                                queries.User.searchByCountry(conn, args[3]);
                                break;
                            case "-byContri":
                                switch (args[3]) {
                                    case "-gt":
                                        queries.User.searchByContribution(conn, args[4], ">");
                                        break;
                                    case "-lt":
                                        queries.User.searchByContribution(conn, args[4], "<");
                                        break;
                                    case "-lte":
                                        queries.User.searchByContribution(conn, args[4], "<=");
                                        break;
                                    case "-gte":
                                        queries.User.searchByContribution(conn, args[4], ">=");
                                        break;
                                    case "eq":
                                        queries.User.searchByContribution(conn, args[4], "=");
                                        break;
                                }
                                break;
                        }
                        break;
                    case "-sort":
                        switch (args[2]) {
                            case "-byId":
                                queries.User.sortUsers(conn, "UserId");
                                break;
                            case "-byRat":
                                queries.User.sortUsers(conn, "Rating");
                                break;
                            case "-byMaxRat":
                                queries.User.sortUsers(conn, "MaxRating");
                                break;
                            case "-byContri":
                                queries.User.sortUsers(conn, "Contribution");
                                break;
                        }
                        break;
                    }
                break;
            case "-sub":
                switch (args[1]) {
                    case "-disp":
                        queries.Submission.displayAll(conn);
                        codeforces.disconnect(conn);
                        break;
                    case "-ins":
                        System.out.println("Write the tuple you want to insert");
                        Scanner sc = new Scanner(System.in);
                        String tuple = sc.nextLine();
                        queries.Submission.insertSubmissions(conn, tuple);
                        sc.close();
                        break;
                    case "-del":
                        switch(args[2]) {
                            case "-bysub":
                                queries.Submission.deleteSubBySub(conn, args[3]);
                                break;
                            case "-byCon":
                                queries.Submission.deleteSubByCon(conn, args[3]);
                                break;
                            case "-byProb":
                                queries.Submission.deleteSubByProb(conn, args[3]);
                                break;
                        }
                        break;
                    case "-upd":
                        switch (args[2]) {
                            case "-bySub":
                                queries.Submission.updateVerdictBySub(conn, args[3], args[4]);
                                break;
                            case "-byProb":
                                queries.Submission.updateVerdictByProb(conn, args[3], args[4]);
                                break;
                        }
                        break;

                    case "-s":
                        switch (args[2]) {
                            case "-bySub":
                                queries.Submission.searchBySubId(conn, args[3]);
                                break;
                            case "-byCon":
                                queries.Submission.searchByConId(conn, args[3]);
                                break;
                            case "-byProb":
                                queries.Submission.searchByProbId(conn, args[3]);
                                break;
                        }
                        break;
                }
                break;
        }
    }
}
