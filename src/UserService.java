import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {
    public User[] users = new User[4];

    public void getUsersFromFile(String filePath) {
        int index = 0;

        try {
            BufferedReader userFileReader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = userFileReader.readLine()) != null && index < users.length) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String username = fields[0];
                    String password = fields[1];
                    String name = fields[2];

                    users[index] = new User(username, password, name);
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Oops, file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Oops, file could not be read.");
            e.printStackTrace();
        }

    }

    public boolean validateUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean validatePassword(String password) {
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String askForUsername() {
        System.out.println("Enter your email: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String askForPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        return scanner.nextLine();
    }

    public String getUsersName(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user.getName();
            }
        }
        return null;
    }
}

