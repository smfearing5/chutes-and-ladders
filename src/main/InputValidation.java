
package main;

/**
 * This class is used for any input validation methods
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class InputValidation {
    
    /**
     * Validates number of players
     * @param input value that is being validated
     * @return the input to be used again 
     * @throws Exception if input is not valid 
     */
    public static int validateInput(int input) throws Exception {
        
        if (input == 0) {
            throw new Exception("no players, try again");
        }
        else if (input > 4  || input < 2) {
            throw new Exception("not correct amount of players");
        }
        return input;
 
    }
 
}
