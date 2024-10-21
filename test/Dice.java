import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Random;

public class Dice {
    // Instance Variables
    private Random random;
    private int x;
    private int y;
    private int side;

    // Constructors
    public Dice(int xPos, int yPos) {
        random = new Random();
        x = xPos;
        y = yPos;
        side = 6;
    }

    // Methods
    // Accessors
    public int getX() {return x;}
    public int getY() {return y;}
    public int getSide() {return side;}

    // Mutators
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void roll() {
        side = random.nextInt(1, 7);
    }

    // Other Methods
    private class Dot {
        // Instance Variables
        double size;
        Point2D center;

        // Constructor
        public Dot(double size) {
            this.size = size;
            center = new Point2D.Double();
        }

        // Accessors
        // public double getSize() {return size;}
        // public Point2D getCenter() {return center;}
        private Point2D getCorner() {
            return new Point2D.Double(center.getX() + size/2, center.getY() + size/2);
        }
        public Ellipse2D getEllipse() {
            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrameFromCenter(center, getCorner());
            return ellipse;
        }

        // Mutators
        public void setCenter(Point2D newCenter) {center = newCenter;}
    }
    public void draw(Graphics2D g2) {
        final int DIE_SIZE = 100;       // Should be multiple of 20 for int division
        final int DOT_SIZE = DIE_SIZE/5;
        Rectangle die = new Rectangle(x, y, DIE_SIZE, DIE_SIZE);
        Dot dot = new Dot(DOT_SIZE);

        // Define dot locations
        final Point2D[] DOT_LOCATIONS = {
            new Point2D.Double(x + DIE_SIZE/2, y + DIE_SIZE/2),     // index 0, center dot
            new Point2D.Double(x + DIE_SIZE/4, y + DIE_SIZE/4),     // index 1, top left dot
            new Point2D.Double(x + DIE_SIZE/4, y + DIE_SIZE/2),     // index 2, middle left dot
            new Point2D.Double(x + DIE_SIZE/4, y + DIE_SIZE*3/4),   // index 3, bottom left dot
            new Point2D.Double(x + DIE_SIZE*3/4, y + DIE_SIZE/4),   // index 4, top right dot
            new Point2D.Double(x + DIE_SIZE*3/4, y + DIE_SIZE/2),   // index 5, middle right dot
            new Point2D.Double(x + DIE_SIZE*3/4, y + DIE_SIZE*3/4), // index 6, bottom right dot
        };

        // Draw the die
        g2.setColor(Color.white);
        g2.fillRect(die.x, die.y, die.width, die.height);
        g2.setColor(Color.black);
        g2.draw(die);

        // Draw the dots
        if (side % 2 == 1) {
            // Draw center dot
            dot.setCenter(DOT_LOCATIONS[0]);
            g2.fill(dot.getEllipse());
        }
        if (side != 1) {
            dot.setCenter(DOT_LOCATIONS[3]);
            g2.fill(dot.getEllipse());
            dot.setCenter(DOT_LOCATIONS[4]);
            g2.fill(dot.getEllipse());
        }
        if (side > 3) {
            dot.setCenter(DOT_LOCATIONS[1]);
            g2.fill(dot.getEllipse());
            dot.setCenter(DOT_LOCATIONS[6]);
            g2.fill(dot.getEllipse());
        }
        if (side == 6) {
            dot.setCenter(DOT_LOCATIONS[2]);
            g2.fill(dot.getEllipse());
            dot.setCenter(DOT_LOCATIONS[5]);
            g2.fill(dot.getEllipse());
        }
    }
}