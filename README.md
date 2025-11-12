# NeighborConnect

A terminal-based Java application for connecting neighbors with local businesses.

## Project Structure

```
src/main/java/com/neighborconnect/
├── Main.java              - Entry point
├── MainMenu.java          - Main menu (Register, Login, Exit)
├── Authentication.java    - Handles user registration and login
├── User.java              - User entity class
├── LoginMenu.java         - Menu after login
├── Business.java          - Business entity class
├── Location.java          - Location entity class
├── BusinessManager.java   - Manages business operations
└── UserManager.java       - Manages user operations
```

## User Flow

1. **Start** → Main Menu
2. **Main Menu** → Register/Login/Exit
3. **Authentication** → Register User / Login User
4. **Login Menu** → View Businesses / Search by Type / Saved Businesses / Logout
5. **Business Interaction** → View, Filter, Sort, Save businesses



