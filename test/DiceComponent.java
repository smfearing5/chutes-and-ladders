import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * An extension of the JComponent class for drawing a Dice object
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class DiceComponent extends JComponent {

    // Instance Variable
    
    private Dice dice;

    // Constructor

    /**
     * Constructor for the DiceComponent object
     * @param dice dice object
     */
    public DiceComponent(Dice dice) {
        this.dice = dice;
    }

    // Methods

    /**
     * Method used to draw the Dice object
     * Overwrites the paintComponent method of the JComponent class
     * @param g The default graphics object used by the JComponent class
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        dice.draw(g2);
    }
}