import java.util.Scanner;
import database.*;
import java.sql.*;
import queries.*;
import create.*;
import delete.*;
import update.*;
import read.*;
import search.*;


public class App {

    public static void main(String[] args) {
        Connection conn = null;
        sqlconnectivity codeforces = new sqlconnectivity();
        try {
            conn = codeforces.connectSql();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Problem prob = new Problem();
        prob.createProblems(conn);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the command");
        String command = sc.nextLine();
        String[] commandArray = command.split(" ");
        switch(commandArray[0]){
            case "-create" : {
                if (commandArray.length == 1) {
                   System.out.println("Please enter the file name");
                   String fileName = sc.nextLine();
                   Create.createFile(fileName);
                } 
                else {
                   Create.createFile(commandArray[1]);
                }   
                break;
            }
            // case "-read" : {
            //     if (commandArray.length == 1) {
            //        System.out.println("Please enter the file name"); 
            //        String fileName = sc.nextLine();
            //        Read.readFile(fileName);
            //     }
            //     else {
            //       Read.readFile(commandArray[1]);
            //     }
            //     break;
            // }
            case "-insert" : {
                System.out.println("Names of the Tables : ");

                System.out.println("Give name of the Problem table csv file:");
                    System.out.println("Please enter the file name");
                    String fileProblem = sc.nextLine();
                    Read.readFile(fileProblem);
                
                System.out.println("Give name of the User table csv file:");
                    System.out.println("Please enter the file name");
                    String fileUser = sc.nextLine();
                    Read.readFile(fileUser);
                
                System.out.println("Give name of the Blog table csv file:");
                    System.out.println("Please enter the file name");
                    String fileBlog = sc.nextLine();
                    Read.readFile(fileBlog);
                
                System.out.println("Give name of the Contest table csv file:");
                    System.out.println("Please enter the file name");
                    String fileContest = sc.nextLine();
                    Read.readFile(fileContest);
                
                System.out.println("Give name of the Submission table csv file:");
                    System.out.println("Please enter the file name");
                    String fileSubmission = sc.nextLine();
                    Read.readFile(fileSubmission);
                
                break;
            }
            case "-update" : {
                if (commandArray.length == 1) {
                   System.out.println("Please enter the file name");
                   String fileUpdate = sc.nextLine();
                   Update.updateFile(fileUpdate);
                }
                else{
                  Update.updateFile(commandArray[1]);
                }    
                break; 
            }
            
            case "-delete" : {
                if (commandArray.length == 1) {
                   System.out.println("Please enter the file name");
                   String fileName = sc.nextLine();
                   Delete.deleteFile(fileName);
                } 
                else {
                  Delete.deleteFile(commandArray[1]);
               }
                break; 
            }
            case "-search" : {
                System.out.println("Enter 1 to search in Problem table");
                System.out.println("Enter 2 to search in User table");
                System.out.println("Enter 3 to search in Blog table");
                System.out.println("Enter 4 to search in Contest table");
                System.out.println("Enter 5 to search in Submission table");
                String n =sc.nextLine();
                switch (n) {
                  case "1" : {
                    Read.readFile(Problem.csv);
                    Search.searchFile(Problem.csv);
                    break;
                  }
                  case "2" : {
                    Read.readFile(User.csv);
                    Search.searchFile(User.csv);
                    break;
                  }
                  case "3" : {
                    Read.readFile(Blog.csv);
                    Search.searchFile(Blog.csv);
                    break;
                  }
                  case "4" : {
                    Read.readFile(Contests.csv);
                    Search.searchFile(Contests.csv);
                    break;
                  }
                  case "5" : {
                    Read.readFile(Submission.csv);
                    Search.searchFile(Submission.csv);
                    break;
                  }
                }
            } 
            
        }
    }
}
