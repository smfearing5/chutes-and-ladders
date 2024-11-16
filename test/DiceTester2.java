import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Dice;
import graphics.DiceComponent;

public class DiceTester2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 240);
        frame.setTitle("Dice Tester");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dice dice = new Dice(70, 50);
        DiceComponent diceImage = new DiceComponent(dice);

        JPanel dicePanel = new JPanel();
        dicePanel.setBackground(Color.red);
        dicePanel.setLayout(new BorderLayout());
        dicePanel.setBounds(0, 0, 200, 160);
        dicePanel.add(diceImage);
        frame.add(dicePanel);

        JButton rollButton = new JButton("Click to roll");
        class RollButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                dice.roll();
                diceImage.repaint();
                System.out.println(dice.getSide());
            }
        }
        ActionListener clickListener = new RollButtonListener();
        rollButton.addActionListener(clickListener);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 160, 200, 40);
        buttonPanel.add(rollButton);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
