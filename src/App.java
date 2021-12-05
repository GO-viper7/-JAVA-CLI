import database.*;
import java.sql.*;
import queries.*;
import operations.SubHelp;

public class App {
    private static Connection conn = null;

    public static void createTables() {
        try {
            Statement stmt2 = conn.createStatement();
            String dropProblem = "drop table if exists Problem";
            String dropUsers = "drop table if exists User";
            String dropContest = "drop table if exists Contest";
            String dropSubmission = "drop table if exists Submission";
            String table1 = "CREATE TABLE Problem (ProblemID varchar(50),Author varchar(255),ProblemRating int,ContestID int, primary key(problemId));";
            String table2 = "CREATE TABLE User (UserID varchar(50),Username varchar(255),Rating int,MaxRating int,Organisation varchar(255),City varchar(255),Country varchar(255),Contribution int,primary key(userID));";
            String table3 = "CREATE TABLE Contest (ContestID int,Author varchar(100),Division int,StartTime varchar(100),EndTime varchar(100),primary key(contestId));";
            String table4 = "CREATE TABLE Submission (SubmissionID int,ContestID int,ProblemID varchar(50),UserName varchar(255),Verdict varchar(50),primary key(submissionId));";
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
                SubHelp p = new SubHelp();
                p.paginate();
                break;
            case "-cd":
                createTables();
                codeforces.disconnect(conn);
                break;
            case "-ld":
                Data.loadProblemsData(conn);
                Data.loadUsersData(conn);
                Data.loadSubmissionsData(conn);
                Data.loadContestsData(conn);
                codeforces.disconnect(conn);
                break;
            case "-dispall":
                operations.Display.displayAll(conn);
                break;
            case "-prob":
                switch (args[1]) {
                    case "-disp":
                        if (args.length > 2) {
                            Problem.displayAll(conn, true);
                        }
                        Problem.displayAll(conn, false);
                        codeforces.disconnect(conn);
                        break;
                    case "-ins":
                        String tuple = args[2] + " " + args[3] + " " + args[4] + " " + args[5];
                        queries.Problem.insertProblems(conn, tuple);
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
                                        if (args.length > 5) {
                                            queries.Problem.searchByRating(conn, args[4], ">", true);
                                        }
                                        queries.Problem.searchByRating(conn, args[4], ">", false);
                                        break;
                                    case "-lt":
                                        if (args.length > 5) {
                                            queries.Problem.searchByRating(conn, args[4], "<", true);
                                        }
                                        queries.Problem.searchByRating(conn, args[4], "<", false);
                                        break;
                                    case "-lte":
                                        if (args.length > 5) {
                                            queries.Problem.searchByRating(conn, args[4], "<=", true);
                                        }
                                        queries.Problem.searchByRating(conn, args[4], "<=", false);
                                        break;
                                    case "-gte":
                                        if (args.length > 5) {
                                            queries.Problem.searchByRating(conn, args[4], ">=", true);
                                        }
                                        queries.Problem.searchByRating(conn, args[4], ">=", false);
                                        break;
                                    case "-eq":
                                        if (args.length > 5) {
                                            queries.Problem.searchByRating(conn, args[4], "=", true);
                                        }
                                        queries.Problem.searchByRating(conn, args[4], "=", false);
                                        break;
                                }
                                break;
                            case "-byAut":
                                queries.Problem.searchByAuthor(conn, args[3]);
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
                        if (args.length > 2) {
                            User.displayAll(conn, true);
                        }
                        queries.User.displayAll(conn, false);
                        codeforces.disconnect(conn);
                        break;
                    case "-ins":
                        String tuple = args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " "
                                + args[7] + " " + args[8] + " " + args[9];
                        queries.User.insertUsers(conn, tuple);
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
                                        if (args.length > 5) {
                                            queries.User.searchByRating(conn, args[4], ">", true);
                                        }
                                        queries.User.searchByRating(conn, args[4], ">", false);
                                        break;
                                    case "-lt":
                                        if (args.length > 5) {
                                            queries.User.searchByRating(conn, args[4], "<", true);
                                        }
                                        queries.User.searchByRating(conn, args[4], "<", false);
                                        break;
                                    case "-lte":
                                        if (args.length > 5) {
                                            queries.User.searchByRating(conn, args[4], "<=", true);
                                        }
                                        queries.User.searchByRating(conn, args[4], "<=", false);
                                        break;
                                    case "-gte":
                                        if (args.length > 5) {
                                            queries.User.searchByRating(conn, args[4], ">=", true);
                                        }
                                        queries.User.searchByRating(conn, args[4], ">=", false);
                                        break;
                                    case "eq":
                                        if (args.length > 5) {
                                            queries.User.searchByRating(conn, args[4], "=", true);
                                        }
                                        queries.User.searchByRating(conn, args[4], "=", false);
                                        break;
                                }
                                break;
                            case "byMaxRat":
                                switch (args[3]) {
                                    case "-gt":
                                        if (args.length > 5) {
                                            queries.User.searchByMaxRating(conn, args[4], ">", true);
                                        }
                                        queries.User.searchByMaxRating(conn, args[4], ">", false);
                                        break;
                                    case "-lt":
                                        if (args.length > 5) {
                                            queries.User.searchByMaxRating(conn, args[4], "<", true);
                                        }
                                        queries.User.searchByMaxRating(conn, args[4], "<", false);
                                        break;
                                    case "-lte":
                                        if (args.length > 5) {
                                            queries.User.searchByMaxRating(conn, args[4], "<=", true);
                                        }
                                        queries.User.searchByMaxRating(conn, args[4], "<=", false);
                                        break;
                                    case "-gte":
                                        if (args.length > 5) {
                                            queries.User.searchByMaxRating(conn, args[4], ">=", true);
                                        }
                                        queries.User.searchByMaxRating(conn, args[4], ">=", false);
                                        break;
                                    case "eq":
                                        if (args.length > 5) {
                                            queries.User.searchByMaxRating(conn, args[4], "=", true);
                                        }
                                        queries.User.searchByMaxRating(conn, args[4], "=", false);
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
                                        if (args.length > 5) {
                                            queries.User.searchByContribution(conn, args[4], ">", true);
                                        }
                                        queries.User.searchByContribution(conn, args[4], ">", false);
                                        break;
                                    case "-lt":
                                        if (args.length > 5) {
                                            queries.User.searchByContribution(conn, args[4], "<", true);
                                        }
                                        queries.User.searchByContribution(conn, args[4], "<", false);
                                        break;
                                    case "-lte":
                                        if (args.length > 5) {
                                            queries.User.searchByContribution(conn, args[4], "<=", true);
                                        }
                                        queries.User.searchByContribution(conn, args[4], "<=", false);
                                        break;
                                    case "-gte":
                                        if (args.length > 5) {
                                            queries.User.searchByContribution(conn, args[4], ">=", true);
                                        }
                                        queries.User.searchByContribution(conn, args[4], ">=", false);
                                        break;
                                    case "-eq":
                                        if (args.length > 5) {
                                            queries.User.searchByContribution(conn, args[4], "=", true);
                                        }
                                        queries.User.searchByContribution(conn, args[4], "=", false);
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
                        String tuple = args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6];
                        queries.Submission.insertSubmissions(conn, tuple);
                        break;
                    case "-del":
                        switch (args[2]) {
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
            case "-con":
                switch (args[1]) {
                    case "-disp":
                        queries.Contest.displayAll(conn);
                        codeforces.disconnect(conn);
                        break;
                    case "-ins":
                        String tuple = args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6];
                        queries.Contest.insertContest(conn, tuple);
                        break;
                    case "-del":
                        queries.Contest.deleteContests(conn, args[2]);
                        break;
                    case "-upd":
                        switch (args[2]) {
                            case "-aut":
                                queries.Contest.updateAuthor(conn, args[3], args[4]);
                                break;
                            case "-div":
                                queries.Contest.updateDivision(conn, args[3], args[4]);
                                break;
                            case "-stime":
                                queries.Contest.updateStartTime(conn, args[3], args[4]);
                                break;
                            case "-etime":
                                queries.Contest.updateEndTime(conn, args[3], args[4]);
                                break;
                        }
                        break;
                    case "-s":
                        switch (args[2]) {
                            case "-byId":
                                queries.Contest.searchByContestId(conn, args[3]);
                                break;
                            case "-byAut":
                                queries.Contest.searchByAuthor(conn, args[3]);
                            case "-byDiv":
                                switch (args[3]) {
                                    case "-gt":
                                        if (args.length > 5) {
                                            queries.Contest.searchByDivision(conn, args[4], ">", true);
                                        }
                                        queries.Contest.searchByDivision(conn, args[4], ">",false);
                                        break;
                                    case "-lt":
                                        if (args.length > 5) {
                                            queries.Contest.searchByDivision(conn, args[4], "<", true);
                                        }
                                        queries.Contest.searchByDivision(conn, args[4], "<",false);
                                        break;
                                    case "-lte":
                                        if (args.length > 5) {
                                            queries.Contest.searchByDivision(conn, args[4], "<=", true);
                                        }
                                        queries.Contest.searchByDivision(conn, args[4], "<=",false);
                                        break;
                                    case "-gte":
                                        if (args.length > 5) {
                                            queries.Contest.searchByDivision(conn, args[4], ">=", true);
                                        }
                                        queries.Contest.searchByDivision(conn, args[4], ">=",false);
                                        break;
                                    case "-eq":
                                        if (args.length > 5) {
                                            queries.Contest.searchByDivision(conn, args[4], "=", true);
                                        }
                                        queries.Contest.searchByDivision(conn, args[4], "=",false);
                                        break;
                                }
                                break;
                            case "-byStime":
                                queries.Contest.searchByStartTime(conn, args[3]);
                                break;
                            case "-byEtime":
                                queries.Contest.searchByEndTime(conn, args[3]);
                                break;
                        }
                        break;
                }
        }
    }
}
