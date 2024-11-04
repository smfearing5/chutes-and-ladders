package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * This is a class for the Player object.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Player {

    // Instance Variables

    private int id;
    private int position;
    private String name;
    private Color color;
    private Point2D location;

    // Private Methods

    private Point2D getCorner() {
        Point2D corner = new Point2D.Double(
            location.getX() + Settings.PLAYER_RADIUS,
            location.getY() + Settings.PLAYER_RADIUS
        );

        return corner;
    }
    
    /* Public Interface */

    // Constructor

    /**
     * Constructor for the player object
     * @param playerID ID number
     * @param name name of the player
     */
    public Player(int playerID, String name) {
        this.id = playerID;
        this.position = 0;
        this.name = name;
        this.color = Settings.PLAYER_COLORS[playerID % 4];
        this.location = new Point2D.Double();
    }

    // Accessors

    /**
     * Returns the player ID
     * @return the player ID
     */
    public int getID() {return id;}

    /**
     * Returns the player position
     * This is an integer that corresponds to the Square where the player is.
     * This also represent the player's "score"
     * @return The player's position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Returns the player name
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's color
     * @return The player's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the player's locaction. 
     * The location is an xy coordinate, 
     * and is not the same as the player's position
     * @return Point2D for the player's location
     */
    public Point2D getLocation() {
        return location;
    }

    // Mutators

    /* 
        There is no setter for the player's ID because 
        this should never change throughout the game
    */

    /**
     * Sets the player's position
     * @param pos int for player's new position
     */
    public void setPosition(int pos) {
        this.position = pos; 
    }

    /**
    * Sets the player's name
    * @param name String for player's name
    */ 
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the player's location using two integers.
     * The location is an xy coordinate,
     * and is not the same as the player's position
     * @param x x position
     * @param y y position
     */
    public void setLocation(int x, int y) {
        location = new Point2D.Double(x, y);
    }
    /**
     * Sets the player's location using a Point2D.
     * The location is an xy coordinate,
     * and is not the same as the player's position
     * @param newLocation Point2D for player's new location
     */
    public void setLocation(Point2D newLocation) {
        location = newLocation;
    }

    // Other Methods

    /**
     * Method used to draw the player
     * @param g2 Graphics2D object used for drawing
     */
    public void draw(Graphics2D g2) {
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(location, getCorner());
        g2.setColor(color);
        g2.fill(circle);
        g2.setColor(Color.black);
        g2.draw(circle);
    }
}
