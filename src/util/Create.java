package util;
import java.io.File;
import java.io.IOException;

public class Create {
    public static void createFile(String fileName) {
            try {
                File file = new File(fileName);
                if (file.exists()) {
                    System.out.println("File already exists");
                } else {
                    file.createNewFile();
                    System.out.println("File created");
                }
            } catch (IOException ex) {
                System.out.println("Error creating file");
            }
        }
}
