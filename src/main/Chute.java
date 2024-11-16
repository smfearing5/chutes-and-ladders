package main;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import graphics.Vector;

/**
 * This is a class for the Chute object.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Chute {

    // Instance Variables
    
    private Square start;
    private Square end;
    // Image Variables
    private Line2D line1;
    private Line2D line2;

    // Private Methods

    private void buildImage() {
        Point2D anchor1 = start.getAnchor(end.getCenter());
        Point2D anchor2 = end.getAnchor(start.getCenter());
        Vector vector = new Vector(anchor1, anchor2);
        vector.setMagnitude(Settings.CONNECTOR_WIDTH/2.0);
        Vector[] orthogonal = vector.orthogonal();

        Point2D p1 = orthogonal[0].getPointFrom(anchor1);
        Point2D p2 = orthogonal[0].getPointFrom(anchor2);
        this.line1 = new Line2D.Double(p1, p2);

        Point2D p3 = orthogonal[1].getPointFrom(anchor1);
        Point2D p4 = orthogonal[1].getPointFrom(anchor2);
        this.line2 = new Line2D.Double(p3, p4);
    }

    /* Public Interface */

    // Constructor

    /**
     * Constructor for the Chute object
     * @param startSquare Starting Square (top of Chute)
     * @param endSquare Ending Square (bottom of Chute)
     */
    public Chute(Square startSquare, Square endSquare) {
        this.start = startSquare;
        this.end = endSquare;
        buildImage();
    }

    // Accessors

    /**
     * Returns the starting Square object (top of Chute)
     * @return The starting Square object
     */
    public Square getStartSquare() {return start;}

    /**
     * Returns the ending Square object (bottom of Chute)
     * @return The ending Square object
     */
    public Square getEndSquare() {return end;}

    // Mutators

    /**
     * Moves the top of the Chute to a new starting Square
     * @param newStartSquare New starting Square
     */
    public void setStartSquare(Square newStartSquare) {
        start = newStartSquare;
        buildImage();
    }

    /**
     * Moves the bottom of the Chute to a new ending Square
     * @param newEndSquare New ending Square
     */
    public void setEndSquare(Square newEndSquare) {
        end = newEndSquare;
        buildImage();
    }

    // Other Methods
  
    /**
     * Method used to draw the Chute
     * @param g2 Graphics2D object used for drawing
     */
    public void draw(Graphics2D g2) {
        g2.setColor(Settings.CHUTE_COLOR);
        g2.draw(line1);
        g2.draw(line2);
    }
}
