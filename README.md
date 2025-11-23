# NeighborConnect

## 1. Project Introduction  
NeighborConnect is a simple Java console application to help users discover, save, and browse local businesses. It demonstrates core Java/OOP concepts with a small, interactive UI.

## 2. Project Description  
Goal: provide a minimal neighborhood-business directory where users can register, log in, view businesses by location or type, and save favorites.

Phases / processes:
- Design data models (User, Business, Location).
- Implement authentication (register/login).
- Implement business manager (seed data, search, display).
- Add interactive menus (MainMenu, LoginMenu).
- Test flows and fix issues.

## 3. Project Architecture
Components:
- CLI UI: MainMenu, LoginMenu (user interaction).
- Authentication: register/login logic.
- Data layer: User, Business, Location, UserManager, BusinessManager.
- Controller: LoginMenu calls BusinessManager and UserManager.

Simple ASCII architecture:

+-----------------+       +-----------------+       +-----------------+
|   MainMenu      | <-->  |  Authentication |       |  LoginMenu      |
+-----------------+       +-----------------+       +-----------------+
        |                         |                         |
        v                         v                         v
+---------------------------------------------------------------+
|                      BusinessManager                          |
|  (seed data, searchByType, display, viewByLocation, save)     |
+---------------------------------------------------------------+
        ^
        |
+-----------------+     +-----------------+
|   UserManager   |     |   Data Models   |
| (add/find/list) |     | User, Business, Location |
+-----------------+     +-----------------+

## 4. UML Class Diagram (textual overview)
- User
  - username: String
  - password: String
  - email: String
  - savedBusinesses: List<Business>
  - +validatePassword(String): boolean
  - +addToSavedBusinesses(Business)
- Business
  - Name, Type, Location, Rating, Description
  - +get/set...
- Location
  - city, state, address
  - +equals(), hashCode()
- UserManager
  - users: List<User>
  - +addUser(User), +findUserByUsername(String), +usernameExists(String)
- BusinessManager
  - businesses: List<Business>
  - +searchBusinessByType(User), +viewBusinessesInLocation(User), +displayBusinessInfo(Business)
- Authentication
  - +registerUser(): User
  - +loginUser(List<User>): User
- MainMenu
  - +display()
- LoginMenu
  - +display()

(Classes interact as described in the architecture diagram above.)

## 5. OOP Concepts Used
- Encapsulation: fields are private; access via getters/setters (User, Business).
- Inheritance: minimal; utility classes are not extended. (Avoid multiple inheritance.)
- Polymorphism: Business and Location used via references in lists; menus invoke shared methods.
- Abstraction: Authentication and BusinessManager expose simplified methods to UI.
- Composition: User has List<Business>, Business has Location.

## 6. Code Description — 3 key features

1) User registration (Authentication.registerUser)  
   - Ensures password length and returns a created User.
   - Sample:
   ```java
   // Authentication.registerUser (excerpt)
   public static User registerUser() {
       System.out.print("Enter username: ");
       String name = scanner.nextLine();
       System.out.print("Enter a password (min 9 chars): ");
       String password = scanner.nextLine();
       while (password.length() < 9) { ... }
       return new User(name, password, new ArrayList<Business>());
   }
   ```

2) Login + saved businesses flow (Authentication.loginUser + LoginMenu)  
   - Validates username and password with limited attempts; on success opens LoginMenu.
   - Sample:
   ```java
   // Authentication.loginUser (excerpt)
   for (User u : users) {
       if (u.getUsername().equals(tempname)) {
           int attempts = 0;
           while (!u.validatePassword(tempPassword)) { attempts++; ... }
           return u;
       }
   }
   ```

3) Business seeding and search (BusinessManager static seed and search)  
   - Pre-populates businesses (Arlington, TX examples) and provides search by type.
   - Sample:
   ```java
   // BusinessManager static block (excerpt)
   Location loc1 = new Location("Arlington", "TX", "1001 S Collins St");
   businesses.add(new Business("Stadium Eats", "Restaurant", loc1, 4.5, "Fan-favorite"));
   // search by type filters list and prints results
   ```

## 7. System Testing
How to run:
- Compile: `javac *.java`
- Run: `java Main`


(Place runtime screenshots in `docs/screenshots/` and reference them here: `docs/screenshots/register.png`, `docs/screenshots/login.png`.)

## 8. Group members & responsibilities
- Subash — Main application entry, menu flow, LoginMenu, some core UI.
- Austin — Authentication, MainMenu improvements, CLI interaction.
- Sujit — User model, UserManager, integration and README/packaging.
- Sanjesh — Business and Location models, BusinessManager data seeding.

## 9. Conclusion and future works
It is concluded that the main objective of the application is to help computer science students understand the basics of Java. By browsing through the application and looking at the code for each graphical interpretation, students should be able to easily understand the implementation. Future work:
- Add persistent storage (file or DB).
- Replace CLI menus with a simple GUI or web front-end.
- Improve search (fuzzy match), pagination, and business reviews.

