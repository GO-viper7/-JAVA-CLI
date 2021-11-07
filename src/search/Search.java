package search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    public static void searchFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                ArrayList<String> list = new ArrayList<>();
                while (sc.hasNextLine()) {
                    list.add(sc.nextLine());
                }
                System.out.println("Enter the field");
                String field = sc.next();
                System.out.println("Enter the condition");
                String condition = sc.next();
                Pattern p = Pattern.compile(condition);
                Matcher m = p.matcher(field);
                if (m.find()) {
                    System.out.println("Found");
                } else {
                    System.out.println("Not found");
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
