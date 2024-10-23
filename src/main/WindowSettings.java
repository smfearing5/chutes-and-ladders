package main;

import java.awt.Color;
import java.awt.geom.Point2D;
/**
 * 
 * @author kaitlyn
 */
public class WindowSettings {
    // Board constants
    /**
     * board x position
     */
    public final static int BOARD_X = 200;
    /**
     * board y position
     */
    public final static int BOARD_Y = 100;
    /**
     * the square size
     */
    public final static int SQUARE_SIZE = 60;

    // Player constants
    /**
     * radius of the circle when the player is drawn
     */
    public final static int PLAYER_RADIUS = 8;
    /**
     * array of colors that will be assigned to each player
     */
    public final static Color[] PLAYER_COLORS = {
        Color.magenta,
        Color.red,
        Color.blue,
        Color.green
    };
    /**
     * player start positions
     */
    public final static Point2D[] PLAYER_START = {
        new Point2D.Double(BOARD_X - SQUARE_SIZE * 2 / 3.0, BOARD_Y + SQUARE_SIZE * 29/3.0),
        new Point2D.Double(BOARD_X - SQUARE_SIZE / 3.0, BOARD_Y + SQUARE_SIZE * 28/3.0),
        new Point2D.Double(BOARD_X - SQUARE_SIZE / 3.0, BOARD_Y + SQUARE_SIZE * 29/3.0),
        new Point2D.Double(BOARD_X - SQUARE_SIZE * 2 / 3.0, BOARD_Y + SQUARE_SIZE * 28/3.0)
    };

    // Timer constants
    /**
     * amount of time between each step
     */
    public final static int PLAYER_STEP_DELAY = 200;    // ms
}