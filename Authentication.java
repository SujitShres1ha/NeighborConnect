// Austin
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles user authentication - Register and Login
 */
public class Authentication{
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Register a new user
     */
    public static User registerUser() {
        System.out.println("\n=== REGISTER USER ===");
        System.out.print("Enter username: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter a password (at least 9 characters and/or digits): ");
        String password = scanner.nextLine();
        
        while (password.length() < 9){
            System.out.println("ERROR: Password needs to be at least 9 characters and/or digits");
            System.out.print("Please enter a different password: ");
            password = scanner.nextLine();
        }
        
        System.out.println("Your username and password are now registered!");
        return new User(name, password, new ArrayList<Business>());
    }
    
    /**
     * Login an existing user
     * @return User object if login successful, null otherwise
     */
    public static User loginUser(List<User> users) {
        System.out.println("\n=== LOGIN USER ===");
        System.out.print("Enter username: ");
        String tempname = scanner.nextLine();
        
        for (User u : users){
            if (u.getUsername().equals(tempname)){
                System.out.print("Enter your password: ");
                String tempPassword = scanner.nextLine();
                int attempts = 0;
                
                while(!u.validatePassword(tempPassword)){
                    attempts++;
                    if (attempts >= 2){
                        System.out.println("Two failed attempts. Login failed.");
                        return null;
                    }
                    System.out.println("Incorrect password. Try again.");
                    System.out.print("Enter your password: ");
                    tempPassword = scanner.nextLine();
                }
                System.out.println("Successful Login!");
                return u;
            }
        }
        System.out.println("User not found.");
        return null;
    }
}