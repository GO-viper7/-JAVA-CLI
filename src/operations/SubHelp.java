package operations;
import java.io.IOException;
import java.util.Scanner;


public class SubHelp extends Help {

    @Override
    public void printHelpMenu() {

        try {
            super.printHelpMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printUserHelp() {
        String[] user = { "-user -disp", "-user -ins <UserID> <Username> <Rating> <MaxRating>", "      <Organisation> <City> <Country> <Contribution>",
                "-user -del <UserID>", "-user -upd -ratById <UserID> <Rating>",
                "-user -upd -maxratById <UserID> <MaxRating>", "-user -upd -orgById <UserID> <Name of Organisation>",
                "-user -upd -cityById <UserID> <Name of City>", "-user -upd -couById <UserID> <Country>",
                "-user -upd -contriById <UserID> <Contribution>", "-user -s -byId <UserID>",
                "-user -s -byRat -gt <Rating>", "-user -s -byRat -lt <Rating>", "-user -s -byRat -gte <Rating>",
                "-user -s -byRat -lte <Rating>", "-user -s -byRat -eq <Rating>",
                "-user -s -byMaxRat -gt <MaxRating>", "-user -s -byMaxRat -lt <MaxRating>",
                "-user -s -byMaxRat -gte <MaxRating>", "-user -s -byMaxRat -lte <MaxRating>",
                "-user -s -byMaxRat -eq <MaxRating>",
                "-user -s -byUser <UserName>", "-user -s -byOrg <OrganisationName>", "-user -s -byCity <CityName>",
                "-user -s -byCou <CountryName>", "-user -s -byContri -gt <Contribution>",
                "-user -s -byContri -lt <Contribution>", "-user -s -byContri -gte <Contribution>",
                "-user -s -byContri -lte <Contribution>", "-user -s -byContri -eq <Contribution>", "-user -sort -byId",
                "-user -sort -byRat", "-user -sort -byMaxRat", "-user -sort -byContri" };
        String[] des2 = { "Displays Users Table", "Insert Data into Users Table resepctively"," ",
                "Delete Data from Users Table for respective UserID", "Update Rating by providing UserID",
                "Update MaxRating by providing UserID",
                "Update Name of Organisation by providing UserID", "Update Name of City by providing UserID",
                "Update Name of Country by providing UserID", "Update Name of Contribution by providing UserID",
                "Search Details of user by providing UserID",
                "Search Details of user who has Rating greater than the provided Rating",
                "Search Details of user who has Rating less than the provided Rating",
                "Search Details of user who has Rating greater than or equals to the provided Rating",
                "Search Details of user who has Rating lesser than or equals to the provided Rating",
                "Search Details of user who has Rating equal to the provided Rating",
                "Search Details of user who has MaxRating greater than the provided MaxRating",
                "Search Details of user who has MaxRating lesser than the provided MaxRating",
                "Search Details of user who has MaxRating greater than or equals to the provided MaxRating",
                "Search Details of user who has MaxRating lesser than or equals to the provided MaxRating",
                "Search Details of user who has MaxRating equal to the provided MaxRating",
                "Search Details of user who has the respective Username",
                "Search Details of user who is in the respective Organisation",
                "Search Details of user who is in the respective City",
                "Search Details of user who is in the respective Country",
                "Search Details of user who has the Contribution greater than the provided Contribution",
                "Search Details of user who has the Contribution lesser than the provided Contribution",
                "Search Details of user who has the Contribution greater than or equal to the provided Contribution",
                "Search Details of user who has the Contribution lesser than or equal to the provided Contribution",
                "Search Details of user who has the Contribution equal to the provided Contribution",
                "Sort the Users by providing UserID", "Sort the Users by providing Rating",
                "Sort the Users by providing MaxRating", "Sort the Users by providing Contribution" };
        System.out.println(
                "+------------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        System.out.println(
                "|Commands related to Users Of Codeforces                     |Description                                                                                         |");
        System.out.println(
                "+------------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < user.length; i++) {
            System.out.printf("|%-60s|%-100s|\n", user[i], des2[i]);
        }
        System.out.println(
                "+------------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
    }

    public void printContestHelp() {
        String[] contest = { "-con -disp", "-con -ins <ContestID> <Author> <Division>","      <StartTime> <EndTime>", "-con -del <ContestID>", "-con -upd -aut <ContestID> <Author>",
                "-con -upd -div <ContestID> <Division>", "-con -upd -stime <ContestID> <StartTime>",
                "-con -upd -etime <ContestID> <EndTime>", "-con -s -byId <ContestID>","-con -s -byAut <Author>","-con -s -byDiv -gt <Division>",
                "-con -s -byDiv -lt <Division>", "-con -s -byDiv -gte <Division>", "-con -s -byDiv -lte <Division>",
                "-con -s -byDiv -eq <Division>",
                "-con -s -byStime <StartTime>", "-con -s -byEtime <EndTime>" };
        String[] des4 = { "Displays Contests Table", "Insert Data into Contests Table resepctively"," ",
                "Delete Data from Contests Table for respective ContestID", "Update AuthorName by providing ContestID",
                "Update Division by providing ContestID", "Update StartTime of Contest by providing ContestID",
                "Update EndTime of Contest by providing ContestID",
                "Search Details of contest by providing ContestID",
                "Search Details of contest by providing Name of Author",
                "Search Details of contest which has Division greater than the provided Division",
                "Search Details of contest which has Division lesser than the provided Division",
                "Search Details of contest which has Division greater than or equals to the provided Division",
                "Search Details of contest which has Division lesser than or equals to the provided Division",
                "Search Details of contest which has Division equals to the provided Division",
                "Search Details of contest by providing Start Time of Contest",
                "Search Details of contest by providing End Time of Contest" };
        System.out.println(
                "+------------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        System.out.println(
                "|Commands related to Contests Of Codeforces                  |Description                                                                                         |");
        System.out.println(
                "+------------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < contest.length; i++) {
            System.out.printf("|%-60s|%-100s|\n", contest[i], des4[i]);
        }
        System.out.println(
                "+------------------------------------------------------------+----------------------------------------------------------------------------------------------------+");
    }
    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public void paginate() {
        Help temp = new Help();
        SubHelp tempSub = new SubHelp();
        temp.printHelpMenu();
        int currentPage = 0;
        System.out.println("Page 1 of 5");
        System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int k;
            int choice = Integer.valueOf(scanner.nextLine());
            if (choice != 1 && choice != 2)
                break;
            else {
                if (choice == 1 && currentPage > 0)
                    currentPage--;
                else if (choice == 2 && currentPage < 4)
                    currentPage++;
            }
            clrscr();
            switch (currentPage) {
                case 0:
                    temp.printHelpMenu();
                    k=currentPage+1;
                    System.out.println("Page "+k+" of 5");
                    break;
                case 1:
                    temp.printProblemHelp();
                    k=currentPage+1;
                    System.out.println("Page "+k+" of 5");
                    break;
                case 2:
                    temp.printSubmissionHelp();
                    k=currentPage+1;
                    System.out.println("Page "+k+" of 5");
                    break;
                case 3:
                    tempSub.printContestHelp();
                    k=currentPage+1;
                    System.out.println("Page "+k+" of 5");
                    break;
                case 4:
                    tempSub.printUserHelp();
                    k=currentPage+1;
                    System.out.println("Page "+k+" of 5");
                    break;
            }
            System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        }
        scanner.close();
    }
}