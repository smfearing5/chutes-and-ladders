package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
/**
 * 
 * @author kaitlyn
 */
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
    /**
     * constructor for the square
     * @param id ID number
     * @param row row that this square is in
     * @param col the col that this square is in
     */
    public Square(int id, int row, int col){
        this.id = id;
        this.ladder = null;
        this.chute = null;

        this.row = row;
        this.col = col;
    }
    
    // Issac's getters
    /**
     * getter of the ID
     * @return the ID
     */
    public int getId() {
        return id;
    }
   
   /**
    * setter of the ID
    * @param id  the ID
    */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * getter of the ladder
     * @return the ladder
     */
    public Ladder getLadder() {
        return ladder;
    }
    /**
     * getter of the chute
     * @return the chute
     */
    public Chute getChute() {
        return chute;
    }

    // Steven's Getters
    /**
     * getter for the row
     * @return the row
     */
    public int getRow() {return row;}
    /**
     * getter for the col
     * @return the col
     */
    public int getCol() {return col;}
    private int getX() {
        return WindowSettings.BOARD_X + col * WindowSettings.SQUARE_SIZE;
    }
    private int getY() {
        return WindowSettings.BOARD_Y + row * WindowSettings.SQUARE_SIZE;
    }
    /**
     * getter for the center
     * @return point at the center of the square
     */
    public Point2D getCenter() {
        int x = getX() + WindowSettings.SQUARE_SIZE/2;
        int y = getY() + WindowSettings.SQUARE_SIZE/2;

        return new Point2D.Double(x, y);
    }

    // Issac's Setters
    /**
     * setter for the ladder
     * @param ladder the ladder
     */
    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
   
     /**
     * setter for the chute
     * @param chute the chute
     */
    public void setChute(Chute chute) {
        this.chute = chute;
    }
    
    // Steven's Setters
    /**
     * setter for the row
     * @param row the row
     */
    public void setRow(int row) {
        this.row = row;
    }
/**
 * setter for the col
 * @param col the col
 */
    public void setCol(int col) {
        this.col = col;
    }

    // Other Methods
    /**
     * drawing the square
     * @param g2 graphics object
     */
    public void draw(Graphics2D g2) {
        Rectangle rectangle = new Rectangle(
            getX(), getY(),                 // x position, y position
            WindowSettings.SQUARE_SIZE,     // width
            WindowSettings.SQUARE_SIZE      // height
        );
        g2.draw(rectangle);
    }
}