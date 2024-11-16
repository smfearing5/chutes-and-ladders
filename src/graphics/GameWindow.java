package graphics;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private JPanel boardPanel;
    private ControlPanel controlPanel;


    /* Public Interface */

    // Constructor

    /**
     * Constructor for the GameWindow object
     * @param board The board object used in this Game
     * @param players Array of player objects
     */
    public GameWindow(Board board, Player[] players) {
        setTitle("Chutes and Ladders");
        setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardImage = new BoardComponent(board, players);
        boardPanel = new JPanel(new BorderLayout());
        boardPanel.add(boardImage);
        boardPanel.setBackground(Settings.BOARD_PANEL_COLOR);
        boardPanel.setBounds(
            0, 0,
            Settings.WINDOW_SIZE,
            (Settings.WINDOW_SIZE * 3) / 4
        );
        add(boardPanel);

        controlPanel = new ControlPanel(players);
        controlPanel.setBounds(
            0, 
            (Settings.WINDOW_SIZE * 3) / 4, 
            Settings.WINDOW_SIZE, 
            (Settings.WINDOW_SIZE) / 4
        );
        add(controlPanel);
    }

    // Accessors

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    /**
     * Method used to update the Board image
     * This method should be called anytime a player moves
     */
    public void updateBoard() {boardImage.repaint();}
}