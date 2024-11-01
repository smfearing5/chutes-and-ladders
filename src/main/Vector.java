package main;

import java.awt.geom.Point2D;

/**
 * This class is used for Vector math.
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class Vector {

    // Instance Variables

    private double x;
    private double y;
        // magnitude is a virtual variable

    /* Public Interface */

    // Constructors

    /**
     * Default Constructor for Vector object.
     * Returns a zero Vector
     */
    public Vector() {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a Vector using x and y components
     * @param x The x component
     * @param y The y component
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a Vector from two points.
     * Parameter order is important, the Vector's
     * direction will be pointing
     * FROM Point 1 TO Point 2
     * @param p1 Point 1
     * @param p2 Point 2
     */
    public Vector(Point2D p1, Point2D p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
    }

    // Accessors

    /**
     * Returns the x component of the Vector
     * @return The x component of the Vector
     */
    public double getX() {return x;}

    /**
     * Returns the y component of the Vector
     * @return The y component of the Vector
     */
    public double getY() {return y;}

    /**
     * Returns the magnitude of the Vector
     * @return The magnitude of the Vector
     */
    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    // Mutators

    /**
     * Sets the x component of the Vector
     * @param x New x component
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y component of the Vector
     * @param y New y component
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Scales the Vector to a new magnitude
     * @param magnitude New magnitude
     */
    public void setMagnitude(double magnitude) {
        if (getMagnitude() == 0) {
            System.out.println("ERROR: Cannot set magnitude on Zero Vector!");
        }
        else {
            double scalar = magnitude / getMagnitude();
            x *= scalar;
            y *= scalar;
        }
    }

    // Other Methods

    /**
     * Returns the terminating point of the Vector,
     * given a starting point
     * @param startPoint Starting point
     * @return Terminating point
     */
    public Point2D getPointFrom(Point2D startPoint) {
        double px = x + startPoint.getX();
        double py = y + startPoint.getY();

        return new Point2D.Double(px, py);
    }

    /**
     * Returns a unit Vector with the 
     * same direction as this Vector
     * @return New unit Vector
     */
    public Vector getUnitVector() {
        if (getMagnitude() == 0) return new Vector();
        Vector unitVector = new Vector(x, y);
        unitVector.setMagnitude(1);
        return unitVector;
    }

    /**
     * Returns a Vector equal in magnitude
     * add opposite in direction to this Vector
     * @return New reverse Vector
     */
    public Vector reverse() {
        return new Vector(-x, -y);
    }

    /**
     * Returns a Vector array containing
     * the two Vectors of equal magnitude
     * that are orthogonal to this Vector
     * @return Orthogonal Vector Array (length: 2)
     */
    public Vector[] orthogonal() {
        Vector[] orthArray = new Vector[2];
        orthArray[0] = new Vector(y, -x);
        orthArray[1] = new Vector(-y, x);

        return orthArray;
    }
}
