package main;

import java.awt.Color;

/**
 * This is a utility class for game Settings
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Settings {
    /**
     * The height and width of the GameWindow
     */
    public final static int WINDOW_SIZE = 1000;

    // Board constants

    /**
     * Board x position
     */
    public final static int BOARD_X = 200;

    /**
     * Board y position
     */
    public final static int BOARD_Y = 75;

    /**
     * The side length of each Square
     */
    public final static int SQUARE_SIZE = 60;

    /**
     * The width for Chute and Ladder images
     */
    public final static int CONNECTOR_WIDTH = SQUARE_SIZE/5;

    /*
     * A 2D int array for Chute locations
     * The first index represents a specific Chute,
     * and the second index will be 
     * 0 for the start Square or
     * 1 for the end Square.
     */
    public final static int[][] CHUTE_LOCATIONS = {
        {98, 78}, {95, 75}, {93, 73}, {87, 24}, {64, 60},
        {62, 19}, {56, 53}, {49, 11}, {47, 26}, {16,  6}
    };

    /*
     * A 2D int array for Ladder locations
     * The first index represents a specific Ladder,
     * and the second index will be 
     * 0 for the start Square or
     * 1 for the end Square.
     */
    public final static int[][] LADDER_LOCATIONS = {
        { 1, 38}, { 4, 14}, { 9,  31},
        {21, 42}, {28, 84}, {36,  43},
        {51, 68}, {71, 91}, {80, 100}
    };

    // Panel Constants

    /**
     * Width of the PlayerPanel
     */
    public final static int PLAYER_PANEL_WIDTH = 140;

    /**
     * Height of the PlayerPanel
     */
    public final static int PLAYER_PANEL_HEIGHT = 165;

    // Player constants

    /**
     * Radius of the circle when the player is drawn
     */
    public final static int PLAYER_RADIUS = 8;

    /**
     * Array of colors that will be assigned to each player
     */
    public final static Color[] PLAYER_COLORS = {
        Color.magenta,
        Color.red,
        Color.blue,
        Color.green
    };

    // Other Colors

    /**
     * Background Color for Board Panel
     */
    public final static Color BOARD_PANEL_COLOR = new Color(185, 122, 87);

    /**
     * Colors for Squares
     */
    public final static Color[] SQUARE_COLORS = {
        new Color(237, 226, 2),     // Yellow
        new Color(224, 218, 198)    // Tan
    };

    /**
     * Color of the Chutes
     */
    public final static Color CHUTE_COLOR = new Color(20, 30, 255);

    /**
     * Color of the Ladders
     */
    public final static Color LADDER_COLOR = new Color(165, 42, 42);

    // Timer constants

    /**
     * The amount of time between each player step
     * (in milliseconds)
     */
    public final static int PLAYER_STEP_DELAY = 400;    // ms
}