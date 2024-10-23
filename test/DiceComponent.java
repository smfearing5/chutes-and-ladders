import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
/**
 * 
 * @author kaitlyn
 */
public class DiceComponent extends JComponent {
    // Instance Variable
    Dice dice;

    // Constructor
    /**
     * constructor of the dice component
     * @param dice dice object
     */
    public DiceComponent(Dice dice) {
        this.dice = dice;
    }

    // Methods
    /**
     * method that draws the component
     * @param g graphics object
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        dice.draw(g2);
    }
    /**
     * updates the drawing when changes are made
     */
    public void update() {repaint();}
}