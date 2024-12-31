import java.io.IOException;
import java.nio.file.*;

public class FileCopy {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("text1.txt");
        Path destPath = Paths.get("text2.txt");
        
        try 
        {
            Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File is copied successful!");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}