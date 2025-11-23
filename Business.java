// Sanjesh

/**
 * Business class - represents a business entity
 */
public class Business {
    private String Name;
    private String Type;
    private Location location;
    private double Rating;
    private String Description;

    // --- Constructor ---
    public Business(String name, String type, Location location, double rating, String description) {
        this.Name = name;
        this.Type = type;
        this.location = location;
        this.Rating = rating;
        this.Description = description;
    }

    // --- Getters and Setters ---
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        this.Rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    // --- equals() and hashCode() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Business business = (Business) o;

        // Two businesses are considered equal if their name + location are equal
        if (!Name.equals(business.Name)) return false;
        return location != null ? location.equals(business.location) : business.location == null;
    }

    @Override
    public int hashCode() {
        int result = Name.hashCode();
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}