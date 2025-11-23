// Sujit

import java.util.List;

/**
 * UserManager - manages user data and operations
 */
public class UserManager {
    private List<User> users;
    
    UserManager(List<User> users){
        this.users = users;
    }
    
    /**
     * Add a new user
     */
    public void addUser(User user) {
        users.add(user);
    }
    
    /**
     * Find user by username
     */
    public User findUserByUsername(String username) {
        for (User user: users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    
    /**
     * Check if username exists
     */
    public boolean usernameExists(String username) {
        for (User user: users){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get all users
     */
    public List<User> getUsers() {
        return users;
    }
}