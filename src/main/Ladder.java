package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class Ladder {
    
    private int start;
    private int end;
    
    public Ladder(int pos1, int pos2) {
        this.start = pos1;
        this.end = pos2;
    }
    
    public int getBottomPosition(){
        return start;
    }
    
    public void setBottomPosition(int pos) {
        this.start = pos;
    }
    
    public int getTopPosition() {
        return end;
    }
    
    public void setTopPosition(int pos) {
        this.end = pos;
    }
    
    public int climb(int from) {
        return this.end;
    }
    
    public void draw(Square startSquare, Square endSquare, Graphics2D g2) {
        Point2D p1 = startSquare.getCenter();
        Point2D p2 = endSquare.getCenter();
        Line2D line = new Line2D.Double(p1, p2);

        g2.setColor(Color.red);
        g2.draw(line);
    }
}
