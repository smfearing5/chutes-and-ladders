import java.awt.geom.*;

import main.Player;

public class PlayerTester {
    public static void main(String[] args) {
        Player player = new Player(1, "p1");
        // Testing Player position 
        player.setPosition(10); 
        assert player.getPosition() == 10 : "setPosition() failed"; 
        System.out.println("Test Case 1 passed.");
        
        // Testing set name
        player.setName("Bob"); 
        assert player.getName().equals("Bob") : "setName() failed"; 
        System.out.println("Test Case 2 passed.");
        
        // Testing set location using integers 
        player.setLocation(100, 200); 
        assert player.getLocation().equals(new Point2D.Double(100, 200)) : "setLocation(int, int) failed"; 
        System.out.println("Test Case 3 passed.");
        
        // Testing set location using Point2D 
        Point2D newLocation = new Point2D.Double(150, 250); 
        player.setLocation(newLocation); 
        assert player.getLocation().equals(newLocation) : "setLocation(Point2D) failed"; 
        System.out.println("Test Case 4 passed.");
        
        
    }
}