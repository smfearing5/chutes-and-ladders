package main;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This is a class for the Ladder object.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Ladder {

    // Instance Variables
    
    private Square start;
    private Square end;
    // Image Variables
    private Line2D line1;
    private Line2D line2;
    private Line2D[] rungs;

    // Private Methods

    private void buildImage() {
        Point2D anchor1 = start.getAnchor(end.getCenter());
        Point2D anchor2 = end.getAnchor(start.getCenter());
        Vector vector = new Vector(anchor1, end.getCenter());
        vector.setMagnitude(Settings.CONNECTOR_WIDTH/2.0);
        Vector[] orthogonal = vector.orthogonal();

        Point2D p1 = orthogonal[0].getPointFrom(anchor1);
        Point2D p2 = orthogonal[0].getPointFrom(anchor2);
        this.line1 = new Line2D.Double(p1, p2);

        Point2D p3 = orthogonal[1].getPointFrom(anchor1);
        Point2D p4 = orthogonal[1].getPointFrom(anchor2);
        this.line2 = new Line2D.Double(p3, p4);

        vector = new Vector(p1, p2);
        int numRungs = (int) vector.getMagnitude() / Settings.CONNECTOR_WIDTH;
        vector.setMagnitude(vector.getMagnitude() / numRungs);
        numRungs--;

        Vector rungVector = new Vector(p1, p3);
        Point2D startPoint = p1;
        rungs = new Line2D[numRungs];

        for (int i = 0; i < numRungs; i++) {
            Point2D p5 = vector.getPointFrom(startPoint);
            Point2D p6 = rungVector.getPointFrom(p5);
            Line2D rung = new Line2D.Double(p5, p6);
            rungs[i] = rung;
            startPoint = p5;
        }
    }

    /* Public Interface */

    // Constructor

    /**
     * Constructor for the Ladder object
     * @param startSquare Starting Square (bottom of Ladder)
     * @param endSquare Ending Square (top of Ladder)
     */
    public Ladder(Square startSquare, Square endSquare) {
        this.start = startSquare;
        this.end = endSquare;
        buildImage();
    }

    // Accessors

    /**
     * Returns the starting Square object (bottom of Ladder)
     * @return The starting Square object
     */
    public Square getStartSquare() {return start;}

    /**
     * Returns the ending Square object (top of Ladder)
     * @return The ending Square object
     */
    public Square getEndSquare() {return end;}

    // Mutators

    /**
     * Moves the bottom of the Ladder to a new starting Square
     * @param newStartSquare New starting Square
     */
    public void setStartSquare(Square newStartSquare) {
        start = newStartSquare;
        buildImage();
    }

    /**
     * Moves the top of the Ladder to a new ending Square
     * @param newEndSquare New ending Square
     */
    public void setEndSquare(Square newEndSquare) {
        end = newEndSquare;
        buildImage();
    }

    // Other Methods

    /**
     * Method used to draw the Ladder
     * @param g2 Graphics2D object used for drawing
     */
    public void draw(Graphics2D g2) {
        g2.setColor(Settings.LADDER_COLOR);
        g2.draw(line1);
        g2.draw(line2);
        for (Line2D rung : rungs) {
            g2.draw(rung);
        }
    }
}
