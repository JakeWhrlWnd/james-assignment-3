import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.loadUsers("data.txt");
        try (Scanner scanner = new Scanner(System.in)) {
            int userAttempts = 0;
            final int MAX_USER_ATTEMPTS = 5;
            while (userAttempts++ < MAX_USER_ATTEMPTS) {
                System.out.println("Enter your email:");
                String username = scanner.nextLine().trim();
                System.out.println("Enter your password:");
                String password = scanner.nextLine().trim();

                User loggedUser = userService.validateUserLogin(username, password);

                if (loggedUser != null) {
                    System.out.println("Welcome: " + loggedUser.getUsername());
                    return;
                } else {
                    System.out.println("Invalid login, please try again.");
                }
            }
            System.out.println("Too many failed login attempts, you are now locked out.");
        }
    }
}