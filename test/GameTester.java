import main.Game;

public class GameTester {
    public static void main(String[] args){
        try {
            // This is testing for valid initialzation
            String[] playerNames = {"p1", "p2"};
            Game game = new Game(playerNames);
            System.out.println("Game initialized successfully with 2 players.");
        
            // Test for when there are more than 4 players
            try {
                String[] tooManyPlayers = {"p1", "p2", "p3", "p4", "p5"};
                game = new Game(tooManyPlayers);
                System.out.println("Game initialized with too many players. Test failed.");            
            } catch (Exception e){
                System.out.println("Correctly caught exception for too many players: " + e.getMessage());
            }
        
            // This test for when there are less than 2 players
            try {
                String[] tooFewPlayers = {"p1"};
                game = new Game(tooFewPlayers);
                System.out.println("Game initialized with too few players. Test failed.");
            } catch (Exception e) {
                System.out.println("Correctly caught exception for too few players: " + e.getMessage());
            }
        
            // This test for when the player names are null
            try { 
                game = new Game(null); 
                System.out.println("Game initialized with null player names. Test failed.");
            } catch (Exception e) { 
                System.out.println("Correctly caught exception for null player names: " + e.getMessage()); 
            }
            
            // This test for when the player names are empty
            try {
                game = new Game(new String[]{}); 
                System.out.println("Game initialized with empty player names. Test failed."); 
            } catch (Exception e) { 
                System.out.println("Correctly caught exception for empty player names: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}