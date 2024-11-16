package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Random;
/**
 * 
 * @author kaitlyn
 */
public class Dice {

    // Constants

    final int DIE_SIZE = 60;            // Should be multiple of 20 for int division
    final int DOT_SIZE = DIE_SIZE/5;

    // Instance Variables

    private final Random random;
    private int x;
    private int y;
    private int side;
    // Image Variables
    private Rectangle die;
    private Ellipse2D[] dots;

    // Private Methods

    private void buildImage() {
        final Point2D[] DOT_LOCATIONS = {
            new Point2D.Double(x + DIE_SIZE/2, y + DIE_SIZE/2),     // index 0, center dot
            new Point2D.Double(x + DIE_SIZE/4, y + DIE_SIZE/4),     // index 1, top left dot
            new Point2D.Double(x + DIE_SIZE/4, y + DIE_SIZE/2),     // index 2, middle left dot
            new Point2D.Double(x + DIE_SIZE/4, y + DIE_SIZE*3/4),   // index 3, bottom left dot
            new Point2D.Double(x + DIE_SIZE*3/4, y + DIE_SIZE/4),   // index 4, top right dot
            new Point2D.Double(x + DIE_SIZE*3/4, y + DIE_SIZE/2),   // index 5, middle right dot
            new Point2D.Double(x + DIE_SIZE*3/4, y + DIE_SIZE*3/4), // index 6, bottom right dot
        };

        die = new Rectangle(x, y, DIE_SIZE, DIE_SIZE);

        dots = new Ellipse2D[7];
        Point2D ellipseCenter;
        Point2D ellipseCorner;
        for (int i = 0; i < 7; i++) {
            ellipseCenter = DOT_LOCATIONS[i];
            ellipseCorner = new Point2D.Double(
                ellipseCenter.getX() + DOT_SIZE/2,
                ellipseCenter.getY() + DOT_SIZE/2
            );
            dots[i] = new Ellipse2D.Double();
            dots[i].setFrameFromCenter(ellipseCenter, ellipseCorner);
        }
    }

    /* Public Interface */

    // Constructors
    /**
     * constructor of the dice
     * @param xPos position of x of the dice
     * @param yPos position of y of the dice
     */
    public Dice(int xPos, int yPos) {
        random = new Random();
        x = xPos;
        y = yPos;
        side = 6;

        buildImage();
    }

    // Methods
    // Accessors
    /**
     * getter for x
     * @return x
     */
    public int getX() {return x;}
    /**
     * getter for y
     * @return y
     */
    public int getY() {return y;}
    /**
     * getter for the side of the dice
     * @return the side of the dice
     */
    public int getSide() {return side;}

    // Mutators
    /**
     * setter for the position dice
     * @param x x position
     * @param y y position
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;

        buildImage();
    }
    /**
     * rolls the dice
     */
    public void roll() {
        side = random.nextInt(1, 7);
    }

    // Other Methods

    /**
     * draws the dice
     * @param g2 graphics object
     */
    public void draw(Graphics2D g2) {
        // Draw the die
        g2.setColor(Color.white);
        g2.fill(die);
        g2.setColor(Color.black);
        g2.draw(die);

        // Draw the dots
        if (side % 2 == 1) {
            // Draw center dot
            g2.fill(dots[0]);
        }
        if (side != 1) {
            g2.fill(dots[3]);
            g2.fill(dots[4]);
        }
        if (side > 3) {
            g2.fill(dots[1]);
            g2.fill(dots[6]);
        }
        if (side == 6) {
            g2.fill(dots[2]);
            g2.fill(dots[5]);
        }
    }
}