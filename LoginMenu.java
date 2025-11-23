// Subash
import java.util.Scanner;
import java.util.List;

/**
 * Login Menu - Menu displayed after successful login
 * Options: View Businesses in Location, Search Business by Type, Saved Businesses, Logout
 */
public class LoginMenu {
    private User currentUser;
    private Scanner sc = new Scanner(System.in);
    
    public LoginMenu(User user) {
        this.currentUser = user;
    }
    
    public void display() {
        boolean run = true;
        System.out.println("\n======= Welcome to NeighborConnect! =======");
        System.out.println("-------Support local. Connect local.-------\n");
        
        while(run) {
            System.out.println("How would you like to get started?");
            System.out.println("1. View Businesses in Location");
            System.out.println("2. Search Businesses by Type");
            System.out.println("3. Display Saved Businesses");
            System.out.println("4. Logout");
            System.out.print("Please choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    BusinessManager.viewBusinessesInLocation(currentUser);
                    break;
                case 2:
                    BusinessManager.searchBusinessByType(currentUser);
                    break;
                case 3:
                    displaySavedBusinesses();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose an option.");
            }
        }
    }
    
    private void displaySavedBusinesses() {
        List<Business> saved = currentUser.getSavedBusinesses();
        if (saved.isEmpty()) {
            System.out.println("\nYou have no saved businesses yet.");
        } else {
            System.out.println("\n=== YOUR SAVED BUSINESSES ===");
            for (Business business : saved) {
                BusinessManager.displayBusinessInfo(business);
                System.out.println("---");
            }
        }
    }
}