package graphics;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import main.Board;
import main.Player;
import main.Settings;

/**
 * This is a class for the GameWindow object.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class GameWindow extends JFrame {

    // Instance Variables

    private BoardComponent boardImage;


    /* Public Interface */

    // Constructor

    /**
     * Constructor for the GameWindow object
     * @param board The board object used in this Game
     * @param players Array of player objects
     */
    public GameWindow(Board board, Player[] players) {
        setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        setTitle("Chutes and Ladders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel title = new JLabel("Chutes and Ladders");
        // add(title, BorderLayout.NORTH);

        boardImage = new BoardComponent(board, players);
        add(boardImage, BorderLayout.CENTER);
    }

    /**
     * Method used to update the Board image
     * This method should be called anytime a player moves
     */
    public void updateBoard() {boardImage.repaint();}
}