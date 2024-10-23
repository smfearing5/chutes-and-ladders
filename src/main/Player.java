package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
/**
 * 
 * @author kaitlyn
 */
public class Player {
    private int id;
    private int position;
    private String name;
    private Color color;
    private Point2D location;
    
    // public Player() {
    //     this.position = 0;
    // }
    /**
     * constructor for the player object
     * @param playerID ID number
     * @param name name of the player
     */
    public Player(int playerID, String name) {
        this.id = playerID;
        this.name = name;
        this.position = 0;
        this.color = WindowSettings.PLAYER_COLORS[playerID % 4];
        this.location = WindowSettings.PLAYER_START[playerID % 4];
    }
/**
 * getter for the ID
 * @return the ID
 */
    public int getID() {return id;}
    /**
     * getter for the name
     * @return the name
     */
    public String getName() {
        return name;
    }
   /**
    * setter for the name
    * @param name player name
    */ 
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for the position
     * @return the position
     */
    public int getPosition() {
        return position;
    }
    /**
     * setter for the position
     * @param pos the position
     */
    public void setPosition(int pos) {
        this.position = pos; 
    }

    private Point2D getCorner() {
        Point2D corner = new Point2D.Double(
            location.getX() + WindowSettings.PLAYER_RADIUS,
            location.getY() + WindowSettings.PLAYER_RADIUS
        );

        return corner;
    }
/**
 * movement of the player to the target square
 * @param square target square
 */
    public void moveToSquare(Square square) {
        setPosition(square.getId());
        this.location = square.getCenter();
    }
/**
 * draws the player
 * @param g2 graphics object
 */
    public void draw(Graphics2D g2) {
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(location, getCorner());
        g2.setColor(color);
        g2.fill(circle);
        g2.setColor(Color.black);
        g2.draw(circle);
    }
}
