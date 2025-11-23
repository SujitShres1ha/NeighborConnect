// Sujit

import java.util.List;

/**
 * User class - represents a registered user
 * Encapsulates user data and saved businesses
 */
public class User {
    private String username;
    private String password;
    private String email;
    private List<Business> savedBusinesses;
    
    // TODO: Add constructor
    User (String username, String password, String email, List<Business> savedBusinesses){
      this.username = username;
      this.password = password;
      this.email = email;
      this.savedBusinesses = savedBusinesses;
    }
    
    // TODO: Add getters and setters
    //getters
    String getUsername(){
      return username;
    }
    String getPassword(){
      return password;
    }
    String getEmail(){
      return email;
    }

    //setters
    void setUsername(String username){
      this.username = username;
    }
    void setPassword(String password){
      this.password = password;
    }
    void setEmail(String email){
      this.email = email;
    }

    
    // TODO: Add method to validate password
    boolean validatePassword(String inputPassword){
      if (password.equals(inputPassword)){
        return true;
      }
      return false;
    }
    
    // TODO: Add method to add saved business
    void addToSavedBusinesses(Business business){
      savedBusinesses.add(business);
    }
    
    // TODO: Add method to get saved businesses
    List<Business> getSavedBusinesses(){
      return savedBusinesses;
    }
}
