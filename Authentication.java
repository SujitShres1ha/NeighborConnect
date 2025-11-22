// Austin
// 

/**
 * Handles user authentication - Register and Login
 */
public class Authentication extend business{
    private string password;

    /**
     * Register a new user
     */
    public void registerUser() {
        // TODO: Implement user registration
        System.out.println("Enter the name of your business:");
        scanner z =new scanner(system.in);
        this.name=z.nextLine();
        system.out.println("Enter a password(atleast 9 characters and/or digits):");
        this.password=z.nextLine();
        while(password.lenght<9){
            system.out.println("ERROR password needs atleast be 9 characters and/or digits\nPlease enter a different password:");
            this.password=z.nextLine();
        }
        system.out.print("Your business name and password are now registered!");
    }
    
    /**
     * Login an existing user
     * @return User object if login successful, null otherwise
     */
    public User loginUser() {
        // TODO: Implement user login
        system.out.println("Enter the name of your business:");
        scanner y=new scanner(system.in);
        string tempname=y.nextLine();
        while(tempname==name){
            system.out.println("Enter your password:");
            string tempPW=y.nextLine();
            while(!(tempPW==password)){
                system.outprintln("Incorrect password please try again:");
                tempPW=y.nextLine();
            }
            system.outprintln("Successful Login!");
        }
        return null;
    }
}
