package midtermreviewcodeforpartc;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Reasons for adding the PasswordValidator
 * 
 * 1. High Cohesion - All method and variable in this class has only one job 
 *                    but to check the password. Also, changing password 
 *                    requirements is in one place.
 * 
 * 2. Low Coupling -  The class is independent of other system components. It
 *                    is reusable and any changes will not affect other parts 
 *                    of the program.
 *                    
 *                    For future use, it's easy to add additional requirements
 *                    adding numbers, has upper case, has lowercase
 * 
 * @author mikel
 */
public class PasswordValidator {
    
    // easy update: minimum lenghth of the password and number of specila char 
    private static final int MIN_LENGTH = 8;           // Minimum password length
    private static final int MIN_SPECIAL_CHARS = 1;     // Minimum special characters
    
    /* Checks if password is valid.
     * @return true if password is valid, false if not valid
     */
    public boolean isValid(String password) {
        return passLength(password) && passSpecialChar(password);
    }
    
    /* Checks if password is long enough.
     * @return true if password has enough characters
     */
    private boolean passLength(String password) {
        if (password == null) {
            return false;
        }
        return password.length() >= MIN_LENGTH;
    }
    
    /* Checks if password has special symbols
     * @return true if password has enough special characters
     */
    private boolean passSpecialChar(String password) {
        if (password == null) {
            return false;
        }
        
        int specialCharCount = 0;
        
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                specialCharCount++;
            }
        }
        
        return specialCharCount >= MIN_SPECIAL_CHARS;
    }
    
    // message explaining password requirements
    public String getRequirementsMessage() {
        return "Passwords must have at least " + MIN_LENGTH + " characters\n" +
               "Passwords must have at least " + MIN_SPECIAL_CHARS + " special character(s)";
    }
}
