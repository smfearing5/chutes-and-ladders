import main.Player;
import main.Settings;
import main.Square;
import main.Board;
import graphics.ControlPanel;
import graphics.GameWindow;

public class GameWindowTester {
    public static void main(String[] args) {
        // Set up Board
        Board board = new Board(Settings.BOARD_X, Settings.BOARD_Y);

        // Set up players
        Square playerSquare;
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(i+1, "test player " + (i+1));
            playerSquare = board.getSquare((i*29) + 11);
            players[i].setLocation(playerSquare.getCenter());
        }


        // Construct Game Window
        GameWindow window = new GameWindow(board, players);
        window.setVisible(true);

        // Test getControlPanel
        ControlPanel cPanel = window.getControlPanel();
        System.out.println("Control Panel waiting for roll : " + cPanel.isWaitingForRoll());

        // Test updateBoard
        TesterDelay.process("Moving Player");
        playerSquare = board.getSquare(100);
        players[3].setLocation(playerSquare.getCenter());
        window.updateBoard();
    }
}
