package main;
/**
 * 
 * @author kaitlyn
 */
public class Game {
    
    private static Player[] players;
    private static int numOfPlayers;
    private static int step = 0;

    private Board board;
    /**
     * class for the game object
     * @param playerNames array of player names
     * @throws Exception input validation
     */
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

        board = new Board(WindowSettings.BOARD_X, WindowSettings.BOARD_Y);
    }
    /**
     * method to play the game
     */
    public void PlayGame() {
        GameWindow window = new GameWindow(board, players);
        window.setVisible(true);

        boolean hasWinner = false;
        
        while(!hasWinner) {
            
            for(Player player : players) {
                step++;
                int currentPosition = player.getPosition();
                int diceNum = Dice.roll();
                int newPosition = currentPosition + diceNum;
                System.out.print(step + ": " + player.getName() + ": " + currentPosition + "---> " + newPosition);
                
                if(newPosition <= 100) {
                    window.playerWalk(player, board, newPosition);
                    if(board.getSquare(newPosition).getChute() != null) {
                        newPosition = processChute(newPosition);
                        window.playerStep(player, board, newPosition);
                    }
                
                    if(board.getSquare(newPosition).getLadder() != null) {
                        newPosition = processLadder(newPosition);
                        window.playerStep(player, board, newPosition);
                    }
                    System.out.println();
                    hasWinner = checkForWinner(player);
                    if (hasWinner) break;
                }
                else {
                    System.out.println(", Score over 100, try again");
                }
                // else if (newPosition == 100) {
                //     System.out.println("\nThe Winner is " + player.getName());
                //     hasWinner = true;
                //     break;
                // }             
            }
        }
    }
    
    private int processLadder(int newPos) {
        int topPos = board.getSquare(newPos).getLadder().climb(newPos);
        System.out.print(" -- Ladder --> " + topPos);
        newPos = topPos;

        return newPos;
    }
    
    private int processChute(int newPos) {
        int bottomPos = board.getSquare(newPos).getChute().slide(newPos);
        System.out.print(" -- Chute --> " + bottomPos);
        newPos = bottomPos;

        return newPos;
    }

    private boolean checkForWinner(Player player) {
        if (player.getPosition() == 100) {
            System.out.println("\nThe Winner is " + player.getName());
            return true;
        }
        return false;
    }
}
