/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreviewcodeforpartc;

import java.util.Scanner;

/**
 * The signIn page for UnoOnline.
 * Takes in a user name and password and then
 * validates the password before creating a new user in the list
 * of possible users. To be used as the beginning code for MidtermReview C.
 * @author dancye, 2019
 */
public class UnoOnline 
{
    private User users[] = new User[100];//room for 100 online players!
     
    /**
     * Main method with call to private run method, to encapsulate our
     * main functionality.
     * @param args - not used
     */
    public static void main(String[] args) 
     {
       UnoOnline newPortal = new UnoOnline();
       newPortal.run();
    }
     /**
     * method that takes in the User's name and chosen password
     * and then continues prompting until the password is valid based on the
     * following two rules:
     * 1. The password must be at least length 8
     * 2. The password must contain at least one "special character"
     * 
     */
    private void run()
{
    int userCount = 0; // Counting how many users we have
    Scanner sc = new Scanner(System.in); // This lets people type answers
    
    System.out.println("please enter your desired user name:");
    String userName = sc.nextLine(); // Get their username
    
    // CREATE OUR PASSWORD CHECKER!
    PasswordValidator validator = new PasswordValidator();
    
    boolean validPassword = false; // Set password invalid as default.
    String password = "";
    
    // System will ask to input password until meet the requirements
    while (!validPassword) {
        
        // Display requirements
        System.out.println(validator.getRequirementsMessage());
        System.out.println("Please enter your desired password:");
        
        password = sc.nextLine(); // Assigning the password
        
        // Validates if password is good or bad
        validPassword = validator.isValid(password);
        
        // If password is bad, system ask player to type another password
        if (!validPassword) {
            System.out.println("Password does not meet requirements. Please try again.\n");
        }
    }
    
    // Adding new user if username and password (valid)
    User newUser = new User(userName, password);
    users[userCount] = newUser;
    userCount++;
    
    // Display player added and provide username
    System.out.println("New User Added");
    System.out.println("UserName: " + userName);
    System.out.println("Password: just kidding can't show password");
}
   
    
}//end class
