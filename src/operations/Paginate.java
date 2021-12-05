package operations;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Paginate {
    public void paginate(ResultSet rs){
        ArrayList<String> resultRows = getRows(rs);
        int maxPages = (resultRows.size() + 9)/10;
        int currentPage = 1;
        Scanner scanner = new Scanner(System.in);
        int endPage = 9;
        if(resultRows.size() < 10)endPage = resultRows.size() - 1;
        printPartialTable(resultRows, 0, endPage);
        System.out.println("Page 1 of " + String.valueOf(maxPages));
        System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        while(true){
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                break;
            }
            if (choice != 1 && choice != 2)
                break;
            else {
                if (choice == 1 && currentPage > 1)
                    currentPage--;
                else if (choice == 2 && currentPage < maxPages)
                    currentPage++;
            }
            clrscr();
            int startPage = (currentPage - 1)*10;
            endPage = resultRows.size() - 1;
            if(startPage + 9 < endPage)endPage = startPage + 9;
            printPartialTable(resultRows, startPage,  endPage);
            System.out.println("Page " + String.valueOf(currentPage) + " of " + String.valueOf(maxPages));
            System.out.println("Enter 1 to go to previous page, 2 to go to next page, any other key to exit.");
        }
        scanner.close();
    }
    public static void clrscr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    abstract public ArrayList<String> getRows(ResultSet rs);
    abstract public void printPartialTable(ArrayList<String> rs, int startRow, int endRow);
}
