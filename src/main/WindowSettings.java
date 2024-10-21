package main;

import java.awt.Color;
import java.awt.geom.Point2D;

public class WindowSettings {
    // Board constants
    public final static int BOARD_X = 200;
    public final static int BOARD_Y = 100;
    public final static int SQUARE_SIZE = 60;

    // Player constants
    public final static int PLAYER_RADIUS = 8;
    public final static Color[] PLAYER_COLORS = {
        Color.magenta,
        Color.red,
        Color.blue,
        Color.green
    };
    public final static Point2D[] PLAYER_START = {
        new Point2D.Double(BOARD_X - SQUARE_SIZE * 2 / 3.0, BOARD_Y + SQUARE_SIZE * 29/3.0),
        new Point2D.Double(BOARD_X - SQUARE_SIZE / 3.0, BOARD_Y + SQUARE_SIZE * 28/3.0),
        new Point2D.Double(BOARD_X - SQUARE_SIZE / 3.0, BOARD_Y + SQUARE_SIZE * 29/3.0),
        new Point2D.Double(BOARD_X - SQUARE_SIZE * 2 / 3.0, BOARD_Y + SQUARE_SIZE * 28/3.0)
    };

    // Timer constants
    public final static int PLAYER_STEP_DELAY = 200;    // ms
}