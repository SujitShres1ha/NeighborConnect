// Subash
import java.util.Scanner;
/**
 * Login Menu - Menu displayed after successful login
 * Options: View Businesses in Location, Search Business by Type, Saved Businesses, Logout
 */
public class LoginMenu {
    private User currentUser;
    
    public LoginMenu(User user) {
        this.currentUser = user;
    }
    
    public void display() {
        // TODO: Display menu options
        // 1. View Businesses in Location
        // 2. Search Business by Type
        // 3. Saved Businesses
        // 4. Logout
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        System.out.println("======= Welcome to NeighborConnect! ======= \n");
        System.out.println("-------Support local. Connect local.-------");
        System.out.println("How would you like to get started?");
        while(run) {
            System.out.println("1. View Businesses in Location");
            System.out.println("2. Search Businesses by Type");
            System.out.println("3. Display Saved Businesses!");
            System.out.println("4. Logout");
            System.out.println("Please choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    BusinessManager.viewBusinessesInLocation();
                    break;
                case 2:
                    BusinessManager.searchBusinessByType();
                    break;
                case 3:
                    currentUser.getSavedBusinesses();
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose an option.");
            }
        }
    }
    
    // TODO: Add methods to handle menu selections
}