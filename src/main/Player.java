package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Player {
    private int id;
    private int position;
    private String name;
    private Color color;
    private Point2D location;
    
    // public Player() {
    //     this.position = 0;
    // }
    
    public Player(int playerID, String name) {
        this.id = playerID;
        this.name = name;
        this.position = 0;
        this.color = WindowSettings.PLAYER_COLORS[playerID % 4];
        this.location = WindowSettings.PLAYER_START[playerID % 4];
    }

    public int getID() {return id;}
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPosition() {
        return position;
    }
    
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

    public void moveToSquare(Square square) {
        setPosition(square.getId());
        this.location = square.getCenter();
    }

    public void draw(Graphics2D g2) {
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(location, getCorner());
        g2.setColor(color);
        g2.fill(circle);
        g2.setColor(Color.black);
        g2.draw(circle);
    }
}
