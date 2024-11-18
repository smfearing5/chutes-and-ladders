package main;

import java.util.Scanner;

/**
 * Main class for running the program.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Main {
/**
 * Main method to run the program
 * @param args Optional arguments (not used)
 * @throws Exception input validation
 */
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter Number of Players: ");
        int numPlayers = in.nextInt();   
        in.nextLine();
        
        numPlayers = InputValidation.validateInput(numPlayers);
        
        
        String[] players = new String[numPlayers];
        
       
        for(int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i+1) + ": ");
            players[i] = in.nextLine();
        }
        in.close();
        
        System.out.println("Players entered:");
        for (String player : players) {
            System.out.println(player);
        }
        
        Game game = new Game(players);
        game.PlayGame();
    }
}
