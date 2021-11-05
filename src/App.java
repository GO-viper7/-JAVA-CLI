import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import database.*;

public class App {

    public static void main(String[] args) {
        
        sqlconnectivity account = new sqlconnectivity();
        try {
            account.connectSql();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the command");
    //     String command = sc.nextLine();
    //     String[] commandArray = command.split(" ");
    //     if (commandArray[0].equals("-create")) {
    //         if (commandArray.length == 1) {
    //             System.out.println("Please enter the file name");
    //             String fileName = sc.nextLine();
    //             create(fileName);
    //         } else {
    //             create(commandArray[1]);
    //         }
    //     } else if (commandArray[0].equals("-read")) {
    //         if (commandArray.length == 1) {
    //             System.out.println("Please enter the file name");
    //             String fileName = sc.nextLine();
    //             read(fileName);
    //         } else {
    //             read(commandArray[1]);
    //         }
    //     } else if (commandArray[0].equals("-update")) {
    //         if (commandArray.length == 1) {
    //             System.out.println("Please enter the file name");
    //             String fileName = sc.nextLine();
    //             update(fileName);
    //         } else {
    //             update(commandArray[1]);
    //         }
    //     } else if (commandArray[0].equals("-delete")) {
    //         if (commandArray.length == 1) {
    //             System.out.println("Please enter the file name");
    //             String fileName = sc.nextLine();
    //             delete(fileName);
    //         } else {
    //             delete(commandArray[1]);
    //         }
    //     } else if (commandArray[0].equals("-search")) {
    //         if (commandArray.length == 1) {
    //             System.out.println("Please enter the file name");
    //             String fileName = sc.nextLine();
    //             search(fileName);
    //         } else {
    //             search(commandArray[1]);
    //         }
    //     } else if (commandArray[0].equals("-aggregate")) {
    //         if (commandArray.length == 1) {
    //             System.out.println("Please enter the file name");
    //             String fileName = sc.nextLine();
    //             aggregate(fileName);
    //         } else {
    //             aggregate(commandArray[1]);
    //         }
    //     } else {
    //         System.out.println("Invalid command");
    //     }
    // }

    // public static void create(String fileName) {
    //     try {
    //         File file = new File(fileName);
    //         if (file.exists()) {
    //             System.out.println("File already exists");
    //         } else {
    //             file.createNewFile();
    //             System.out.println("File created");
    //         }
    //     } catch (IOException ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }

    // public static void read(String fileName) {
    //     try {
    //         File file = new File(fileName);
    //         if (file.exists()) {
    //             FileReader fr = new FileReader(file);
    //             int c;
    //             while ((c = fr.read()) != -1) {
    //                 System.out.print((char) c);
    //             }
    //             fr.close();
    //         } else {
    //             System.out.println("File does not exist");
    //         }
    //     } catch (FileNotFoundException ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (IOException ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }

    // public static void update(String fileName) {
    //     try {
    //         File file = new File(fileName);
    //         if (file.exists()) {
    //             Scanner sc = new Scanner(System.in);
    //             System.out.println("Enter the id");
    //             int id = sc.nextInt();
    //             System.out.println("Enter the firstname");
    //             String firstname = sc.next();
    //             System.out.println("Enter the lastname");
    //             String lastname = sc.next();
    //             System.out.println("Enter the email");
    //             String email = sc.next();
    //             System.out.println("Enter the phone");
    //             String phone = sc.next();
    //             System.out.println("Enter the address");
    //             String address = sc.next();
    //             System.out.println("Enter the city");
    //             String city = sc.next();
    //             System.out.println("Enter the state");
    //             String state = sc.next();
    //             System.out.println("Enter the zip");
    //             String zip = sc.next();
    //             System.out.println("Enter the country");
    //             String country = sc.next();
    //             System.out.println("Enter the gender");
    //             String gender = sc.next();
    //             System.out.println("Enter the date");
    //             String date = sc.next();
    //             System.out.println("Enter the time");
    //             String time = sc.next();
    //             System.out.println("Enter the course");
    //             String course = sc.next();
    //             System.out.println("Enter the grade");
    //             String grade = sc.next();
    //             System.out.println("Enter the status");
    //             String status = sc.next();
    //             System.out.println("Enter the comment");
    //             String comment = sc.next();
    //             System.out.println("Enter the file name");
    //             String fileNames = sc.next();
    //             file.delete();
    //             file.createNewFile();
    //             FileWriter fw = new FileWriter(file);
    //             fw.write(id + "," + firstname + "," + lastname + "," + email + "," + phone + "," + address + "," + city + "," + state + "," + zip + "," + country + "," + gender + "," + date + "," + time + "," + course + "," + grade + "," + status + "," + comment);
    //             fw.close();
    //             System.out.println("File updated");
    //         } else {
    //             System.out.println("File does not exist");
    //         }
    //     } catch (IOException ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }

    // public static void delete(String fileName) {
    //     try {
    //         File file = new File(fileName);
    //         if (file.exists()) {
    //             Scanner sc = new Scanner(System.in);
    //             System.out.println("Enter the id");
    //             int id = sc.nextInt();
    //             file.delete();
    //             System.out.println("File deleted");
    //         } else {
    //             System.out.println("File does not exist");
    //         }
    //     } catch (Exception ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }

    // public static void search(String fileName) {
    //     try {
    //         File file = new File(fileName);
    //         if (file.exists()) {
    //             Scanner sc = new Scanner(file);
    //             ArrayList<String> list = new ArrayList<>();
    //             while (sc.hasNextLine()) {
    //                 list.add(sc.nextLine());
    //             }
    //             System.out.println("Enter the field");
    //             String field = sc.next();
    //             System.out.println("Enter the condition");
    //             String condition = sc.next();
    //             Pattern p = Pattern.compile(condition);
    //             Matcher m = p.matcher(field);
    //             if (m.find()) {
    //                 System.out.println("Found");
    //             } else {
    //                 System.out.println("Not found");
    //             }
    //         } else {
    //             System.out.println("File does not exist");
    //         }
    //     } catch (IOException ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }

    // public static void aggregate(String fileName) {
    //     try {
    //         File file = new File(fileName);
    //         if (file.exists()) {
    //             Scanner sc = new Scanner(file);
    //             ArrayList<String> list = new ArrayList<>();
    //             while (sc.hasNextLine()) {
    //                 list.add(sc.nextLine());
    //             }
    //             System.out.println("Enter the field");
    //             String field = sc.next();
    //             System.out.println("Enter the condition");
    //             String condition = sc.next();
    //             Pattern p = Pattern.compile(condition);
    //             Matcher m = p.matcher(field);
    //             if (m.find()) {
    //                 System.out.println("Found");
    //             } else {
    //                 System.out.println("Not found");
    //             }
    //         } else {
    //             System.out.println("File does not exist");
    //         }
    //     } catch (IOException ex) {
    //         Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    }
}
