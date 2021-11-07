package update;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Update {
    public static void updateFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the id");
                int id = sc.nextInt();
                System.out.println("Enter the firstname");
                String firstname = sc.next();
                System.out.println("Enter the lastname");
                String lastname = sc.next();
                System.out.println("Enter the email");
                String email = sc.next();
                System.out.println("Enter the phone");
                String phone = sc.next();
                System.out.println("Enter the address");
                String address = sc.next();
                System.out.println("Enter the city");
                String city = sc.next();
                System.out.println("Enter the state");
                String state = sc.next();
                System.out.println("Enter the zip");
                String zip = sc.next();
                System.out.println("Enter the country");
                String country = sc.next();
                System.out.println("Enter the gender");
                String gender = sc.next();
                System.out.println("Enter the date");
                String date = sc.next();
                System.out.println("Enter the time");
                String time = sc.next();
                System.out.println("Enter the course");
                String course = sc.next();
                System.out.println("Enter the grade");
                String grade = sc.next();
                System.out.println("Enter the status");
                String status = sc.next();
                System.out.println("Enter the comment");
                String comment = sc.next();
                System.out.println("Enter the file name");
                String fileNames = sc.next();
                file.delete();
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write(id + "," + firstname + "," + lastname + "," + email + "," + phone + "," + address + "," + city + "," + state + "," + zip + "," + country + "," + gender + "," + date + "," + time + "," + course + "," + grade + "," + status + "," + comment);
                fw.close();
                System.out.println("File updated");
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
