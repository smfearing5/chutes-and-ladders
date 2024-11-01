package main;

import java.awt.geom.Point2D;

public class Vector {
    // Instance Variables
    private double x;
    private double y;
        // magnitude is a virtual variable

    /* Public Interface */

    // Constructors
    public Vector() {
        x = 0;
        y = 0;
    }
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector(Point2D p1, Point2D p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
    }

    // Accessors
    public double getX() {return x;}
    public double getY() {return y;}
    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    // Mutators
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setMagnitude(double magnitude) {
        if (getMagnitude() == 0) {
            System.out.println("ERROR: Cannot set magnitude on Zero Vector!");
        }
        else {
            double ratio = magnitude / getMagnitude();
            x *= ratio;
            y *= ratio;
        }
    }

    // Other Methods
    public Point2D getPointFrom(Point2D startPoint) {
        double px = x + startPoint.getX();
        double py = y + startPoint.getY();

        return new Point2D.Double(px, py);
    }
    public Vector getUnitVector() {
        if (getMagnitude() == 0) return new Vector();
        Vector unitVector = new Vector(x, y);
        unitVector.setMagnitude(1);
        return unitVector;
    }
    public Vector reverse() {
        return new Vector(-x, -y);
    }
    public Vector[] orthogonal() {
        Vector[] orthArray = new Vector[2];
        orthArray[0] = new Vector(y, -x);
        orthArray[1] = new Vector(-y, x);

        return orthArray;
    }
}
