package delete;

import java.io.File;
import java.util.*;
import java.util.logging.*;

public class Delete {
    public static void deleteFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the id");
                int id = sc.nextInt();
                file.delete();
                System.out.println("File deleted");
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
