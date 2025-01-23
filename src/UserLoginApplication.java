public class UserLoginApplication {

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.getUsersFromFile("data.txt");

        int userAttempts = 5;

        while(userAttempts > 0) {
            String username = userService.askForUsername();
            String password = userService.askForPassword();

            if (userService.validateUsername(username) && userService.validatePassword(password)) {
                String usersName = userService.getUsersName(username);
                System.out.println("Welcome: " + usersName);
                return;
            } else {
                System.out.println("Invalid login, please try again.");
                userAttempts--;
            }
        }

        System.out.println("Too many failed login attempts, you are now locked out.");
    }
}