package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

/**
 * This is a class for the Square object.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Square {

    // Instance Variables
    
    private int id;
    private int x;
    private int y;
    private Ladder ladder;
    private Chute chute;

    /* Public Interface */
    
    // Constructor

    /**
     * Constructor for the Square object
     * @param id ID number
     * @param xPos x position of the Square
     * @param yPos y position of the Square
     */
    public Square(int id, int xPos, int yPos){
        this.id = id;
        this.x = xPos;
        this.y = yPos;
        this.ladder = null;
        this.chute = null;
    }

    // Accessors

    /**
     * Returns the ID number of the Square
     * @return the ID number
     */
    public int getID() {return id;}

    /**
     * Returns the x position of the Square
     * @return int for x position
     */
    public int getX() {return x;}

    /**
     * Returns the y position of the Square
     * @return int for y position
     */
    public int getY() {return y;}

    /**
     * Returns the point at the center of the Square
     * @return Point2D at center of Square
     */
    public Point2D getCenter() {
        int centerX = x + Settings.SQUARE_SIZE/2;
        int centerY = y + Settings.SQUARE_SIZE/2;

        return new Point2D.Double(centerX, centerY);
    }

    /**
     * Returns the Ladder that starts from this Square
     * Returns null if no Ladder starts from this Square
     * @return Corresponding Ladder object
     */
    public Ladder getLadder() {return ladder;}

    /**
     * Returns the Chute that starts from this Square
     * Returns null if no Chute starts from this Square
     * @return Corresponding Chute object
     */
    public Chute getChute() {return chute;}

    // placeholder, WIP
    public Point2D getAnchor(Point2D otherSquareCenter) {
        double radius = Settings.SQUARE_SIZE/4;
        Point2D thisCenter = getCenter();
        Vector vector = new Vector(thisCenter, otherSquareCenter);
        vector.setMagnitude(radius);
        
        return vector.getPointFrom(thisCenter);
    }

    // Mutators

    /**
     * Assigns an ID number to the Square
     * @param id  the ID number
     */
    public void setID(int id) {this.id = id;}

    /**
     * Sets the x position of the Square
     * @param xPos int for x position
     */
    public void setX(int xPos) {x = xPos;}

    /**
     * Sets the y position of the Square
     * @param yPos int for y position
     */
    public void setY(int yPos) {y = yPos;}

    /**
     * Assigns a Ladder to the Square
     * @param ladder Ladder object starting from this Square
     */
    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
   
    /**
     * Assigns a Chute to the Square
     * @param chute Chute object starting from this Square
     */
    public void setChute(Chute chute) {
        this.chute = chute;
    }

    // Other Methods

    /**
     * Method used to draw the Square
     * @param g2 Graphics object used for drawing
     */
    public void draw(Graphics2D g2) {
        // Draw the Square
        Rectangle rectangle = new Rectangle(
            x, y,                           // x position, y position
            Settings.SQUARE_SIZE,     // width
            Settings.SQUARE_SIZE      // height
        );
        if (id % 2 == 0) {
            g2.setColor(Color.YELLOW);
            g2.fill(rectangle);
            g2.setColor(Color.BLACK);
        }
        g2.draw(rectangle);

        // Draw the number
        String numString = "" + id;
        if (id < 100) numString = " " + numString;
        if (id < 10) numString = " " + numString;
        g2.drawString(
            numString, 
            x + 5, 
            y + Settings.SQUARE_SIZE/4
        );
    }
}