import java.util.Scanner;

import javax.swing.JFrame;

import main.Player;
import main.Settings;

public class PanelTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers = in.nextInt();
        in.close();
        Player[] players = new Player[numPlayers];

        String playerName;
        for (int i = 0; i < numPlayers; i++) {
            switch (i) {
                case 0:
                    playerName = "Issac";
                    break;
                case 1:
                    playerName = "Steven";
                    break;
                case 2:
                    playerName = "Jacob";
                    break;
                case 3:
                    playerName = "Kaitlyn";
                    break;
                default:
                    playerName = "SWITCH DEFAULT";
                    break;
            }
            players[i] = new Player(i+1, playerName);
        }

        JFrame frame = new JFrame();
        frame.setTitle("Panel Tester");
        frame.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ControlPanel controlPanel = new ControlPanel(players);
        controlPanel.setBounds(
            0, 
            (Settings.WINDOW_SIZE * 3) / 4, 
            Settings.WINDOW_SIZE, 
            (Settings.WINDOW_SIZE) / 4
        );
        frame.add(controlPanel);
        frame.setVisible(true);

        Player currentPlayer;
        boolean winner = false;
        do {
            currentPlayer = controlPanel.getCurrentPlayer();
            while (controlPanel.isWaitingForRoll()) {
                // wait for roll
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();;
                }
            }

            System.out.print("Player " + currentPlayer.getID());
            System.out.print(": " + currentPlayer.getName());
            System.out.println(" rolled a " + controlPanel.getRoll());
            currentPlayer.setPosition(
                currentPlayer.getPosition() + controlPanel.getRoll()
            );

            // Simulate Game interaction
            System.out.print("Moving player");
            for (int i = 1; i <= 3; i++) {
                System.out.print(" .");
                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();;
                }
            }
            System.out.println();

            if (currentPlayer.getPosition() < 20) {
                controlPanel.nextTurn();
            }
            else winner = true;
        } while(!winner);
        // end of game loop
        controlPanel.endGame();
    }
}