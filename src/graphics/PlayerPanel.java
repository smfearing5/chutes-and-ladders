package graphics;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Player;
import main.Settings;

/**
 * This is a class for the display panel for each player
 * @author Issac Blackwell
 * @author Steven Fearing
 * @author Jacob Plascencia
 * @author Kaitlyn Pragnell
 */
public class PlayerPanel extends JPanel {

    // Instance Variables

    private Player player;
    private Color color;
    private JPanel infoPanel;
    private JPanel dicePanel;
    private JPanel buttonPanel;
    private JLabel[] playerInfo;

    // Private Methods

    private Color panelColor(Color playerColor) {
        int r = playerColor.getRed();
        int g = playerColor.getGreen();
        int b = playerColor.getBlue();

        r = r + (255 - r)/3;
        g = g + (255 - g)/3;
        b = b + (255 - b)/3;

        return new Color(r, g, b);
    }

    /* Public Interface */

    // Constructor

    /**
     * Constructor for the PlayerPanel object.
     * @param player Player object associated with this PlayerPanel
     */
    public PlayerPanel(Player player) {
        this.player = player;
        color = panelColor(player.getColor());
    
        setSize(Settings.PLAYER_PANEL_WIDTH, Settings.PLAYER_PANEL_HEIGHT);
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        infoPanel = new JPanel();
        infoPanel.setBackground(color);
        infoPanel.setBounds(0, 0, Settings.PLAYER_PANEL_WIDTH, Settings.PLAYER_PANEL_HEIGHT/4);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));

        playerInfo = new JLabel[2];
        playerInfo[0] = new JLabel("Player " + player.getID());
        playerInfo[1] = new JLabel(player.getName());
        for (JLabel label : playerInfo) {
            label.setAlignmentX((float) 0.5);
            label.setAlignmentY((float) 0.5);
            infoPanel.add(label);
        }
        add(infoPanel);

        dicePanel = new JPanel();
        dicePanel.setBackground(color);
        dicePanel.setLayout(new BorderLayout());
        dicePanel.setBounds(
            0, 
            Settings.PLAYER_PANEL_HEIGHT/4, 
            Settings.PLAYER_PANEL_WIDTH, 
            Settings.PLAYER_PANEL_HEIGHT/2
        );
        add(dicePanel);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(color);
        buttonPanel.setBounds(
            0, 
            Settings.PLAYER_PANEL_HEIGHT*3/4, 
            Settings.PLAYER_PANEL_WIDTH, 
            Settings.PLAYER_PANEL_HEIGHT/4
        );
        add(buttonPanel);
    }

    // Accessors

    /**
     * Returns the Player object associated with this PlayerPanel
     * @return Player object associated with this PlayerPanel
     */
    public Player getPlayer() {
        return player;
    }

    // Mutators

    /**
     * Adds a component to the PlayerPanel to display the dice roll
     * @param diceImage DiceComponent object
     */
    public void addDiceComponent(DiceComponent diceImage) {
        dicePanel.add(diceImage);
    }

    /**
     * Removes the dice component from the PlayerPanel
     * @param diceImage DiceComponent object
     */
    public void removeDiceComponent(DiceComponent diceImage) {
        dicePanel.remove(diceImage);
    }

    /**
     * Adds a JButton component to the PlayerPanel
     * @param button JButton object
     */
    public void addButton(JButton button) {
        buttonPanel.add(button);
    }

    /**
     * Removes a JButton component from the PlayerPanel
     * @param button JButton object
     */
    public void removeButton(JButton button) {
        buttonPanel.remove(button);
    }

    /**
     * Adds a JLabel component to the PlayerPanel
     * @param label JLabel object
     */
    public void addLabel(JLabel label) {
        dicePanel.add(label);
    }

    /**
     * Removes a JLabel component from the PlayerPanel
     * @param label JLabel object
     */
    public void removeLabel(JLabel label) {
        dicePanel.remove(label);
    }

    /**
     * Adds a label to the PlayerPanel to display the Player's score
     */
    public void displayScore() {
        String scoreText = "          Score: " + player.getPosition();
        addLabel(new JLabel(scoreText));
    }

    /**
     * Adds a label to the PlayerPanel to show which Player won the game
     */
    public void labelWinner() {
        buttonPanel.add(new JLabel("Winner!"));
    }

    /**
     * Updates the display with changes to the PlayerPanel
     */
    public void update() {
        buttonPanel.repaint();
        dicePanel.repaint();
        revalidate();
        repaint();
    }
}
