// Austin
// 

/**
 * Handles user authentication - Register and Login
 */
public class Authentication extend business{
    Private String password;

    /**
     * Register a new user
     */
    public void registerUser() {
        // TODO: Implement user registration
        System.out.println("Enter the name of your business:");
        Scanner z =new Scanner(system.in);
        This.name=z.nextLine();
        System.out.println("Enter a password(atleast 9 characters and/or digits):");
        This.password=z.nextLine();
        While(password.lenght<9){
            System.out.println("ERROR password needs atleast be 9 characters and/or digits\nPlease enter a different password:");
            This.password=z.nextLine();
        }
        System.out.print("Your business name and password are now registered!");
    }
    
    /**
     * Login an existing user
     * @return User object if login successful, null otherwise
     */
    public User loginUser() {
        // TODO: Implement user login
        System.out.println("Enter the name of your business:");
        Scanner y=new scanner(system.in);
        String tempname=y.nextLine();
        While(tempname==name){
            System.out.println("Enter your password:");
            String tempPW=y.nextLine();
            While(!(tempPW==password)){
                System.outprintln("Incorrect password please try again:");
                tempPW=y.nextLine();
            }
            System.outprintln("Successful Login!");
        }
        return null;
    }
}
