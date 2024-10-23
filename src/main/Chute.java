package main;

import java.awt.Color;
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
  
    /**
     * draws the chute
     * @param startSquare
     * @param endSquare
     * @param g2 
     */
    public void draw(Square startSquare, Square endSquare, Graphics2D g2) {
        Point2D p1 = startSquare.getCenter();
        Point2D p2 = endSquare.getCenter();
        Line2D line = new Line2D.Double(p1, p2);

        g2.setColor(Color.blue);
        g2.draw(line);
    }
}
