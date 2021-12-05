package operations;

public class Help {
    public void printHelpMenu() {

        String[] com = { "-h", "-ld", "-dispall", "-cd" };
        String[] des = { "Display Help Menu", "Load all the Existing Data into Tables to perform operations",
                "Display all the tables in the Codeforces Database", "Clear Data from the Database", };
        System.out.println("+--------------------+------------------------------------------------------------+");
        System.out.println("|Basic Commands      |Description                                                 |");
        System.out.println("+--------------------+------------------------------------------------------------+");
        for (int i = 0; i < com.length; i++) {
            System.out.printf("|%-20s|%-60s|\n", com[i], des[i]);
        }
        System.out.println("+--------------------+------------------------------------------------------------+");
    }

    public void printProblemHelp() {
        String[] prob = { "-prob -disp", "-prob -ins <ProblemID> <Author> <ProblemRating> <ContestID>", "-prob -del <ProblemID>",
                "-prob -upd -ratById <ProblemID> <ProblemRating>", "-prob -upd -ratByConId <ContestID> <ProblemRating>",
                "-prob -s -byId <ProblemID>", "-prob -s -byConId <ContestID>", "-prob -s -byRat -gt <ProblemRating>",
                "-prob -s -byRat -lt <ProblemRating>",
                "-prob -s -byRat -gte <ProblemRating>", "-prob -s -byRat -lte <ProblemRating>",
                "-prob -s -byRat -eq <ProblemRating>", "-prob -s -byAut",
                "-prob -sort -byConId", "-prob -sort -byRat"};
        String[] des1 = { "Displays Problems Table", "Insert Data into Problems Table resepctively",
                "Delete Data from Problems Table using ProblemID",
                "Update ProblemRating for the corresponding ProblemID",
                "Update ProblemRating for the corresponding ContestID",
                "Search Problems by providing ProblemID", "Search Problems by providing ContestID",
                "Search Problems which are greater than the respective ProblemRating",
                "Search Problems which are less than the respective ProblemRating",
                "Search Problems which are greater than or equals to the respective ProblemRating",
                "Search Problems which are less than or equals to the respective ProblemRating",
                "Search Problems which are equals to the respective ProblemRating",
                "Search Problems by providing Name of the Author", "Sort Problems by providing ContestID",
                "Sort Problems by providing ProblemRating" };
        System.out.println(
                "+----------------------------------------------------------------------+--------------------------------------------------------------------------------+");
        System.out.println(
                "|Commands related to Problems Of Codeforces                            |Description                                                                     |");
        System.out.println(
                "+----------------------------------------------------------------------+--------------------------------------------------------------------------------+");
        for (int i = 0; i < prob.length; i++) {
            System.out.printf("|%-70s|%-80s|\n", prob[i], des1[i]);
        }
        System.out.println(
                "+----------------------------------------------------------------------+--------------------------------------------------------------------------------+");
    }

    public void printSubmissionHelp() {
        String[] submission = { "-sub -disp", "-sub -ins <SubmissionID> <ContestID> <ProblemID> <UserName> <Verdict>",
                "-sub -del -bySub <SubmissionID>",
                "-sub -del -byCon <ContestID>", "-sub -del -byProb <ProblemID>",
                "-sub -upd -bySub <SubmissionID> <verdict>",
                "-sub -upd -byProb <ProblemID> <verdict>", "-sub -s -bySub <SubmissionID>",
                "-sub -s -byCon <ContestID>", "-sub -s -byProb <ProblemID>" };
        String[] des3 = { "Displays Submissions Table", "Insert Data into Submissions Table resepctively",
                "Delete Data from Submissions Table for respective SubmissiosnID",
                "Delete Data from Submissions Table for respective ContestID",
                "Delete Data from Submissions Table for respective ProblemID",
                "Update Verdict of submission corresponding to provided SubmissionID",
                "Update Verdict of submission corresponding to provided ProblemID",
                "Search Submission Details for respective SubmissionID",
                "Search Submission Details for respective ContestID",
                "Search Submission Details for respective ProblemID" };
        System.out.println(
                "+----------------------------------------------------------------------+--------------------------------------------------------------------------------+");
        System.out.println(
                "|Commands related to Submissions Of Codeforces                         |Description                                                                     |");
        System.out.println(
                "+----------------------------------------------------------------------+--------------------------------------------------------------------------------+");
        for (int i = 0; i < submission.length; i++) {
            System.out.printf("|%-70s|%-80s|\n", submission[i], des3[i]);
        }
        System.out.println(
                "+----------------------------------------------------------------------+--------------------------------------------------------------------------------+");

    }
}



