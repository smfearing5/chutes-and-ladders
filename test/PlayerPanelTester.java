import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.Player;
import main.Dice;
import graphics.DiceComponent;
import graphics.PlayerPanel;

public class PlayerPanelTester {
    public static void main(String[] args) {
        PlayerPanel panel = new PlayerPanel(
            new Player(1, "test player")
        );

        // Test getPlayer()
        System.out.print("Player Name: ");
        System.out.println(panel.getPlayer().getName());
        System.out.println();

        // Setup window for graphics testing
        JFrame frame = new JFrame();
        frame.setTitle("PlayerPanel Tester");
        frame.setSize(140, 195);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        // Test DiceComponent methods
        Dice dice = new Dice(38, 8);
        DiceComponent diceImage = new DiceComponent(dice);

        TesterDelay.process("Adding DiceComponent");
        panel.addDiceComponent(diceImage);
        panel.update();
        TesterDelay.process("Removing DiceComponent");
        panel.removeDiceComponent(diceImage);
        panel.update();
        System.out.println();

        // Test Button methods
        JButton button = new JButton("test");

        TesterDelay.process("Adding Button");
        panel.addButton(button);
        panel.update();
        TesterDelay.process("Removing Button");
        panel.removeButton(button);
        panel.update();
        System.out.println();

        // Test Label methods
        JLabel label = new JLabel("         test label");

        TesterDelay.process("Adding Label");
        panel.addLabel(label);
        panel.update();
        TesterDelay.process("Removing Label");
        panel.removeLabel(label);
        panel.update();
        System.out.println();

        // Test end of game methods
        TesterDelay.process("Displaying Score");
        panel.displayScore();
        panel.update();
        TesterDelay.process("Labeling Winner");
        panel.labelWinner();
        panel.update();
    }
}
