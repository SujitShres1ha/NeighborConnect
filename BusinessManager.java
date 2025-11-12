

import java.util.List;

/**
 * BusinessManager - handles business-related operations
 * Manages viewing, filtering, sorting, and searching businesses
 */
public class BusinessManager {
    private List<Business> businesses;
    
    // TODO: Add constructor to initialize businesses list
    
    /**
     * View businesses in a specific location
     */
    public void viewBusinessesInLocation() {
        // TODO: Implement flow:
        // 1. Select Location
        // 2. Filter Businesses by Location
        // 3. Sort Businesses by Ratings
        // 4. Display Business Info
        // 5. Save Business? (Yes/No)
    }
    
    /**
     * Search businesses by type
     */
    public void searchBusinessByType() {
        // TODO: Implement flow:
        // 1. Enter Business Type
        // 2. Filter Businesses by Type
        // 3. Display Business Info
    }
    
    /**
     * Select a location
     */
    public Location selectLocation() {
        // TODO: Implement location selection
        return null;
    }
    
    /**
     * Filter businesses by location
     */
    public List<Business> filterBusinessesByLocation(Location location) {
        // TODO: Implement filtering by location
        return null;
    }
    
    /**
     * Sort businesses by ratings
     */
    public List<Business> sortBusinessesByRatings(List<Business> businesses) {
        // TODO: Implement sorting by ratings
        return null;
    }
    
    /**
     * Filter businesses by type
     */
    public List<Business> filterBusinessesByType(String type) {
        // TODO: Implement filtering by type
        return null;
    }
    
    /**
     * Display business information
     */
    public void displayBusinessInfo(Business business) {
        // TODO: Display business details
    }
    
    /**
     * Display all businesses
     */
    public void displayBusinesses(List<Business> businesses) {
        // TODO: Display list of businesses
    }
}

