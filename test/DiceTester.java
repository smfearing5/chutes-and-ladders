import javax.swing.JFrame;

public class DiceTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Dice Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dice dice = new Dice(50, 35);
        DiceComponent diceImage = new DiceComponent(dice);
        dice.roll();
        System.out.println(dice.getSide());
        frame.add(diceImage);

        frame.setVisible(true);
    }
}
