// Sanjesh

import java.util.List;
import java.util.Scanner;

/**
 * BusinessManager - handles business-related operations
 * Manages viewing, filtering, sorting, and searching businesses
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * BusinessManager - handles business-related operations
 * Manages viewing, filtering, sorting, and searching businesses
 */
public class BusinessManager {

    private static List<Business> businesses;
    private static Scanner scanner = new Scanner(System.in);

    // --- Constructor to initialize business list ---
    public BusinessManager(List<Business> businesses) {
        this.businesses = businesses;
    }

    /**
     * View businesses in a specific location
     */
    public static void viewBusinessesInLocation() {
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
        displayBusinesses(filtered);

        // 5. Save Business
        System.out.print("Do you want to save a business? (yes/no): ");
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter business name to save: ");
            String name = scanner.nextLine().trim();

            filtered.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(
                    business -> System.out.println("Business saved: " + business.getName()),
                    () -> System.out.println("Business not found.")
                );
        }
    }

    /**
     * Search businesses by type
     */
    public static void searchBusinessByType() {
        // 1. Enter Business Type
        System.out.print("Enter business type: ");
        String type = scanner.nextLine().trim();

        // 2. Filter Businesses by Type
        List<Business> filtered = filterBusinessesByType(type);

        if (filtered.isEmpty()) {
            System.out.println("No businesses found for type: " + type);
            return;
        }

        // 3. Display Business Info
        displayBusinesses(filtered);
    }

    /**
     * Select a location (simple version)
     */
    public static Location selectLocation() {
        System.out.print("Enter city: ");
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
        return businesses.stream()
                .filter(b -> b.getLocation().equals(location))
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
        return businesses.stream()
                .filter(b -> b.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    /**
     * Display business information
     */
    public static void displayBusinessInfo(Business business) {
        System.out.println("Name: " + business.getName());
        System.out.println("Type: " + business.getType());
        System.out.println("Location: " + business.getLocation());
        System.out.println("Rating: " + business.getRating());
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