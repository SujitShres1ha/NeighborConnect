// Austin

/**
 * Main Menu - Entry point after Start
 * Options: Register, Login, Exit
 */
public class MainMenu extend Authentication {
    
    public void display() {
        // TODO: Display menu options
        system.out.println("Enter an option:");
        system.outprintln("1.Register\n2.Login\n3.Exit");
        scanner x=new scanner(system.in);
        int y=x.next.Int();
        switch(y){
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                break;

        }
        // 1. Register
        // 2. Login
        // 3. Exit
    }
    
    // TODO: Add methods to handle menu selections
}
