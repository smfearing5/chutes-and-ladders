import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class DiceComponent extends JComponent {
    // Instance Variable
    Dice dice;

    // Constructor
    public DiceComponent(Dice dice) {
        this.dice = dice;
    }

    // Methods
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        dice.draw(g2);
    }
    public void update() {repaint();}
}