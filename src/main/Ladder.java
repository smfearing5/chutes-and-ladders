package main;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * 
 * @author kaitlyn
 */
public class Ladder {
    
    private int start;
    private int end;
    private Line2D line1;
    private Line2D line2;
    private Line2D[] rungs;
   /**
    * constructor of the ladder
    * @param pos1 ladder starting square
    * @param pos2 ladder ending square
    */
    public Ladder(int pos1, int pos2) {
        this.start = pos1;
        this.end = pos2;
    }
    /**
     * method to return the bottom position
     * @return bottom position
     */
    public int getBottomPosition(){
        return start;
    }
    /**
     * setter for the bottom position
     * @param pos bottom position
     */
    public void setBottomPosition(int pos) {
        this.start = pos;
    }
    /**
     * method to return the top position
     * @return the top position
     */
    public int getTopPosition() {
        return end;
    }
    /**
     * setter for the top position
     * @param pos top position
     */
    public void setTopPosition(int pos) {
        this.end = pos;
    }
   
    public int climb(int from) {
        return this.end;
    }

    public void buildImage(Square startSquare, Square endSquare) {
        Point2D anchor1 = startSquare.getAnchor(endSquare.getCenter());
        Point2D anchor2 = endSquare.getAnchor(startSquare.getCenter());
        Vector vector = new Vector(anchor1, endSquare.getCenter());
        vector.setMagnitude(WindowSettings.CONNECTOR_WIDTH/2.0);
        Vector[] orthogonal = vector.orthogonal();

        Point2D p1 = orthogonal[0].getPointFrom(anchor1);
        Point2D p2 = orthogonal[0].getPointFrom(anchor2);
        this.line1 = new Line2D.Double(p1, p2);

        Point2D p3 = orthogonal[1].getPointFrom(anchor1);
        Point2D p4 = orthogonal[1].getPointFrom(anchor2);
        this.line2 = new Line2D.Double(p3, p4);

        vector = new Vector(p1, p2);
        int numRungs = (int) vector.getMagnitude() / WindowSettings.CONNECTOR_WIDTH;
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


    /**
     * draws the ladder
     * @param startSquare starting square
     * @param endSquare ending square
     * @param g2 graphics object
     */
    public void draw(Square startSquare, Square endSquare, Graphics2D g2) {
        g2.setColor(WindowSettings.LADDER_COLOR);
        g2.draw(line1);
        g2.draw(line2);
        for (Line2D rung : rungs) {
            g2.draw(rung);
        }
    }
}
