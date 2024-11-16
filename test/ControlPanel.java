import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Player;
import main.Settings;

/**
 * This is a class for the ControlPanel used to play the game
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class ControlPanel extends JPanel {
    
    // Instance Variables

    private int currentPlayerIndex;
    private boolean waitingForRoll;
    private boolean autoplay;
    private Dice dice;
    private DiceComponent diceImage;
    private JLabel yourTurn;
    private JButton rollButton;
    private JButton autoplayButton;
    private ActionListener rollButtonClick;
    private ActionListener autoplayButtonClick;
    private PlayerPanel[] playerPanels;

    // ActionListener Implementation

    private class RollButtonListener implements ActionListener {
        // Instance Variables
        private PlayerPanel panel;

        // Constructor
        public RollButtonListener(PlayerPanel panel) {
            this.panel = panel;
        }

        // Abstract Method Overwrite
        public void actionPerformed(ActionEvent event) {
            dice.roll();
            panel.removeButton(rollButton);
            panel.removeLabel(yourTurn);
            panel.addDiceComponent(diceImage);
            panel.update();
            waitingForRoll = false;
        }
    }
    private class AutoplayListener implements ActionListener {
        // Abstract Method Overwrite
        public void actionPerformed(ActionEvent event) {
            autoplay = !autoplay;

            if (waitingForRoll) {
                waitingForRoll = false;
                PlayerPanel currentPanel = playerPanels[currentPlayerIndex];
                currentPanel.removeButton(rollButton);
                currentPanel.removeLabel(yourTurn);
                autoplayTurn(currentPanel);
            }
        }
    }

    // Private Methods

    private void addFiller(int numPlayers) {
        Dimension minSize = new Dimension(10, 10);
        Dimension prefSize = new Dimension(140, 150);
        Dimension maxSize = new Dimension(210, 200);
        double caseWidth;

        switch (numPlayers) {
            case 2:
                caseWidth = Settings.WINDOW_SIZE * .208;
                prefSize.setSize(caseWidth, 200);
                maxSize.setSize(caseWidth, 200);
                break;
            case 3:
                caseWidth = Settings.WINDOW_SIZE * .12;
                prefSize.setSize(caseWidth, 200);
                maxSize.setSize(caseWidth, 200);
                break;
            case 4:
                caseWidth = Settings.WINDOW_SIZE * .068;
                prefSize.setSize(caseWidth, 200);
                maxSize.setSize(caseWidth, 200);
                break;
            default:
                System.out.println("ERROR: Unexpected number of players");
                break;
        }

        this.add(new Box.Filler(minSize, prefSize, maxSize));
    }
    private int nextPlayerIndex() {
        if (currentPlayerIndex == playerPanels.length - 1) {
            // Last player back to first player
            return 0;
        }
        else {
            // Next player
            return currentPlayerIndex + 1;
        }
    }
    private void setupPlayerTurn() {
        PlayerPanel currentPanel = playerPanels[currentPlayerIndex];

        rollButtonClick = new RollButtonListener(currentPanel);
        rollButton = new JButton("Click to roll");
        rollButton.addActionListener(rollButtonClick);
        currentPanel.addButton(rollButton);
        currentPanel.addLabel(yourTurn);
        currentPanel.update();
        waitingForRoll = true;
    }
    private void autoplayTurn(PlayerPanel currentPanel) {
        dice.roll();
        currentPanel.addDiceComponent(diceImage);
        currentPanel.update();
    }

    /* Public Interface */

    // Constructor

    /**
     * Constructor for the ControlPanel object
     * @param players Array of Player objects
     */
    public ControlPanel(Player[] players) {
        autoplay = false;
        dice = new Dice(38, 8);
        diceImage = new DiceComponent(dice);

        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        int numPlayers = players.length;
        playerPanels = new PlayerPanel[numPlayers];

        addFiller(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            playerPanels[i] = new PlayerPanel(players[i]);
            add(playerPanels[i]);
            addFiller(numPlayers);
        }

        autoplayButtonClick = new AutoplayListener();
        autoplayButton = new JButton("Autoplay");
        autoplayButton.addActionListener(autoplayButtonClick);
        autoplayButton.setAlignmentY((float) 0.35);
        add(autoplayButton);

        currentPlayerIndex = 0;
        yourTurn = new JLabel("         Your Turn");
        setupPlayerTurn();
    }

    // Accessors

    /**
     * Returns true when ControlPanel is waiting for a player to click the roll button
     * @return boolean value
     */
    public boolean isWaitingForRoll() {
        return waitingForRoll;
    }

    /**
     * Returns the Player object for the current turn
     * @return Current Player object
     */
    public Player getCurrentPlayer() {
        return playerPanels[currentPlayerIndex].getPlayer();
    }
    /**
     * Returns the value of the dice roll
     * @return int value for dice roll
     */
    public int getRoll() {
        return dice.getSide();
    }

    // Other Methods

    /**
     * Tells the ControlPanel to begin the next turn
     */
    public void nextTurn() {
        PlayerPanel currentPanel = playerPanels[currentPlayerIndex];
        currentPanel.removeDiceComponent(diceImage);
        currentPanel.update();

        currentPlayerIndex = nextPlayerIndex();
        currentPanel = playerPanels[currentPlayerIndex]; // might still need?

        if (autoplay) autoplayTurn(currentPanel);
        else setupPlayerTurn();
    }

    /**
     * Tells the ControlPanel to end the game and display scores and winner
     */
    public void endGame() {
        PlayerPanel currentPanel = playerPanels[currentPlayerIndex];
        currentPanel.removeDiceComponent(diceImage);
        currentPanel.labelWinner();

        for (PlayerPanel panel : playerPanels) {
            panel.displayScore();
        }

        currentPanel.update();
    }
}
