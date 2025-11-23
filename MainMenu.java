// Austin
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Menu - Entry point after Start
 * Options: Register, Login, Exit
 */
public class MainMenu{
    private final UserManager userManager = new UserManager(new ArrayList<>());
    private final Scanner scanner = new Scanner(System.in);
    
    public void display() {
        boolean running = true;
        
        while (running) {
             System.out.println();
            System.out.println("+------------------------------------------------+");
            System.out.println("|              NEIGHBORCONNECT v1.0              |");
            System.out.println("+------------------------------------------------+");
            System.out.println("|  1) Register                                   |");
            System.out.println("|  2) Login                                      |");
            System.out.println("|  3) Exit                                       |");
            System.out.println("+------------------------------------------------+");
            System.out.print("Select an option (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch(choice){
                case 1:
                    User newUser = Authentication.registerUser();
                    if (newUser != null){
                        userManager.addUser(newUser);
                    }
                    break;
                case 2:
                    User loggedUser = Authentication.loginUser(userManager.getUsers());
                    if (loggedUser != null){
                        LoginMenu loginMenu = new LoginMenu(loggedUser);
                        loginMenu.display();
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using NeighborConnect. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}