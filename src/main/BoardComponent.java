package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class BoardComponent extends JComponent {
    // Instance Variables
    Board board;
    Player[] players;
    
    // Constructor
    public BoardComponent(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    // Methods
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Draw squares
        for (int i=1; i <= 100; i++) {
            board.getSquare(i).draw(g2);
        }

        // Draw Chutes
        Chute chute;
        for (int i=1; i <= 100; i++) {
            chute = board.getSquare(i).getChute();
            if (chute != null) {
                chute.draw(
                    board.getSquare(chute.getTopPosition()),
                    board.getSquare(chute.getBottomPosition()), 
                    g2
                );
            }
        }
        // Draw Ladders
        Ladder ladder;
        for (int i=1; i <= 100; i++) {
            ladder = board.getSquare(i).getLadder();
            if (ladder != null) {
                ladder.draw(
                    board.getSquare(ladder.getBottomPosition()), 
                    board.getSquare(ladder.getTopPosition()),
                    g2
                );
            }
        }

        // Draw Players
        for (Player player : players) {
            player.draw(g2);
        }
    }
}
