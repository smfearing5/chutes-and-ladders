package main;

import java.awt.Color;
// import java.awt.geom.Point2D;
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
    public final static int CONNECTOR_WIDTH = SQUARE_SIZE/5;
    public final static int[][] CHUTE_LOCATIONS = {
        {98, 78}, {95, 75}, {93, 73}, {87, 24}, {64, 60},
        {62, 19}, {56, 53}, {49, 11}, {47, 26}, {16,  6}
    };
    public final static int[][] LADDER_LOCATIONS = {
        { 1, 38}, { 4, 14}, { 9,  31},
        {21, 42}, {28, 84}, {36,  43},
        {51, 68}, {71, 91}, {80, 100}
    };

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

    // Other Colors

    public final static Color CHUTE_COLOR = new Color(20, 30, 255);
    public final static Color LADDER_COLOR = new Color(165, 42, 42);

    // Timer constants

    /**
     * amount of time between each step
     */
    public final static int PLAYER_STEP_DELAY = 400;    // ms
}