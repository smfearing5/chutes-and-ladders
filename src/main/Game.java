package main;

import graphics.ControlPanel;
import graphics.GameWindow;

/**
 * This class contains everything needed for a single play session.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Game {

    // Instance Variables

    private Board board;
    private Player[] players;
    private GameWindow window;

    // Private Methods

    private void playerSpread(int squareID) {
        // Check for players on the same square
        Square square = board.getSquare(squareID);
        Player singlePlayer = new Player(0, null);
        int numOfPlayers = 0;
        for (Player player : players) {
            if (player.getPosition() == squareID) {
                numOfPlayers++;
                singlePlayer = player;
            }
        }
        // Single player just goes to center of square
        if (numOfPlayers == 1) singlePlayer.setLocation(square.getCenter());
        else if (numOfPlayers >= 2) {
            // Spread the players
            int x1 = square.getX() + Settings.SQUARE_SIZE/3;
            int x2 = square.getX() + Settings.SQUARE_SIZE*2/3;
            int y1 = square.getY() + Settings.SQUARE_SIZE/3;
            int y2 = square.getY() + Settings.SQUARE_SIZE*2/3;

            Player[] samePos = new Player[numOfPlayers];
            int playerIndex = 0;
            for (Player player : players) {
                if (player.getPosition() == squareID) {
                    samePos[playerIndex] = player;
                    playerIndex++;
                }
            }
            switch (numOfPlayers) {
                case 2:
                    int centerY = (int) square.getCenter().getY();
                    samePos[0].setLocation(x1, centerY);
                    samePos[1].setLocation(x2, centerY);
                    break;
                case 4:
                    samePos[3].setLocation(x2, y2);
                case 3:
                    samePos[0].setLocation(x1, y1);
                    samePos[1].setLocation(x2, y1);
                    samePos[2].setLocation(x1, y2);
                    break;
            }
        }
    }

    private void playerStep(Player player, int newPos) {
        int startPos = player.getPosition();
        player.setPosition(newPos);
        playerSpread(startPos);
        playerSpread(newPos);
        window.updateBoard();
        try {
            Thread.sleep(Settings.PLAYER_STEP_DELAY);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();;
        }
    }

    private void playerWalk(Player player, int newPos) {
        int currentSquareID = player.getPosition();
        while (player.getPosition() != newPos) {
            currentSquareID++;
            playerStep(player, currentSquareID);
        }
    }
    
    private int processLadder(int newPos) {
        int topPos = board.getSquare(newPos).getLadder().getEndSquare().getID();
        System.out.print(" -- Ladder --> " + topPos);

        return topPos;
    }
    
    private int processChute(int newPos) {
        int bottomPos = board.getSquare(newPos).getChute().getEndSquare().getID();
        System.out.print(" -- Chute --> " + bottomPos);

        return bottomPos;
    }

    private boolean checkForWinner(Player player) {
        if (player.getPosition() == 100) {
            System.out.println("\nThe Winner is " + player.getName());
            return true;
        }
        return false;
    }

    /* Public Interface */

    // Constructor

    /**
     * Constructor for the Game object
     * @param playerNames Array of player names
     * @throws Exception input validation
     */
    public Game(String[] playerNames) throws Exception {
        int numOfPlayers;
        
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

        board = new Board(Settings.BOARD_X, Settings.BOARD_Y);
        window = new GameWindow(board, players);
        playerSpread(0);
    }

    // Methods

    /**
     * Method used to start the play session
     */
    public void PlayGame() {
        window.setVisible(true);
        ControlPanel controlPanel = window.getControlPanel();

        int step = 0;
        int currentPosition;
        int newPosition;
        boolean hasWinner = false;
        
        // Main Game loop
        while(!hasWinner) {
            // For each Player...
            for(Player player : players) {
                // Player takes a turn
                step++;

                // Wait for Player to roll
                while (controlPanel.isWaitingForRoll()) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();;
                    }
                }

                // Move Player
                currentPosition = player.getPosition();
                newPosition = currentPosition + controlPanel.getRoll();;

                System.out.print("Turn " + step + ": " + player.getName() + ": ");
                System.out.print(currentPosition + "---> " + newPosition);
                
                if(newPosition > 100) {
                    System.out.println(", Score over 100, try again");
                }
                else {
                    playerWalk(player, newPosition);

                    if(board.getSquare(newPosition).getChute() != null) {
                        newPosition = processChute(newPosition);
                        playerStep(player, newPosition);
                    }
                
                    if(board.getSquare(newPosition).getLadder() != null) {
                        newPosition = processLadder(newPosition);
                        playerStep(player, newPosition);
                    }
                    System.out.println();
                    hasWinner = checkForWinner(player);
                    if (hasWinner) break;  // breaks the for loop so no Players go after the winner
                    else controlPanel.nextTurn();
                } 
            }
        } // end of Game loop
        controlPanel.endGame();
    }
}
