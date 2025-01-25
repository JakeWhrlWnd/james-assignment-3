import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

    public String[] readFile(String filepath) {
        String[] lines = new String[4];
        int index = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && index < lines.length) {
                lines[index++] = line;
            }
        } catch (IOException e) {
            System.out.println("Oops, there was an issue reading the file. Issue -> " + e.getMessage());
        }
        return lines;
    }
}
