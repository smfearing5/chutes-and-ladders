package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
// import javax.swing.JLabel;
/**
 * 
 * @author kaitlyn
 */
public class GameWindow extends JFrame {

    // Constants

    private static final int FRAME_SIZE = 1000;

    // Instance Variables

    private BoardComponent boardImage;


    /* Public Interface */

    // Constructor

    /**
     * constructor for the game window object
     * @param board board object
     * @param players array of player objects
     */
    public GameWindow(Board board, Player[] players) {
        setSize(FRAME_SIZE, FRAME_SIZE);
        setTitle("Chutes and Ladders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel title = new JLabel("Chutes and Ladders");
        // add(title, BorderLayout.NORTH);

        boardImage = new BoardComponent(board, players);
        add(boardImage, BorderLayout.CENTER);
    }

    public void updateBoard() {boardImage.repaint();}
}