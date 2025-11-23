// Sanjesh

import java.util.*;
import java.util.stream.Collectors;

/**
 * BusinessManager - handles business-related operations
 * Manages viewing, filtering, sorting, and searching businesses
 */
public class BusinessManager {

    private static List<Business> businesses;
    private static Scanner scanner = new Scanner(System.in);

    // Static initializer to create dummy businesses
    static {
        businesses = new ArrayList<>();
        
        // Add sample businesses
        Location loc1 = new Location("New York", "NY", "123 Main St");
        Location loc2 = new Location("Los Angeles", "CA", "456 Oak Ave");
        Location loc3 = new Location("New York", "NY", "789 Park Blvd");
        Location loc4 = new Location("Chicago", "IL", "321 Elm St");
        Location loc5 = new Location("Arlington", "TX", "1001 S Collins St");  
        Location loc6 = new Location("Arlington", "TX", "700 Ballpark Way");   
        Location loc7 = new Location("Arlington", "TX", "200 W Abram St");     
        Location loc8 = new Location("Arlington", "TX", "2900 E Arkansas Ln");
        
        businesses.add(new Business("Joe's Pizza", "Restaurant", loc1, 4.5, "Best pizza in town"));
        businesses.add(new Business("Tech Solutions", "Technology", loc1, 4.8, "IT services"));
        businesses.add(new Business("Sunset Cafe", "Restaurant", loc2, 4.2, "Cozy coffee shop"));
        businesses.add(new Business("Green Thumb", "Garden", loc3, 4.6, "Plant nursery"));
        businesses.add(new Business("Fit Zone", "Gym", loc4, 4.4, "24/7 fitness center"));
        businesses.add(new Business("Book Haven", "Bookstore", loc5, 4.7, "Independent bookstore"));
        businesses.add(new Business("Stadium Eats", "Restaurant", loc6, 4.5, "Fan-favorite game day food"));
        businesses.add(new Business("Globe Tech", "Technology", loc6, 4.7, "IT & networking solutions"));
        businesses.add(new Business("Downtown Coffee", "Cafe", loc7, 4.3, "Local roasters and pastries"));
        businesses.add(new Business("Arlington Nursery", "Garden", loc8, 4.6, "Plants, landscaping & supplies"));

    }

    /**
     * View businesses in a specific location
     */
    public static void viewBusinessesInLocation(User currentUser) {
        // 1. Select Location
        Location selectedLocation = selectLocation();
        if (selectedLocation == null) {
            System.out.println("Invalid location.");
            return;
        }

        // 2. Filter Businesses by Location
        List<Business> filtered = filterBusinessesByLocation(selectedLocation);

        if (filtered.isEmpty()) {
            System.out.println("No businesses found in this location.");
            return;
        }

        // 3. Sort Businesses by Ratings
        filtered = sortBusinessesByRatings(filtered);

        // 4. Display Business Info
        System.out.println("\n=== BUSINESSES IN " + selectedLocation.getCity() + ", " + selectedLocation.getState() + " ===");
        displayBusinesses(filtered);

        // 5. Save Business
        System.out.print("\nDo you want to save a business? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Enter business name to save: ");
            String name = scanner.nextLine().trim();

            Business found = filtered.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
                
            if (found != null) {
                currentUser.addToSavedBusinesses(found);
                System.out.println("Business '" + found.getName() + "' saved successfully!");
            } else {
                System.out.println("Business not found.");
            }
        }
    }

    /**
     * Search businesses by type
     */
    public static void searchBusinessByType(User currentUser) {
        // 1. Enter Business Type
        System.out.print("\nEnter business type: ");
        String type = scanner.nextLine().trim();

        // 2. Filter Businesses by Type
        List<Business> filtered = filterBusinessesByType(type);

        if (filtered.isEmpty()) {
            System.out.println("No businesses found for type: " + type);
            return;
        }

        // 3. Display Business Info
        System.out.println("\n=== BUSINESSES OF TYPE: " + type.toUpperCase() + " ===");
        displayBusinesses(filtered);
        
        // 4. Option to save
        System.out.print("\nDo you want to save a business? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Enter business name to save: ");
            String name = scanner.nextLine().trim();

            Business found = filtered.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
                
            if (found != null) {
                currentUser.addToSavedBusinesses(found);
                System.out.println("Business '" + found.getName() + "' saved successfully!");
            } else {
                System.out.println("Business not found.");
            }
        }
    }

    /**
     * Select a location (simple version)
     */
    public static Location selectLocation() {
        System.out.print("\nEnter city: ");
        String city = scanner.nextLine().trim();

        System.out.print("Enter state: ");
        String state = scanner.nextLine().trim();

        if (city.isEmpty() || state.isEmpty()) {
            return null;
        }

        return new Location(city, state, "");
    }

    /**
     * Filter businesses by location
     */
    public static List<Business> filterBusinessesByLocation(Location location) {
        if (businesses == null) return new ArrayList<>();
        
        return businesses.stream()
                .filter(b -> b.getLocation().getCity().equalsIgnoreCase(location.getCity()) 
                         && b.getLocation().getState().equalsIgnoreCase(location.getState()))
                .collect(Collectors.toList());
    }

    /**
     * Sort businesses by ratings
     */
    public static List<Business> sortBusinessesByRatings(List<Business> businesses) {
        return businesses.stream()
                .sorted((b1, b2) -> Double.compare(b2.getRating(), b1.getRating()))
                .collect(Collectors.toList());
    }

    /**
     * Filter businesses by type
     */
    public static List<Business> filterBusinessesByType(String type) {
        if (businesses == null) return new ArrayList<>();
        
        return businesses.stream()
                .filter(b -> b.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    /**
     * Display business information
     */
    public static void displayBusinessInfo(Business business) {
        System.out.println("\nName: " + business.getName());
        System.out.println("Type: " + business.getType());
        System.out.println("Location: " + business.getLocation().getCity() + ", " + business.getLocation().getState());
        System.out.println("Address: " + business.getLocation().getAddress());
        System.out.println("Rating: " + business.getRating() + "/5.0");
        System.out.println("Description: " + business.getDescription());
    }

    /**
     * Display all businesses
     */
    public static void displayBusinesses(List<Business> businesses) {
        for (Business business : businesses) {
            displayBusinessInfo(business);
        }
    }
}