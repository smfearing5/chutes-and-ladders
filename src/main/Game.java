
package main;


public class Game {
    
    private static Player[] players;
    private static int numOfPlayers;
    private static int step = 0;
    
    public Game(String[] playerNames) throws Exception {
        
        if(playerNames == null || playerNames.length == 0 ) {
            throw new Exception("no players, try again");
        }
        
        numOfPlayers = playerNames.length;
        if(numOfPlayers > 4 || numOfPlayers < 2) {
            throw new Exception("not correct amount of players");
        }
        
        players = new Player[numOfPlayers];
        for(int i = 0; i < numOfPlayers; i++) {
            players[i] = new Player(i+1, playerNames[i]);
        }
        Board.setUpBoard();
        
    }
    
    public void PlayGame() {
        
        boolean hasWinner = false;
        
        while(!hasWinner) {
            
            for(Player player : players) {
                step++;
                int currentPosition = player.getPosition();
                int diceNum = Dice.roll();
                int newPosition = currentPosition + diceNum;
                System.out.print(step + ": " + player.getName() + ": " + currentPosition + "---> " + newPosition);
                
                if(newPosition < 100) {
                    if(Board.squares[newPosition].getChute() != null) {
                    processChute(newPosition);
                    }
                
                    if(Board.squares[newPosition].getLadder() != null) {
                    processLadder(newPosition);
                    }
                     player.setPosition(newPosition);
                     System.out.println();
                }else if (newPosition > 100) {
                    System.out.println(", Score over 100, try again");
                    
                }else if (newPosition == 100) {
                    System.out.println("\nThe Winner is " + player.getName());
                    hasWinner = true;
                    break;
                }             
                             
                
                
            }
        }
        
    }
    
    private void processLadder(int newPos) {
        int topPos = Board.squares[newPos].getLadder().climb(newPos);
        System.out.print(" -- Ladder --> " + topPos);
        newPos = topPos;
    }
    
    private void processChute(int newPos) {
        int bottomPos = Board.squares[newPos].getChute().slide(newPos);
        System.out.println(" -- Chute --> " + bottomPos);
        newPos = bottomPos;
    }
    
    
    
    
}
