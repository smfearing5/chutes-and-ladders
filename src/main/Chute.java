package main;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/**
 * 
 * @author kaitlyn
 */
public class Chute {
    
    private int start;
    private int end;
    private Line2D line1;
    private Line2D line2;

    /**
     * chute constructor
     * @param pos1 ID of pos 1
     * @param pos2 ID of pos 2
     */
    public Chute(int pos1, int pos2) {
        this.start = pos1;
        this.end = pos2;
    }
    /**
     * 
     * @return the ID of the top square
     */
    public int getTopPosition() {
        return start;
    }
    /**
     * sets the position of whatever is the top param 
     * @param pos position of the top square
     */
    public void setTopPosition(int pos) {
        this.start = pos;
    }
    /**
     * 
     * @return the ID of the bottom square
     */
    public int getBottomPosition() {
        return end;
    }
    /**
     * sets the position of whatever is the bottom param
     * @param pos 
     */
    public void setBottomPosition(int pos) {
        this.end = pos;
    }
   
  
    public int slide(int from) {
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
    }
  
    /**
     * draws the chute
     * @param startSquare
     * @param endSquare
     * @param g2 
     */
    public void draw(Square startSquare, Square endSquare, Graphics2D g2) {
        g2.setColor(WindowSettings.CHUTE_COLOR);
        g2.draw(line1);
        g2.draw(line2);
    }
}
