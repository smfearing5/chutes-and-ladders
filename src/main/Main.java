
package main;

import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) throws Exception {
        
        
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("Enter Number of Players: ");
        int people = in.nextInt();   
        in.nextLine();
        
        String[] players = new String[people];
        
        
        
        for(int i = 0; i < people; i++) {
            System.out.println("Player " + (i+1) + ": ");
            players[i] = in.nextLine();
        }
        
         System.out.println("Players entered:");
        for (String player : players) {
            System.out.println(player);
        }
                
        
      
        
        Game game = new Game(players);
        game.PlayGame();
       
        
    }
    
}
