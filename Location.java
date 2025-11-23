// Sujit

import java.util.Objects;

/**
 * Location class - represents a geographical location
 */
public class Location {
    private String city;
    private String state;
    private String address;
    
    // TODO: Add constructor
    Location(String city, String state, String address){
      this.city = city;
      this.state = state;
      this.address = address;
    }
    
    // TODO: Add getters and setters
    //getters
    String getCity(){
      return city;
    }
    String getState(){
      return state;
    }
    String getAddress(){
      return address;
    }

    //setters:
    void setCity(String city){
      this.city = city;
    }
    void setState(String state){
      this.state = state;
    }
    void setAddress(String address){
      this.address = address;
    }
    
    
    // TODO: Add equals and hashCode methods for comparison
    @Override
    public boolean equals(Object o){
      if (this == o) {
        return true;
      }
      if (!(o instanceof Location)){
        return false;
      }
      Location other = (Location) o;
      return Objects.equals(city, other.city) && Objects.equals(state, other.state) && Objects.equals(address, other.address);
    }

    @Override
    public int hashCode(){
      return Objects.hash(city, state, address);
    }
}

