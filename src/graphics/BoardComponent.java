
package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import main.Board;
import main.Chute;
import main.Ladder;
import main.Player;

/**
 * This is a class for the BoardComponent object.
 * This object is used to take information from a Board object and draw to a GameWindow object.
 * This class extends the JComponent class.
 * 
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class BoardComponent extends JComponent {

    // Instance Variables

    Board board;
    Player[] players;

    /* Public Interface */
    
    // Constructor

    /**
     * Constructor for the BoardComponent object
     * @param board The Board Object
     * @param players An array of player objects
     */
    public BoardComponent(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    // Methods

    /**
     * Method used to draw the Board
     * Overwrites the paintComponent method of the JComponent class
     * @param g The default graphics object used by the JComponent class
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Draw squares
        for (int i = 1; i <= 100; i++) {
            board.getSquare(i).draw(g2);
        }

        // Draw Chutes
        Chute chute;
        for (int i = 1; i <= 100; i++) {
            chute = board.getSquare(i).getChute();
            if (chute != null) chute.draw(g2);
        }

        // Draw Ladders
        Ladder ladder;
        for (int i = 1; i <= 100; i++) {
            ladder = board.getSquare(i).getLadder();
            if (ladder != null) ladder.draw(g2);
        }

        // Draw Players
        for (Player player : players) {
            player.draw(g2);
        }
    }
}
