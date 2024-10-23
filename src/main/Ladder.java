package main;

import java.awt.Color;
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
    /**
     * draws the ladder
     * @param startSquare starting square
     * @param endSquare ending square
     * @param g2 graphics object
     */
    public void draw(Square startSquare, Square endSquare, Graphics2D g2) {
        Point2D p1 = startSquare.getCenter();
        Point2D p2 = endSquare.getCenter();
        Line2D line = new Line2D.Double(p1, p2);

        g2.setColor(Color.red);
        g2.draw(line);
    }
}
