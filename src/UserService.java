import java.util.Scanner;

public class UserService {
    public User[] users = new User[4];

    private final FileService fileService = new FileService();

    public void loadUsers(String filePath) {
        String[] lines = fileService.readFile(filePath);
        int index = 0;
        for (String line : lines) {
            if (line != null && index < users.length) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    users[index++] = new User(fields[0], fields[1], fields[2]);
                }
            }
        }
    }

    public User validateUserLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}

