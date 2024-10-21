package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class Square {
    
    private int id;
    private Ladder ladder;
    private Chute chute;

    private int row;
    private int col;
    
    // public Square() {
    //     this.id = 0;
    //     this.ladder = null;
    //     this.chute = null;
    // }
    
    public Square(int id, int row, int col){
        this.id = id;
        this.ladder = null;
        this.chute = null;

        this.row = row;
        this.col = col;
    }
    
    // Issac's getters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Ladder getLadder() {
        return ladder;
    }
    
    public Chute getChute() {
        return chute;
    }

    // Steven's Getters
    public int getRow() {return row;}
    public int getCol() {return col;}
    private int getX() {
        return WindowSettings.BOARD_X + col * WindowSettings.SQUARE_SIZE;
    }
    private int getY() {
        return WindowSettings.BOARD_Y + row * WindowSettings.SQUARE_SIZE;
    }
    public Point2D getCenter() {
        int x = getX() + WindowSettings.SQUARE_SIZE/2;
        int y = getY() + WindowSettings.SQUARE_SIZE/2;

        return new Point2D.Double(x, y);
    }

    // Issac's Setters
    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
    
    public void setChute(Chute chute) {
        this.chute = chute;
    }
    
    // Steven's Setters
    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // Other Methods
    public void draw(Graphics2D g2) {
        Rectangle rectangle = new Rectangle(
            getX(), getY(),                 // x position, y position
            WindowSettings.SQUARE_SIZE,     // width
            WindowSettings.SQUARE_SIZE      // height
        );
        g2.draw(rectangle);
    }
}