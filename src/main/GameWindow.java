package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
// import javax.swing.JLabel;

public class GameWindow extends JFrame {
    // Constants
    private static final int FRAME_SIZE = 1000;
    // Instance Variables
    private BoardComponent boardImage;

    public GameWindow(Board bourd, Player[] players) {
        setSize(FRAME_SIZE, FRAME_SIZE);
        setTitle("Chutes and Ladders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel title = new JLabel("Chutes and Ladders");
        // add(title, BorderLayout.NORTH);

        boardImage = new BoardComponent(bourd, players);
        add(boardImage, BorderLayout.CENTER);
    }

    public void playerStep(Player player, Board board, int newPos) {
        player.moveToSquare(board.getSquare(newPos));
        try {
            Thread.sleep(WindowSettings.PLAYER_STEP_DELAY);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();;
        }
        repaint();
    }

    public void playerWalk(Player player, Board board, int newPos) {
        int currentSquareID = player.getPosition();
        while (player.getPosition() != newPos) {
            currentSquareID++;
            playerStep(player, board, currentSquareID);
        }
    }
}